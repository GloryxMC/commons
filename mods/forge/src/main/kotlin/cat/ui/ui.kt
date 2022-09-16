package cat.ui

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import cat.ui.scene.MCScene
import net.minecraft.client.entity.player.ClientPlayerEntity
import net.minecraft.util.text.ITextComponent

fun ClientPlayerEntity.render(
    title: ITextComponent, width: Int, height: Int, content: @Composable BoxScope.(gui: MCScene) -> Unit
) = MCScene(title, width, height, content).also { net.gloryx.commons.forge.mc.displayGuiScreen(it) }