package net.gloryx.commons.reflect

inline fun <reified T> Any?.cast(): T = safeCast<T>()!!
inline fun <reified T> Any?.safeCast(): T? = this as? T