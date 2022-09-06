package net.gloryx.commons.kotlinlove

val Number.d get() = toDouble()
val Number.i get() = toInt()
val Number.l get() = toLong()
val Number.f get() = toFloat()

fun <T, R> T.fastMap(vararg maps: Pair<T, R>) = fastMap(maps.toMap())
fun <T, R> T.fastMap(map: Map<T, R>) = map[this]