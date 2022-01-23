package me.falsecode.baseplugin.command

import org.bukkit.command.CommandSender

interface IFalseCommand {
    fun execute(sender:CommandSender, args: Array<out String>)
}