@file:[JvmMultifileClass JvmName("ForgeArgumentsKt") Suppress("unused")]

package net.gloryx.commons.forge.brigadierdsl.arguments

import net.gloryx.commons.brigadierdsl.arguments.argument
import net.gloryx.commons.brigadierdsl.dsl.DslCommandBuilder
import net.gloryx.commons.forge.vec.getLocation
import net.minecraft.command.CommandSource
import net.minecraft.command.arguments.EntityArgument
import net.minecraft.command.arguments.Vec3Argument

fun DslCommandBuilder<CommandSource>.entity(name: String) =
    argument(name, EntityArgument.entity(), EntityArgument::getEntity)

fun DslCommandBuilder<CommandSource>.entities(name: String) =
    argument(name, EntityArgument.entities(), EntityArgument::getEntities)

fun DslCommandBuilder<CommandSource>.player(name: String) =
    argument(name, EntityArgument.player(), EntityArgument::getPlayer)

fun DslCommandBuilder<CommandSource>.players(name: String) =
    argument(name, EntityArgument.players(), EntityArgument::getPlayers)


fun DslCommandBuilder<CommandSource>.location(name: String, doCenter: Boolean = true) =
    argument(name, Vec3Argument.vec3(doCenter)) { ctx, n ->
        Vec3Argument.getLocation(ctx, n).getLocation(ctx.source)
    }