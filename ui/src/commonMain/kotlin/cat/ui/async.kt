@file:OptIn(ExperimentalTypeInference::class)

package cat.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.*
import kotlin.experimental.ExperimentalTypeInference

@Composable
@OverloadResolutionByLambdaReturnType
fun Async(fn: suspend CoroutineScope.() -> Unit): Job = rememberCoroutineScope().launch(block = fn)

@OverloadResolutionByLambdaReturnType
@Composable
fun <T> Async(fn: suspend CoroutineScope.() -> T): Deferred<T> = rememberCoroutineScope().async(block = fn)

@Composable
fun <T : Any> Suspense(state: MutableState<T?>, fallback: ComposableFn = { Text("Please wait...") }, content: CFnWithArgs<T>) {
    state.value?.let { content(it) } ?: fallback()
}