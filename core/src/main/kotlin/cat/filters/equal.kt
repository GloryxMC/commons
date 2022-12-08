@file:Suppress("NOTHING_TO_INLINE")

package cat.filters

import kotlin.reflect.KProperty1


inline infix fun <R, T> KProperty1<R, T>.eq(value: T) = filter { it == value }

inline infix fun <R, T> KProperty1<R, T>.neq(value: T) = filter { it != value }