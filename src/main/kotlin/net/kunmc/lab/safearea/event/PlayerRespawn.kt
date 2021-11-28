package net.kunmc.lab.safearea.event

import net.kunmc.lab.safearea.config.Status
import net.kunmc.lab.safearea.util.sendMsg
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerRespawnEvent

class PlayerRespawn: Listener {

    @EventHandler
    fun onRespawn(e: PlayerRespawnEvent) {
        if(Status.isEnable) {
            e.respawnLocation = Status.targetLocation!!
        }
    }
}