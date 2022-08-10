package net.gloryx.commons.adventure

import org.bukkit.Bukkit
import org.bukkit.command.ConsoleCommandSender

object ConsoleSenderImpl : ConsoleSender {
    val sender get() = Bukkit.getConsoleSender()
    override fun execute(command: String) =
        Bukkit.getServer().dispatchCommand(sender, command)
}