package cat.ui.scene

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.ImageComposeScene
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.unit.dp
import cat.d
import cat.f
import cat.ui.of
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.systems.RenderSystem
import gg.essential.universal.UGraphics
import gg.essential.universal.UMatrixStack
import gg.essential.universal.utils.ReleasedDynamicTexture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import net.java.games.input.Keyboard
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.renderer.Tessellator
import net.minecraft.client.renderer.texture.NativeImage
import net.minecraft.util.text.ITextComponent
import org.lwjgl.opengl.GL11
import java.awt.Color
import java.awt.Component
import java.nio.ByteBuffer
import java.util.concurrent.Executors

class MCScene(
    title: ITextComponent, x: Int, y: Int, val content: @Composable BoxScope.(gui: MCScene) -> Unit
) : Screen(title),
    CoroutineScope by CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {

    val scene = ImageComposeScene(x, y, coroutineContext = coroutineContext, content = {
        Box(Modifier.size((width * 128).dp, (height * 128).dp)) {
            content(this@MCScene)
        }
    })

    init {
        width = x
        height = y
    }

    override fun render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        val data = scene.render(System.nanoTime())

        val texture = ReleasedDynamicTexture(NativeImage.read(ByteBuffer.wrap(data.encodeToData()!!.bytes)))

        drawTexture(UMatrixStack(matrixStack), texture, Color(0x0), 0.0, 0.0, width.d, height.d)


        /*
        GL11.glTexImage2D(
            GL11C.GL_TEXTURE_2D,
            1,
            GL11C.GL_RGBA,
            width,
            height,
            1,
            GL11C.GL_RGBA,
            GL11C.GL_BYTE,
            ByteBuffer.wrap(data.encodeToData(EncodedImageFormat.BMP)!!.bytes)
        )
         */
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {
        val offs = Offset(mouseX.f, mouseY.f)
        val btn = PointerButton.of(button)
        scene.sendPointerEvent(PointerEventType.Release, offs, button = btn)
        scene.sendPointerEvent(PointerEventType.Press, offs, button = btn)
        scene.sendPointerEvent(PointerEventType.Release, offs, button = btn)

        return true
    }

    override fun mouseMoved(mouseX: Double, mouseY: Double) {
        val offs = Offset(mouseX.f, mouseY.f)
        scene.sendPointerEvent(PointerEventType.Move, offs)
    }

    override fun mouseScrolled(mouseX: Double, mouseY: Double, delta: Double): Boolean {
        scene.sendPointerEvent(PointerEventType.Scroll, Offset(mouseX.f, mouseY.f))
        return true
    }

    override fun keyPressed(keyCode: Int, scanCode: Int, modifiers: Int): Boolean {
        scene.sendKeyEvent(KeyEvent(java.awt.event.KeyEvent(object : Component() {}, java.awt.event.KeyEvent.KEY_PRESSED, System.nanoTime(), modifiers, keyCode)))
        return true
    }

    override fun keyReleased(keyCode: Int, scanCode: Int, modifiers: Int): Boolean {
        scene.sendKeyEvent(KeyEvent(java.awt.event.KeyEvent(object : Component() {}, java.awt.event.KeyEvent.KEY_RELEASED, System.nanoTime(), modifiers, keyCode)))
        return true
    }
}

internal fun drawTexture(
    matrixStack: UMatrixStack,
    texture: ReleasedDynamicTexture,
    color: Color,
    x: Double,
    y: Double,
    width: Double,
    height: Double,
    textureMinFilter: Int = GL11.GL_NEAREST,
    textureMagFilter: Int = GL11.GL_NEAREST
) {
    matrixStack.push()

    UGraphics.enableBlend()
    UGraphics.enableAlpha()
    matrixStack.scale(1f, 1f, 50f)
    val glId = texture.dynamicGlId
    UGraphics.bindTexture(0, glId)
    val red = color.red.toFloat() / 255f
    val green = color.green.toFloat() / 255f
    val blue = color.blue.toFloat() / 255f
    val alpha = color.alpha.toFloat() / 255f
    val worldRenderer = UGraphics.getFromTessellator()
    UGraphics.configureTexture(glId) {
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, textureMinFilter)
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, textureMagFilter)
    }

    worldRenderer.beginWithDefaultShader(UGraphics.DrawMode.QUADS, UGraphics.CommonVertexFormats.POSITION_TEXTURE_COLOR)

    worldRenderer.pos(matrixStack, x, y + height, 0.0).tex(0.0, 1.0).color(red, green, blue, alpha).endVertex()
    worldRenderer.pos(matrixStack, x + width, y + height, 0.0).tex(1.0, 1.0).color(red, green, blue, alpha).endVertex()
    worldRenderer.pos(matrixStack, x + width, y, 0.0).tex(1.0, 0.0).color(red, green, blue, alpha).endVertex()
    worldRenderer.pos(matrixStack, x, y, 0.0).tex(0.0, 0.0).color(red, green, blue, alpha).endVertex()
    worldRenderer.drawDirect()

    matrixStack.pop()
}