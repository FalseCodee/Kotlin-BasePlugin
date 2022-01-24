package me.falsecode.baseplugin.gui.guis

import me.falsecode.baseplugin.Main
import me.falsecode.baseplugin.gui.Gui
import me.falsecode.baseplugin.utils.ItemBuilder
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent

class GuiTestScreen(plugin: Main, player: Player) : Gui(plugin, player, 27, "Test Screen!") {
    init {
        init()
    }
    override fun init() {
        super.init()
        for(i in items.indices) {
            items[i] = ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setName("&7Background")
                .build()
        }
        setButton(13, ItemBuilder(Material.REDSTONE_BLOCK)
            .setName("&fClick me!")
            .setLore(listOf("", "&cThis is a lore!"))
            .build()
        ) { player.sendMessage("Bonk!") }
        update()
        openInventory()
    }

    override fun onInventoryClick(event: InventoryClickEvent, gui: Gui) {
        event.isCancelled = true
    }
}