package net.kunmc.lab.safearea.util

import net.kyori.adventure.text.Component
import net.kyori.adventure.translation.GlobalTranslator
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player

fun sendMsg(msg: String) {
    Bukkit.getOnlinePlayers().forEach {
        it.sendMessage(msg)
    }
}

/**
 * @author bun133
 */
fun translate(p: Player ,material: Material): Component {
    val e = Component.translatable(material.translationKey)
    val translator = GlobalTranslator.renderer()
    return translator.render(e, p.locale())
}
