package net.gloryx.commons.accessors

import net.gloryx.commons.adventure.ConsoleSender
import net.gloryx.commons.adventure.ConsoleSenderImpl
import net.kyori.adventure.audience.Audience
import org.bukkit.Bukkit

actual object Adventure {
    actual val players: List<Audience> get() = Bukkit.getOnlinePlayers().filterNotNull().toList()
    actual val console: ConsoleSender get() = ConsoleSenderImpl
}