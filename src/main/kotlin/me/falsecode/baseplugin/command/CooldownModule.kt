package me.falsecode.baseplugin.command

import me.falsecode.baseplugin.utils.IRunnable
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import java.util.*
import kotlin.collections.HashMap

class CooldownModule(val command: FalseCommand, private val tickDelay: Int, private val runnable: IRunnable<CommandSender>) : IFalseCommandModule {
    private val cooldown: WeakHashMap<UUID, Long> = WeakHashMap()

    override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>): Boolean {
        if(sender !is Player) return false
        val fullTime = sender.world.fullTime

        if (cooldown.containsKey(sender.uniqueId)) {
            if(fullTime-cooldown[sender.uniqueId]!! > tickDelay) {
                cooldown[sender.uniqueId] = fullTime
                return false
            }
            runnable.execute(sender)
            return true
        }
        cooldown[sender.uniqueId] = fullTime
        return false
    }
}