package cat

import net.kyori.adventure.util.Ticks
import kotlin.time.toKotlinDuration

val Number.d get() = toDouble()
val Number.i get() = toInt()
val Number.l get() = toLong()
val Number.f get() = toFloat()

fun <T, R> T.fastMap(vararg maps: Pair<T, R>) = fastMap(maps.toMap())
fun <T, R> T.fastMap(map: Map<T, R>) = map[this]

val Number.ticks get() = Ticks.duration(this.l).toKotlinDuration()