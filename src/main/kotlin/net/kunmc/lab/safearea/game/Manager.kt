package net.kunmc.lab.safearea.game

import net.kunmc.lab.safearea.util.sendMsg

import net.kunmc.lab.safearea.config.Status
import org.bukkit.Bukkit

class Manager {
    fun setSafeArea(x: Int, z: Int) {
        val range = 20 / 4 - 1
        val xRand = (-range..range).random()
        val zRand = (-range..range).random()

        sendMsg("Rand x: $xRand z: $zRand")

        val nextX = x + xRand
        val nextZ = z + zRand
        Status.chunkLocation["x"] = nextX
        Status.chunkLocation["z"] = nextZ

        sendMsg("Loc x: ${Status.chunkLocation["x"]} z: ${Status.chunkLocation["z"]}")

        val chunk = Status.world!!.getChunkAt(nextX, nextZ)
        val centerBlock = chunk.getBlock(7, 62, 7)
        Status.targetLocation = centerBlock.location
    }

    fun checkSafeArea() {
        Bukkit.getOnlinePlayers().forEach {
            val sc = Status.chunkLocation
            val pc = it.chunk
            if(pc.x != sc["x"] && pc.z != sc["z"]) {
                it.damage(10000.0)
            }
        }
    }
}