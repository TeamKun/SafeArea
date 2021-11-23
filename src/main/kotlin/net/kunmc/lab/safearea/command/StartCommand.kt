package net.kunmc.lab.safearea.command

import dev.kotx.flylib.command.Command
import dev.kotx.flylib.command.CommandContext

class StartCommand: Command("start") {
    init {
        description("This command is SafeArea Game to started.")
    }

    override fun CommandContext.execute() {
        success("安全地帯クラフトが始まりました！")
    }
}