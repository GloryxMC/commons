package net.gloryx.commons.adventure

import de.themoep.minedown.adventure.MineDown
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.identity.Identity
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream
import java.nio.ByteBuffer
import java.util.LinkedList

val String?.md: Component get() = this?.let(MineDown::parse) ?: Component.empty()

fun Audience.msg(text: String, identity: Identity = Identity.nil()) = sendMessage(identity, text.md)

val Audience.chat get() = ComponentStream(this)