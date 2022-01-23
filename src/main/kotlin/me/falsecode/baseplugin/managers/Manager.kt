package me.falsecode.baseplugin.managers

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.IOException

abstract class Manager(plugin: JavaPlugin, name: String) {
    private val plugin:JavaPlugin
    private val file: File
    private val configFile:FileConfiguration

    init {
        file = File("${plugin.dataFolder}/${name}.yml")
        configFile = YamlConfiguration.loadConfiguration(file)
        this.plugin = plugin
    }

    fun saveFile() {
        try {
            configFile.save(file)
        } catch(exc:IOException) {
            exc.printStackTrace()
        }
    }

    fun getPlugin():JavaPlugin {
        return plugin
    }

    fun getFile():File {
        return file
    }

    fun getConfig():FileConfiguration {
        return configFile
    }
}