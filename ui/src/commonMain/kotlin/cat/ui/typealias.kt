package cat.ui

import androidx.compose.runtime.Composable

typealias ComposableFn = @Composable () -> Unit
typealias CFnWithArgs<T> = @Composable (T) -> Unit