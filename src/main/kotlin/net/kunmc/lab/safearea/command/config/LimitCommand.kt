package net.kunmc.lab.safearea.command.config

import dev.kotx.flylib.command.Command
import dev.kotx.flylib.command.CommandContext
import net.kunmc.lab.safearea.config.Config

class LimitCommand: Command("limit") {
    init {
        description("安全地帯が切り替わるまでの時間を設定")

        usage {
            integerArgument("timeLimit", 10, 60)
        }
    }

    override fun CommandContext.execute() {
        if(args.size != 1) {
            sendHelp()
            return
        }

        val config = Config.Companion
        config.setLimit(args[0].toInt())
        success("制限時間を設定しました: ${args[0]}秒")
    }
}