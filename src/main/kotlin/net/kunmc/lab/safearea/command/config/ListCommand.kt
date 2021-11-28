package net.kunmc.lab.safearea.command.config

import dev.kotx.flylib.command.Command
import dev.kotx.flylib.command.CommandContext
import net.kunmc.lab.safearea.config.Config

class ListCommand: Command("list") {
    init {
        description("現在の設定値諸々の確認コマンド")
    }

    override fun CommandContext.execute() {
        val limit = Config.getLimit()

        success("============設定値============")
        message("制限時間     : ${limit}秒")
        message("安全地帯範囲: 中心から ${(limit / 10) + 1} × ${(limit / 10) + 1} チャンク")
        message("               のうちランダム1チャンク")
        success("============================")
    }
}