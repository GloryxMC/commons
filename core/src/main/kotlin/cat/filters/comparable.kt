@file:Suppress("NOTHING_TO_INLINE")

package cat.filters

/**
 * Less than [other].
 */
inline infix fun <R, T : Comparable<T>> Op<R, T>.lt(other: T) = filter { it < other }

/**
 * Greater than [other].
 */
inline infix fun <R, T : Comparable<T>> Op<R, T>.gt(other: T) = filter { it > other }

/**
 * Less than [other] or equal to.
 */
inline infix fun <R, T : Comparable<T>> Op<R, T>.le(other: T) = filter { it <= other }

/**
 * Greater than [other] or equal to.
 */
inline infix fun <R, T : Comparable<T>> Op<R, T>.ge(other: T) = filter { it >= other }
