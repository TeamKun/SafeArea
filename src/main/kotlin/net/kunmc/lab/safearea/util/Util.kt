package net.kunmc.lab.safearea.util

import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player

fun sendMsg(msg: String) {
    Bukkit.getOnlinePlayers().forEach {
        it.sendMessage(msg)
    }
}

fun playSound(sound: Sound) {
    Bukkit.getOnlinePlayers().forEach {
        it.playSound(it.eyeLocation, sound, 0.4f, 1f)
    }
}

fun getCardinalDirection(player: Player): Int? {
    var rotation: Double = (player.location.yaw.toDouble() - 180) % 360
    if (rotation < 0) {
        rotation += 360.0
    }
    return if (0 <= rotation && rotation < 22.5) {
        6
    } else if (22.5 <= rotation && rotation < 67.5) {
        7
    } else if (67.5 <= rotation && rotation < 112.5) {
        0
    } else if (112.5 <= rotation && rotation < 157.5) {
        1
    } else if (157.5 <= rotation && rotation < 202.5) {
        2
    } else if (202.5 <= rotation && rotation < 247.5) {
        3
    } else if (247.5 <= rotation && rotation < 292.5) {
        4
    } else if (292.5 <= rotation && rotation < 337.5) {
        5
    } else if (337.5 <= rotation && rotation < 360.0) {
        6
    } else {
        null
    }
}
