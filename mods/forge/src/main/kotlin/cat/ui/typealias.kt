package cat.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.pointer.PointerButton

typealias Cfn = @Composable () -> Unit
typealias Crfn<T> = @Composable T.() -> Unit

object GlfwMouseButton {
    const val button_1 = 0
    const val button_2 = 1
    const val button_3 = 2
    const val button_4 = 3
    const val button_5 = 4
    const val button_6 = 5
    const val button_7 = 6
    const val button_8 = 7

    const val Left = button_1
    const val Right = button_2
    const val Middle = button_3

    const val Last = button_8
}

fun PointerButton.Companion.of(glfw: Int) = when (glfw) {
    GlfwMouseButton.Left -> Primary
    GlfwMouseButton.Right -> Secondary
    GlfwMouseButton.Middle -> Tertiary
    GlfwMouseButton.button_7 -> Back
    GlfwMouseButton.button_8 -> Forward
    else -> null
}