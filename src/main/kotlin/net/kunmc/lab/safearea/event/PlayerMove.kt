package net.kunmc.lab.safearea.event

import net.kunmc.lab.safearea.config.Status
import net.kunmc.lab.safearea.game.Logic
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class PlayerMove: Listener {
    @EventHandler
    fun onMove(e: PlayerMoveEvent) {
        if(Status.isEnable) {
            Logic().setDistance(e.player)
        }
    }
}