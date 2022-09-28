package cat.ui.intl

import androidx.compose.runtime.*
import cat.camelToSnake
import net.gloryx.oknamer.key.*
import net.gloryx.oknamer.key.kinds.LangKey
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

sealed class LangContainer(namespace: Namespaced) : Namespaced by namespace {
    constructor(parent: LangContainer, prefix: String) : this(parent.dot(prefix)) // launcher -> launcher.x

    operator fun Nothing?.provideDelegate(
        that: LangContainer, prop: KProperty<*>
    ): ReadOnlyProperty<LangContainer, LangComponent> = Delegate

    operator fun String.provideDelegate(
        that: LangContainer, prop: KProperty<*>
    ): ReadOnlyProperty<LangContainer, LangComponent> =
        Delegate.Spec(Key.lang(this@LangContainer, this))

    private object Delegate : ReadOnlyProperty<LangContainer, LangComponent> {
        override fun getValue(thisRef: LangContainer, property: KProperty<*>): LangComponent =
            LangComponent(Key.lang(thisRef, property.name.camelToSnake()))

        class Spec(key: LangKey) : ReadOnlyProperty<LangContainer, LangComponent> {
            private val component = LangComponent(key)
            override fun getValue(thisRef: LangContainer, property: KProperty<*>): LangComponent = component
        }
    }

    companion object {
        var Lang by mutableStateOf(Languages.Default)
    }
}

expect class LangComponent(key: LangKey, args: Array<out Any?> = arrayOf()) {
    val key: LangKey
    val args: Array<out Any?>
}

expect class Language(code: String) {
    val code: String

    val conf: Map<String, String>
}

expect object Languages {
    val Default: Language

    val Russian: Language
    val English: Language

    fun new(name: String): Language
}