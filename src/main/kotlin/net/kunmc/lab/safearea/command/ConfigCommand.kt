package net.kunmc.lab.safearea.command

import dev.kotx.flylib.command.Command
import net.kunmc.lab.safearea.command.config.LimitCommand
import net.kunmc.lab.safearea.command.config.ListCommand

class ConfigCommand: Command("config") {
    init {
        description("SafeAreaPluginの設定をします")

        children(
            ListCommand(),
            LimitCommand()
        )
    }
}