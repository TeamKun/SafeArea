package net.kunmc.lab.safearea.command

import dev.kotx.flylib.command.Command

class MainCommand: Command("safe") {
    init {
        children(
            StartCommand(),
            StopCommand(),
            ConfigCommand()
        )
    }
}