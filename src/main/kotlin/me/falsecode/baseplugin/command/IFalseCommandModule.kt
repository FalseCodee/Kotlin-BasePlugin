package me.falsecode.baseplugin.command

import org.bukkit.command.CommandSender

fun interface IFalseCommandModule {
    fun execute(sender: CommandSender, commandLabel:String, args: Array<out String>): Boolean
}

enum class Entrance {
    PRE,
    POST
}
