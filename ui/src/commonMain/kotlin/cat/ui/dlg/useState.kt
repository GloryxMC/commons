@file:Suppress("FunctionName")

package cat.ui.dlg

import androidx.compose.runtime.*
import cat.void
import kotlin.reflect.KProperty

fun <T> State(value: T, policy: SnapshotMutationPolicy<T> = structuralEqualityPolicy()) = mutableStateOf(value, policy)

fun <T : Any> MaybeState(default: T? = null, policy: SnapshotMutationPolicy<T?> = structuralEqualityPolicy()) = State(default, policy)

fun <T : Any> State<T?>.consume(block: (T) -> Unit) = value?.let(block)

@Composable
fun <T : Any> State<T?>.render(block: @Composable (T) -> Unit) = value?.let { block(it) }

operator fun <T> State<T>.getValue(that: Any?, prop: KProperty<*>) = value
operator fun <T> MutableState<T>.setValue(that: Any?, prop: KProperty<*>, newValue: T) { value = newValue }

@Composable
fun <T> useState(value: T, policy: SnapshotMutationPolicy<T> = structuralEqualityPolicy()) = remember { State(value, policy) }