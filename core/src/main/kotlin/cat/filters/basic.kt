package cat.filters

import cat.collections.*
import kotlin.reflect.KProperty1

inline fun <R, T> Op<R, T>.filter(crossinline fil: (T) -> Boolean): Filter<R> = { fil(get(it)) }

internal typealias Op<R, T> = KProperty1<R, T>