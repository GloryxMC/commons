package catx.brigadierthing.scope

import net.kyori.adventure.text.Component

typealias ThingDSL = suspend ThingScope.() -> Unit

interface ThingScope {
    suspend fun answer(prompt: Component): String
}