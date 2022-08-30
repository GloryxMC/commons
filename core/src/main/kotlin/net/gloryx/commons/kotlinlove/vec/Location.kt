package net.gloryx.commons.kotlinlove.vec

data class Location(val x: Double, val y: Double, val z: Double, val pitch: Float = 0f, val yaw: Float = 90f) {
    operator fun plus(other: Location) =
        other.let { (bx, by, bz, brp, bry) -> copy(x = x + bx, y = y + by, z = z + bz, pitch = pitch + brp, yaw = yaw + bry) } // ARE YOU HAPPY, COMPILER?!?
    fun plus(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, pitch: Float = 0f, yaw: Float = 90f) = plus(Location(x, y, z, pitch, yaw))

    override fun toString(): String = "Location{x = $x, y = $y, z = $z, pitch = $pitch, yaw = $yaw}"
}