package cat.collections

fun <T> MutableList<T>.findOneAndReplace(filter: Filter<T>, replace: Replace<T>) = apply {
    val initial = find(filter) ?: return@apply
    val new = initial.let(replace)
    add(indexOf(initial).also(this::removeAt), new)
}

fun <K, V> MutableMap<K, V>.findOneAndReplace(filter: Filter<Pair<K, V>>, replace: Replace<Pair<K, V>>) = apply {
    val initial = toList().find(filter) ?: return@apply
    val new = initial.let(replace)
    remove(initial.first, initial.second)
    put(new.first, new.second)
}