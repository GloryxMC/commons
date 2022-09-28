package cat.conf

import kotlin.reflect.KClass
import kotlin.reflect.KProperty

interface IConfigLoader<T : Any> {
    val klass: KClass<T>

    fun get(): T = getOrNull()!!
    fun getOrNull(): T?

    fun load(): T
}

inline operator fun <reified T> IConfigLoader<*>.getValue(that: Any?, prop: KProperty<*>) = load()