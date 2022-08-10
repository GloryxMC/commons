package net.gloryx.commons.adventure

import net.kyori.adventure.audience.Audience

interface ConsoleSender : Audience {
    fun execute(command: String): Boolean
}