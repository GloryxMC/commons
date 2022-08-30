package net.gloryx.commons.async

import kotlinx.coroutines.flow.*
import java.util.concurrent.atomic.AtomicBoolean
import java.util.stream.*

/**
 * Represents the given stream as a flow and [closes][Stream.close] the stream afterwards.
 * The resulting flow can be [collected][Flow.collect] only once
 * and throws [IllegalStateException] when trying to collect it more than once.
 */
fun <T> Stream<T>.consumeAsFlow(): Flow<T> = StreamFlow(this)

private class StreamFlow<T>(private val stream: Stream<T>) : Flow<T> {
    private val consumed = AtomicBoolean(false)

    override suspend fun collect(collector: FlowCollector<T>) {
        if (!consumed.compareAndSet(false, true)) error("Stream.consumeAsFlow can be collected only once")
        stream.use { stream ->
            for (value in stream.iterator()) {
                collector.emit(value)
            }
        }
    }
}