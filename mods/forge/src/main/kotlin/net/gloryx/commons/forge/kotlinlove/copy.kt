@file:Suppress("unused")
package net.gloryx.commons.forge.kotlinlove

import net.minecraft.util.ActionResult
import net.minecraft.util.ActionResultType
import net.minecraft.util.math.vector.Quaternion
import net.minecraft.util.math.vector.Vector2f
import net.minecraft.util.math.vector.Vector3d
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.util.math.vector.Vector3i
import net.minecraft.util.math.vector.Vector4f

@Suppress("UNNECESSARY_NOT_NULL_ASSERTION") // frick platform types
fun <T> ActionResult<T>.copy(
    type: ActionResultType = getType(), result: T & Any = getResult()!!!! // tf
) = ActionResult(type, result)

fun Quaternion.copy(x: Float = getX(), y: Float = getY(), z: Float = getZ(), w: Float = getW()) = Quaternion(x, y, z, w)
fun Vector2f.copy(pitch: Float = x, yaw: Float = y) = Vector2f(pitch, yaw)
fun Vector3i.copy(x: Int = getX(), y: Int = getY(), z: Int = getZ()) = Vector3i(x, y, z)
fun Vector3d.copy(x: Double = getX(), y: Double = getY(), z: Double = getZ()) = Vector3d(x, y, z)
fun Vector3f.copy(x: Float = getX(), y: Float = getY(), z: Float = getZ()) = Vector3f(x, y, z)
fun Vector4f.copy(x: Float = getX(), y: Float = getY(), z: Float = getZ(), w: Float = getW()) = Vector4f(x, y, z, w)