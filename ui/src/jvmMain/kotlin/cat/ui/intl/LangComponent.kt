package cat.ui.intl

import net.gloryx.oknamer.key.kinds.LangKey

actual data class LangComponent actual constructor(
    actual val key: LangKey, actual val args: Array<out Any?>
) {
    override fun toString(): String = (LangContainer.Lang.conf[key.asString()]?.format(*args) ?: key.asString())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LangComponent

        if (key != other.key) return false
        if (!args.contentEquals(other.args)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = key.hashCode()
        result = 31 * result + args.contentHashCode()
        return result
    }
}