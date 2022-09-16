package cat

/**
 * A shorthand for discarding a value.
 *
 * Made for usage in expression-style functions.
 *
 * @return always [Unit]
 */
val Any?.void get() = Unit

/**
 * A shorthand for replacing a return value from a function/variable with your own.
 *
 * @return [value]
 */
fun <T> Any?.void(value: T) = value