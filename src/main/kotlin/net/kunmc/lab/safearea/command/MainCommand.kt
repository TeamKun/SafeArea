package net.kunmc.lab.safearea.command

import dev.kotx.flylib.command.Command
import dev.kotx.flylib.command.Permission

class MainCommand: Command("safe") {
    init {
        permission(Permission.OP)
        children(StartCommand(), StopCommand())
    }
}