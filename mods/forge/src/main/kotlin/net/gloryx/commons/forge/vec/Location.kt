package net.gloryx.commons.forge.vec

import net.gloryx.commons.kotlinlove.vec.Location
import net.minecraft.command.CommandSource
import net.minecraft.command.arguments.ILocationArgument
import net.minecraft.entity.Entity
import net.minecraft.util.math.vector.Vector2f
import net.minecraft.util.math.vector.Vector3d
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.util.math.vector.Vector3i

fun Location(vec: Vector3d) = Location(vec, Vector2f(90f, 90f))
fun Location(vec: Vector3i /* ?= BlockPos */) = Location(vec.vec3d)
fun Location(vec: Vector3f) = Location(vec.vec3d)

fun Location(rot: Vector2f) = Location(Vector3d.ZERO, rot)
fun Location(pos: Vector3d, rot: Vector2f) = Location(pos.x, pos.y, pos.z, rot.y, rot.x)

fun ILocationArgument.getLocation(source: CommandSource) = Location(getPosition(source), getRotation(source))

var Entity.location: Location
    get() = Location(positionVec, Vector2f(rotationPitch, rotationYaw))
    set(location) = location.let { (x, y, z, ry, rx) -> setLocationAndAngles(x, y, z, ry, rx) }