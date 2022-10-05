package cat

import net.kyori.adventure.util.Ticks
import kotlin.time.toKotlinDuration

inline val Number.b get() = toByte()
inline val Number.s get() = toShort()
inline val Number.d get() = toDouble()
inline val Number.i get() = toInt()
inline val Number.l get() = toLong()
inline val Number.f get() = toFloat()

fun <T, R> T.fastMap(vararg maps: Pair<T, R>) = fastMap(maps.toMap())
fun <T, R> T.fastMap(map: Map<T, R>) = map[this]

fun <R> Boolean.map(yes: R, no: R) = if (this) yes else no

val Number.ticks get() = Ticks.duration(this.l).toKotlinDuration()