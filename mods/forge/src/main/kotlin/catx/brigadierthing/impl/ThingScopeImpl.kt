package catx.brigadierthing.impl

import catx.brigadierthing.S
import catx.brigadierthing.scope.ThingScope
import com.mojang.brigadier.context.CommandContext
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import net.gloryx.commons.forge.mc
import net.kyori.adventure.text.Component
import net.minecraftforge.api.distmarker.Dist
import thedarkcolour.kotlinforforge.forge.DIST
import thedarkcolour.kotlinforforge.forge.MOD_BUS

abstract class ThingScopeImpl(val context: CommandContext<S>) : ThingScope {
    override suspend fun answer(prompt: Component): String {
        context.source.sendFeedback(prompt.mc, false)

        when (DIST) {
            Dist.CLIENT -> {
                flow<String> {
                    while (true)
                        mc.ingameGUI.chatGUI.sentMessages.forEach { emit(it) }
                }.distinctUntilChanged()
            }

            Dist.DEDICATED_SERVER -> {

            }
        }


    }
}

val ThingScope.context get() = (this as ThingScopeImpl).context