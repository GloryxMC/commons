package cat.math

import cat.f
import cat.i

data class Fraction(val numerator: Int, val denominator: Int) : Number() {
    val value = (numerator.f / denominator.f)
    private inline fun <reified N : Number> inline(): N = value.asNumber()
    override fun toByte(): Byte = inline()
    override fun toChar(): Char = i.toChar()
    override fun toDouble(): Double = inline()
    override fun toFloat(): Float = value
    override fun toInt(): Int = inline()
    override fun toLong(): Long = inline()
    override fun toShort(): Short = inline()
}