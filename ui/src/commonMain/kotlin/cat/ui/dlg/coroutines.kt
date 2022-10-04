package cat.ui.dlg

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope

val currentCoroutine: CoroutineScope
    @Composable get() = rememberCoroutineScope()