package cat.ref

import kotlin.reflect.KProperty

data class Handle<T>(var it: T) {
    operator fun getValue(that: Any?, prop: KProperty<*>) = it
    operator fun setValue(that: Any?, prop: KProperty<*>, new: T) {
        it = new
    }
}