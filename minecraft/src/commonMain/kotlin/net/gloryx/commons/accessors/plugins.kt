package net.gloryx.commons.accessors

inline fun <reified T> getPlugin(): T = getPluginNullable<T>() ?: throw NullPointerException("The plugin was null :(")
expect inline fun <reified T> getPluginNullable(): T?