package me.falsecode.baseplugin

import me.falsecode.baseplugin.command.commands.TestCommand
import me.falsecode.baseplugin.gui.GuiListener
import me.falsecode.baseplugin.utils.MessageUtils
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    lateinit var msgUtils: MessageUtils

    override fun onEnable() {
        msgUtils = MessageUtils(this)
        server.pluginManager.registerEvents(GuiListener(), this)
        TestCommand(this)
    }

}