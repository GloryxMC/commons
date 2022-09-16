package cat

/**
 * A try statement shortened to an inline lambda function.
 *
 *
 * If no exceptions are thrown, returns the result of the [fn] function;
 *
 * If exception(s?) are thrown, returns null.
 *
 * @param fn Function that can throw exceptions, and if it does not throw, return some value of type [T]
 * @return result of [fn] or null.
 *
 * @author nothen
 */
@Suppress("FunctionName")
inline fun <T : Any?> try_(fn: () -> T): T? = try { fn() } catch (e: Exception) { null }