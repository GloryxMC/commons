package net.gloryx.commons.accessors

import org.bukkit.Bukkit

actual inline fun <reified T> getPluginNullable(): T? = Bukkit.getPluginManager().plugins.filterIsInstance<T>().filterNotNull().firstOrNull()