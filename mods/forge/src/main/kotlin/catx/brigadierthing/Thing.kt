package catx.brigadierthing

import catx.brigadierthing.scope.ThingScope
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.context.CommandContext

abstract class Thing(val name: String) {
    protected val node: LiteralArgumentBuilder<S> = LiteralArgumentBuilder.literal(name)

    open fun register(dispatcher: CommandDispatcher<S>) {
        dispatcher.register(node)
    }

    protected abstract fun getScope(context: CommandContext<S>): ThingScope
}