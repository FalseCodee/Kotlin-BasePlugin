package me.falsecode.baseplugin.utils

import org.bukkit.scheduler.BukkitRunnable

class RunUtils {
    companion object {
        fun execute(runnable: IRunnable): BukkitRunnable {
            return object : BukkitRunnable() {
                override fun run() {
                    runnable.execute()
                }
            }
        }
    }
}