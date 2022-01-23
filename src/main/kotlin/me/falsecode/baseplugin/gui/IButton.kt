package me.falsecode.baseplugin.gui

import org.bukkit.event.inventory.InventoryClickEvent

interface IButton {
    fun execute(event:InventoryClickEvent)
}