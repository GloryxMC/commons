package cat.math

import cat.*
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1

@PublishedApi
internal val castMap: Map<KClass<out Number>, KProperty1<out Number, Number>> = mapOf(
    Byte::class to Number::b,
    Short::class to Number::s,
    Int::class to Number::i,
    Double::class to Number::d,
    Float::class to Number::f,
    Long::class to Number::l
)

inline fun <reified N : Number, I : Number> I.asNumber(): N = (castMap[N::class] ?: this) as N