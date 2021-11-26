package net.kunmc.lab.safearea.command

import dev.kotx.flylib.command.Command
import dev.kotx.flylib.command.CommandContext
import net.kunmc.lab.safearea.config.Status
import net.kunmc.lab.safearea.game.Manager
import net.kunmc.lab.safearea.game.Timer
import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import java.lang.Exception

class StartCommand: Command("start") {
    init {
        description("安全地帯クラフトを開始します")

        usage {
            description("ゲームスタート時に中心とするプレイヤーの設定")
            entityArgument(name = "target", enableSelector = false, enableEntities = false)
        }
    }

    override fun CommandContext.execute() {
        if(args.size != 1) {
            sendHelp()
            return
        }

        val entities: MutableList<Entity>

        try {
            entities = Bukkit.selectEntities(sender, args[0])
        } catch(e: Exception) {
            fail("存在しないプレイヤー名が入力されました")
            return
        }

        if(entities.isEmpty()) {
            fail("サーバに接続していないプレイヤー名が入力されました")
            return
        }

        Status.isEnable = true
        Status.world = player!!.world

        val x = entities[0].chunk.x
        val z = entities[0].chunk.z

        Manager().setSafeArea(x, z)

        success("安全地帯クラフトが始まりました！")
        warn("x: ${Status.chunkLocation["x"]} z: ${Status.chunkLocation["z"]}")
        Timer().countTimer(20)
    }
}