package net.gloryx.commons.accessors

import net.gloryx.commons.adventure.ConsoleSender
import net.gloryx.commons.adventure.ConsoleSenderImpl
import net.kyori.adventure.audience.Audience
import org.spongepowered.api.Sponge

actual object Adventure {
    actual val players: List<Audience> = Sponge.server().onlinePlayers().toList()
    actual val console: ConsoleSender = ConsoleSenderImpl
}