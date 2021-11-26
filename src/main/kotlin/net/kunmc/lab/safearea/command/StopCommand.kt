package net.kunmc.lab.safearea.command

import dev.kotx.flylib.command.Command
import dev.kotx.flylib.command.CommandContext
import net.kunmc.lab.safearea.config.Status

class StopCommand: Command("stop") {
    init {
        description("安全地帯クラフトを終了します")
    }

    override fun CommandContext.execute() {
        Status.isEnable = false
        success("安全地帯クラフトが終了しました！")
    }
}