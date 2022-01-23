package me.falsecode.baseplugin.command

import org.bukkit.command.CommandSender

interface IFalseSubCommand {
    fun getName():String
    fun execute(sender: CommandSender, commandLabel:String, args: Array<out String>)
}