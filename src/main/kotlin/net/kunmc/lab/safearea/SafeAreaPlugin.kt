package net.kunmc.lab.safearea

import dev.kotx.flylib.command.Command
import dev.kotx.flylib.flyLib
import org.bukkit.plugin.java.JavaPlugin

class SafeAreaPlugin: JavaPlugin() {
    override fun onEnable() {
        flyLib {
            this.command()
        }
    }
}
