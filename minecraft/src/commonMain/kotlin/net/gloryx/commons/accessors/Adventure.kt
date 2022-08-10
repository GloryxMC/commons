package net.gloryx.commons.accessors

import net.gloryx.commons.adventure.ConsoleSender
import net.kyori.adventure.audience.Audience

expect object Adventure {
    val players: List<Audience>
    val console: ConsoleSender
}