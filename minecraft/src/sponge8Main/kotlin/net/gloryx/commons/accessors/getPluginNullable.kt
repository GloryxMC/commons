package net.gloryx.commons.accessors

import net.gloryx.commons.reflect.cast
import net.gloryx.commons.reflect.safeCast
import org.spongepowered.api.Sponge

actual inline fun <reified T> getPluginNullable(): T? = Sponge.pluginManager().plugins().first { it.instance() is T }.instance().safeCast()