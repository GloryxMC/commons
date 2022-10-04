package cat

import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

/**
 * A shorthand for discarding a value.
 *
 * Made for usage in expression-style functions.
 *
 * @return always [Unit]
 * @sample VoidSample.voidFunction
 */
val Any?.void get() = Unit

/**
 * A shorthand for replacing a return value from a function/variable with your own.
 *
 * @sample VoidSample.replaceVoidFunction
 * @return [value]
 */
fun <T> Any?.void(value: T) = value

inline fun just(fn: () -> Unit): Unit = fn()

fun String.camelToSnake(): String {
    // Empty String
    var result = ""

    // Append first character(in lower case)
    // to result string
    val c = this[0]
    result += c.lowercaseChar()

    // Traverse the string from
    // ist index to last index
    for (i in 1 until this.length) {
        val ch = this[i]

        // Check if the character is upper case
        // then append '_' and such character
        // (in lower case) to result string
        if (Character.isUpperCase(ch)) {
            result += '_'
            result = (result + ch.lowercaseChar())
        } else {
            result += ch
        }
    }

    // return the result
    return result
}

private object VoidSample {
    fun voidFunction() = someFunction().void

    fun someFunction(): Int {
        println("pretend we're doing something...")

        return measureTimeMillis {
            println("more work...")
            Thread.sleep(300)
        }.i / 1000
    }

    @OptIn(ExperimentalTime::class)
    fun replaceVoidFunction(): String = otherFunction().void("Voiding!!!")

    @OptIn(ExperimentalTime::class)
    fun otherFunction(): TimedValue<Long> {
        return measureTimedValue {
            var i = 0L
            for (a in 1..30) {
                i += a * 100
            }
            i
        }
    }
}