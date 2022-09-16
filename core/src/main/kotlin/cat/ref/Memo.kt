package cat.ref

import kotlin.reflect.KProperty

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

