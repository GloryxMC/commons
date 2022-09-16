package cat.collections

import cat.*
import kotlin.reflect.KCallable
import kotlin.reflect.full.instanceParameter
import kotlin.mod as kmod

fun <E, T : Any> filter(prop: KCallable<T>, checker: (T) -> Boolean): Filter<E> =
    { checker(if (prop.instanceParameter != null) prop.callBy(mapOf(prop.instanceParameter!! to it)) else prop.call()) }

fun <T : Any> equalsTo(value: T): Filter<T> = { it == value }
fun <T : Comparable<T>> moreThan(other: T): Filter<T> = { it > other }
fun <T : Comparable<T>> lessThan(other: T): Filter<T> = { it < other }
fun <T : Comparable<T>> moreOrEq(other: T): Filter<T> = { it >= other }
fun <T : Comparable<T>> lessOrEq(other: T): Filter<T> = { it <= other }
fun <N : Number> modEq(to: N, mod: Number): Filter<N> = { it mods to == mod }

infix fun <N : Number> N.mods(other: N): N = when (this) {
    is Int -> kmod(other.i)
    is Long -> kmod(other.l)
    is Double -> kmod(other.d)
    is Float -> kmod(other.f)
    else -> -this.d + 1
} as N