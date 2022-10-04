package cat.ui.dlg

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.remember

@Composable inline fun <T> forget(block: @DisallowComposableCalls () -> T) = remember(block)

@Composable inline fun <T> forget(key1: Any?, block: @DisallowComposableCalls () -> T) = remember(key1, block)
@Composable inline fun <T> forget(vararg keys: Any?, block: @DisallowComposableCalls () -> T) = remember(*keys) { block() }
