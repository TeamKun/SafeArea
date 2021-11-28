package net.kunmc.lab.safearea.game

import net.kunmc.lab.safearea.SafeAreaPlugin
import net.kunmc.lab.safearea.config.Config
import net.kunmc.lab.safearea.config.Status
import net.kunmc.lab.safearea.util.*

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle

import org.bukkit.scheduler.BukkitRunnable

class Timer {
    fun countTimer() {
        val config = Config.Companion
        val logic = Logic()

        val limitTime = config.getLimit()
        var remainSeconds = limitTime

        val bar = Bukkit.createBossBar("", BarColor.WHITE, BarStyle.SOLID)

        Bukkit.getOnlinePlayers().forEach {
            bar.addPlayer(it)
            logic.setDistance(it)
        }

        object: BukkitRunnable() {
            override fun run() {
                val progress = ((1.0 / limitTime) * remainSeconds)
                bar.progress = progress

                if(progress <= 0.25) {
                    playSound(Sound.BLOCK_DISPENSER_DISPENSE)
                    bar.color = BarColor.RED
                    bar.setTitle("" + ChatColor.RED + "あと"+remainSeconds+"秒です")
                } else if(progress <= 0.5) {
                    bar.color = BarColor.YELLOW
                    bar.setTitle("" + ChatColor.YELLOW + "あと"+remainSeconds+"秒です")
                } else {
                    bar.setTitle("あと"+remainSeconds+"秒です")
                }

                remainSeconds--
                if(remainSeconds < 0 || !Status.isEnable) {
                    cancel()
                    bar.removeAll()
                    if(Status.isEnable) {
                        logic.checkSafeArea()
                        logic.setSafeArea(Status.chunkLocation["x"]!!, Status.chunkLocation["z"]!!)
                        countTimer()
                    }
                }
            }
        }.runTaskTimer(SafeAreaPlugin.plugin, 0, 20)
    }
}