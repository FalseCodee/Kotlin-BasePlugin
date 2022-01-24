package me.falsecode.baseplugin.gui

import org.bukkit.event.inventory.InventoryClickEvent

fun interface IButton {
    fun execute(event:InventoryClickEvent)
}