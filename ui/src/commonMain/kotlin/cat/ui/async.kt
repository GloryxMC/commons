package cat.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import cat.ui.dlg.currentCoroutine
import kotlinx.coroutines.*

@Composable
fun Suspend(fn: suspend CoroutineScope.() -> Unit): Job = currentCoroutine.launch(block = fn)

@Composable
fun <T> Async(fn: suspend CoroutineScope.() -> T): Deferred<T> = currentCoroutine.async(block = fn)

@Composable
fun <T : Any> Suspense(state: State<T?>, fallback: ComposableFn = { Text("Please wait...") }, content: CFnWithArgs<T>) {
    state.value?.let { content(it) } ?: fallback()
}