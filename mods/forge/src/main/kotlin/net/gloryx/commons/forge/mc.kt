package net.gloryx.commons.forge

import de.themoep.minedown.adventure.MineDown
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import net.minecraft.client.Minecraft
import net.minecraft.util.text.IFormattableTextComponent
import net.minecraft.util.text.ITextComponent

val mc: Minecraft get() = Minecraft.getInstance()

val gsonComponentSerializer by lazy {
    GsonComponentSerializer.gson()
}
val Component.mc: IFormattableTextComponent
    get() = ITextComponent.Serializer.getComponentFromJson(
        gsonComponentSerializer.serialize(
            this
        )
    ) ?: throw IllegalArgumentException("The input component $this is invalid!")
val String.md: Component get() = MineDown.parse(this)
val String.mc: IFormattableTextComponent
    get() = md.mc