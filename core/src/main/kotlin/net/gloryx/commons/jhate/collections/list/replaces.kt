package net.gloryx.commons.jhate.collections.list

import net.gloryx.commons.jhate.collections.Filter
import net.gloryx.commons.jhate.collections.Replace

fun <T> MutableList<T>.findOneAndReplace(filter: Filter<T>, replace: Replace<T>) = apply {
    val initial = find(filter) ?: return@apply
    val new = initial.let(replace)
    add(indexOf(initial).also(this::removeAt), new)
}