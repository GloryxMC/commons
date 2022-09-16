package net.gloryx.commons.accessors

import cat.reflect.cast
import cat.reflect.safeCast
import org.spongepowered.api.Sponge

actual inline fun <reified T> getPluginNullable(): T? = Sponge.pluginManager().plugins().first { it.instance() is T }.instance().safeCast()