package cat.ref

fun <T> useState(initial: T) = Handle(initial)
fun <T> useMemo(compute: () -> T) = Memo(compute)