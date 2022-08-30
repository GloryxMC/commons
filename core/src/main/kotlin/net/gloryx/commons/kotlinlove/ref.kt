package net.gloryx.commons.kotlinlove

import kotlin.reflect.KProperty

open class BackedReference<T>(private var entity: T, private val update: (T) -> T?) {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): T {
        entity = update(entity) ?: entity
        return entity
    }
}

data class Handle<T>(var it: T) {
    operator fun getValue(that: Any?, prop: KProperty<*>) = it
    operator fun setValue(that: Any?, prop: KProperty<*>, new: T) {
        it = new
    }
}

@Suppress("MemberVisibilityCanBePrivate")
open class Memo<T>(protected val supplier: () -> T) {
    var handle by Handle(supplier())
        protected set

    open fun refresh() {
        handle = supplier()
    }

    open operator fun getValue(that: Any?, prop: KProperty<*>) = handle
    open operator fun setValue(that: Any?, prop: KProperty<*>, _unused: T?) = refresh()
}

fun <T> useState(initial: T) = Handle(initial)
fun <T> useMemo(compute: () -> T) = Memo(compute)