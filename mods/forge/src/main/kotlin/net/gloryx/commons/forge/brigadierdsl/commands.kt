package net.gloryx.commons.forge.brigadierdsl

import com.mojang.brigadier.builder.LiteralArgumentBuilder
import net.gloryx.commons.brigadierdsl.RequiredArgument
import net.gloryx.commons.brigadierdsl.dsl.DslCommandBuilder
import net.minecraft.command.CommandSource
import net.minecraft.command.arguments.EntityArgument
import net.gloryx.commons.brigadierdsl.dsl.command as okcommand

fun command(
    name: String, moj: ((LiteralArgumentBuilder<CommandSource>).() -> Unit)? = null,
    block: DslCommandBuilder<CommandSource>.() -> Unit = {}
) = okcommand(name, moj, block)

