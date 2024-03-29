package me.falsecode.baseplugin.command.commands

import me.falsecode.baseplugin.Main
import me.falsecode.baseplugin.command.*
import me.falsecode.baseplugin.gui.guis.GuiTestScreen
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import java.util.*

class TestCommand(plugin: Main) : FalseCommand(plugin, "test", "Test Command", "Usage", Collections.singletonList("t")) {

    init {
        addModule(Entrance.PRE, CooldownModule(this, 100) { sender -> sender.sendMessage("Slow down!") })


        addSubCommand(object: IFalseSubCommand {
            override fun getName(): String {
                return "gui"
            }
            override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>) {
                if(sender is Player)
                    GuiTestScreen(plugin, sender)
            }
        })
    }
    override fun execute(sender: CommandSender, args: Array<out String>) {
        if(args.isNotEmpty()) {
            throw CommandUsageException("Do /test gui")
        }

        sender.sendMessage("Hello World!")
    }
}