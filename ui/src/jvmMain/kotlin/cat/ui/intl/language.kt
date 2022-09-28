package cat.ui.intl

import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigObject
import com.typesafe.config.ConfigValue
import com.typesafe.config.ConfigValueType

actual data class Language actual constructor(actual val code: String) {
    actual val conf: Map<String, String> = mutableMapOf<String, String>().apply {
        val c = ConfigFactory.parseResources(javaClass, "lang/${code.lowercase()}.conf")
        for ((key, value) in c.root()) {
            recObj(key, value, this)
        }
    }

    private fun recObj(key: String, obj: ConfigValue, map: MutableMap<String, String>) {
        if (obj.valueType() == ConfigValueType.STRING) map[key] = obj.unwrapped() as String
        else {
            for (o in (obj as ConfigObject)) {
                if (o.value.valueType() == ConfigValueType.OBJECT) recObj("$key.${o.key}", o.value, map)
                else if (o.value.valueType() == ConfigValueType.STRING) map["$key.${o.key}"] =
                    o.value.unwrapped() as String
            }
        }
    }
}

actual object Languages {
    actual val Russian = new("RU_RU")
    actual val English = new("EN_US")

    actual val Default: Language = English

    actual fun new(name: String) = Language(name)
}