package net.kunmc.lab.safearea.config

import org.bukkit.Location
import org.bukkit.World

class Status {
    companion object {
        var isEnable = false
        var world: World? = null
        var targetLocation: Location? = null
        var chunkLocation = mutableMapOf<String, Int>("x" to 0, "z" to 0)
    }
}