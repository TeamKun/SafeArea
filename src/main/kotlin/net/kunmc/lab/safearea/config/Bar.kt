package net.kunmc.lab.safearea.config

import org.bukkit.Bukkit
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.bukkit.entity.Player

class Bar {
    private var bar: BossBar? = null

    fun createBar() {
        bar = Bukkit.createBossBar("", BarColor.WHITE, BarStyle.SOLID)
        bar!!.isVisible = true
    }

    fun addPlayer(player: Player) {
        bar!!.addPlayer(player)
    }

    fun setTitle(title: String) {
        bar!!.setTitle(title)
    }

    fun setProgress(progress: Double) {
        bar!!.progress = progress
    }

    fun removeBar() {
        bar!!.removeAll()
    }

    fun getBossBar(): BossBar {
        return bar!!
    }
}