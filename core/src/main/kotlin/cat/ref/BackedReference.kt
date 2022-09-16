package cat.ref

import kotlin.reflect.KProperty

open class BackedReference<T>(private var entity: T, private val update: (T) -> T?) {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): T {
        entity = update(entity) ?: entity
        return entity
    }
}