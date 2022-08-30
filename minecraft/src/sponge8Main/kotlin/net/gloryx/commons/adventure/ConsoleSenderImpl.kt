package net.gloryx.commons.adventure

import org.spongepowered.api.Sponge

object ConsoleSenderImpl : ConsoleSender {
    val sender get() = Sponge.server().commandManager()
    override fun execute(command: String): Boolean =
        sender.process(command).isSuccess
}