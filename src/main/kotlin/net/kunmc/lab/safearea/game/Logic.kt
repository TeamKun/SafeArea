package net.kunmc.lab.safearea.game

import net.kunmc.lab.safearea.config.Config
import net.kunmc.lab.safearea.config.Status
import net.kunmc.lab.safearea.util.getCardinalDirection
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class Logic {
    fun setSafeArea(x: Int, z: Int) {
        val limit = Config.getLimit()
        val range = (limit / 10) + 1

        val xRand = (-range..range).random()
        val zRand = (-range..range).random()
        val nextX = x + xRand
        val nextZ = z + zRand
        Status.chunkLocation["x"] = nextX
        Status.chunkLocation["z"] = nextZ

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

    fun setDistance(p: Player) {
        val safeArea: String = getSafeArrow(p, Status.chunkLocation)
        if(safeArea == "safe") {
            p.sendActionBar(Component.text("" + ChatColor.GREEN + "安全地帯にいます"))
        } else {
            p.sendActionBar(Component.text("安全地帯の方向: $safeArea"))
        }
    }

    private fun getSafeArrow(p: Player, chunkLocation: Map<String, Int>): String {
        val x: Int  = p.chunk.x
        val z: Int  = p.chunk.z
        val cx: Int = chunkLocation["x"]!!
        val cz: Int = chunkLocation["z"]!!

        val arrowList = listOf<String>(
            "↑", "↖", "←", "↙", "↓", "↘", "→", "↗"
        )

        // 安全地帯にいたら
        if(x == cx && z == cz) return "safe"

        // 大まかな方向を指す矢印の取得
        if(z == cz) {
            return if(x < cx) {
                arrowList[getIndex(arrowList, "↑", p)]
            } else {
                arrowList[getIndex(arrowList, "↓", p)]
            }
        } else if(x == cx) {
            return if(z < cz) {
                arrowList[getIndex(arrowList, "→", p)]
            } else {
                arrowList[getIndex(arrowList, "←", p)]
            }
        } else {
            return if(x < cx) {
                if(z < cz) {
                    arrowList[getIndex(arrowList, "↗", p)]
                } else {
                    arrowList[getIndex(arrowList, "↖", p)]
                }
            } else {
                if(z < cz) {
                    arrowList[getIndex(arrowList, "↘", p)]
                } else {
                    arrowList[getIndex(arrowList, "↙", p)]
                }
            }
        }
    }

    private fun getIndex(list: List<String>, arrow: String, p: Player): Int {
        val arrowIndex = list.indexOf(arrow)
        val directionIndex = getCardinalDirection(p) ?: 0
        val index = if(7 < arrowIndex + directionIndex) {
            arrowIndex + directionIndex - 8
        } else {
            arrowIndex + directionIndex
        }

        return index
    }
}