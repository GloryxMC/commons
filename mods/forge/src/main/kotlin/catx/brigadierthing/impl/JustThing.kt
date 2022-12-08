package catx.brigadierthing.impl

import catx.brigadierthing.S
import catx.brigadierthing.Thing
import catx.brigadierthing.scope.ThingScope
import com.mojang.brigadier.context.CommandContext

open class JustThing(name: String) : Thing(name) {
    override fun getScope(context: CommandContext<S>): ThingScope {

    }

    protected inner class Scope(val context: CommandContext<S>) : ThingScopeImpl()
}