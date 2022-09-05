@file:Suppress("unused")

package net.gloryx.commons.kotlinlove.delegates

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KCallable

/**
 * Usage:
 * ```
 * val something by ::MyClass.calling(1, 2, "a") // this would create sort of a getter by delegating to MyClass's constructor and supplying it arguments [1, 2, "a"]
 * ```
 * Which is equal to:
 * ```
 * val something get() = MyClass(1, 2, "a")
 * ```
 */
fun <T> KCallable<T>.calling(vararg args: Any): ReadOnlyProperty<Any?, T> =
    ReadOnlyProperty { _, _ -> call(*args) }

val <T> KCallable<T>.calling get() = ReadOnlyProperty<Any?, T> { _, _ -> call() }

@Suppress("ClassName")
private object example {
    val something by ::noargfunc.calling()

    val somethingGetter get() = noargfunc()

    fun noargfunc() {

    }
}