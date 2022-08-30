package net.gloryx.commons.brigadierdsl

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder

interface Command<S> {

    /**
     * Builds a [literal][LiteralArgumentBuilder] argument that can be used by
     * the [register][CommandDispatcher.register] function on a dispatcher to
     * register this command.
     */
    fun buildLiteral(): LiteralArgumentBuilder<S>
}

/**
 * [Builds][Command.buildLiteral] a [literal][LiteralArgumentBuilder] argument
 * from the specific [command] and registers it to this dispatcher.
 */
fun <S> CommandDispatcher<S>.register(command: Command<S>) {
    register(command.buildLiteral())
}