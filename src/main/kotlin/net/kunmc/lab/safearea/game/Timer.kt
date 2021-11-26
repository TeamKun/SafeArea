package net.kunmc.lab.safearea.game

import net.kunmc.lab.safearea.SafeAreaPlugin
import net.kunmc.lab.safearea.config.Bar
import net.kunmc.lab.safearea.config.Status
import org.bukkit.Bukkit

import org.bukkit.scheduler.BukkitRunnable

class Timer {
    private val bar = Bar()

    fun countTimer(seconds: Int) {
        val manager = Manager()
        var remainSeconds = seconds

        bar.createBar()
        Bukkit.getOnlinePlayers().forEach {
            bar.addPlayer(it)
        }

        object: BukkitRunnable() {
            override fun run() {
                bar.setProgress(0.05 * remainSeconds)
                bar.setTitle("あと"+remainSeconds+"秒です")
                remainSeconds--
                if(remainSeconds < 0) {
                    cancel()
                    bar.removeBar()
                    if(Status.isEnable) {
                        manager.checkSafeArea()
                        manager.setSafeArea(Status.chunkLocation["x"]!!, Status.chunkLocation["z"]!!)
                        countTimer(20)
                    }
                }
            }
        }.runTaskTimer(SafeAreaPlugin.plugin, 0, 20)
    }
}