package net.kunmc.lab.safearea.command

import dev.kotx.flylib.command.Command
import dev.kotx.flylib.command.CommandContext

class StopCommand: Command("stop") {
    init {
        description("This command is SafeArea Game to stopped.")
    }

    override fun CommandContext.execute() {
        success("安全地帯クラフトが終了しました！")
    }
}