package net.kunmc.lab.safearea.config

import net.kunmc.lab.safearea.SafeAreaPlugin
import org.bukkit.configuration.file.FileConfiguration

class Config {
    companion object {
        private val plugin = SafeAreaPlugin.plugin
        private var config: FileConfiguration? = null
        private var limit: Int = plugin.config.getInt("limit")

        init {
            load()
        }

        private fun load() {
            plugin.saveDefaultConfig()
            if(config != null) {
                plugin.reloadConfig()
            }
            config = plugin.config
        }

        fun setLimit(_limit: Int) {
            limit = _limit
            config!!.set("limit", limit)
            plugin.saveConfig()
        }

        fun getLimit(): Int {
            return limit
        }
    }
}