package net.kunmc.lab.safearea

import dev.kotx.flylib.command.Permission
import dev.kotx.flylib.flyLib
import org.bukkit.plugin.java.JavaPlugin

import net.kunmc.lab.safearea.command.MainCommand
import net.kunmc.lab.safearea.event.PlayerRespawn

class SafeAreaPlugin: JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }

    override fun onEnable() {
        plugin = this
        flyLib {
            command(MainCommand())
            defaultPermission(Permission.OP)
        }

        server.pluginManager.registerEvents(PlayerRespawn(), this)
    }
}
