package cat.ui.dlg

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope

@Composable
fun useEffect(once: suspend CoroutineScope.() -> Unit) = LaunchedEffect(true, once)


@Composable
fun useEffect(key1: Any?, scope: suspend CoroutineScope.() -> Unit) = LaunchedEffect(key1, scope)

@Composable
fun useEffect(vararg keys: Any?, scope: suspend CoroutineScope.() -> Unit) = LaunchedEffect(*keys) { scope() }