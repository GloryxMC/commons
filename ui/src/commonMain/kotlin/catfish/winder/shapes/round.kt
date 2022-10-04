@file:Suppress("FunctionName", "NOTHING_TO_INLINE")

package catfish.winder.shapes

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import cat.i

inline fun Round(percent: Number) = RoundedCornerShape(percent.i)

val Round10 = Round(10)
val Round20 = Round(20)
val Round30 = Round(30)
val Round40 = Round(40)
inline val Round50 get() = CircleShape
val Round70 = Round(70)
val Round80 = Round(80)
val Round90 = Round(90)
val Round100 = Round(100)