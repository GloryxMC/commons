package net.gloryx.commons.forge.vec

import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.vector.Vector3d
import net.minecraft.util.math.vector.Vector3f
import net.minecraft.util.math.vector.Vector3i

val Vector3d.vec3f get() = Vector3f(this)
val Vector3f.vec3d get() = Vector3d(this)
val Vector3i.vec3d: Vector3d get() = Vector3d.copyCenteredHorizontally(this)
val Vector3d.bp get() = BlockPos(this)

operator fun Vector3d.component1() = x
operator fun Vector3d.component2() = y
operator fun Vector3d.component3() = z

operator fun Vector3i.component1() = x
operator fun Vector3i.component2() = y
operator fun Vector3i.component3() = z

operator fun Vector3f.component1() = x
operator fun Vector3f.component2() = y
operator fun Vector3f.component3() = z

val Vector3d.loc get() = Location(this)
val Vector3f.loc get() = Location(this)
val Vector3i.loc get() = Location(this)