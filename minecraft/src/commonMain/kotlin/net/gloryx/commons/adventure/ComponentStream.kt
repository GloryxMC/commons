package net.gloryx.commons.adventure

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.identity.Identity
import net.kyori.adventure.text.ComponentLike
import java.io.OutputStream

class ComponentStream(val entity: Audience) : AutoCloseable {
    private val pending = mutableMapOf<Identity, ComponentLike>()

    @JvmOverloads
    fun write(message: String, identity: Identity = Identity.nil()) = write(message.md, identity)

    @JvmOverloads
    fun write(component: ComponentLike, identity: Identity = Identity.nil()) {
        pending[identity] = component
    }

    fun flush() {
        pending.forEach { (a, b) -> entity.sendMessage(a, b) }
        pending.clear()
    }

    override fun close() {
        pending.clear()
    }
}