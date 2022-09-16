package net.gloryx.commons.forge.kotlinlove

import net.minecraft.potion.Effect
import net.minecraft.potion.EffectInstance

operator fun EffectInstance.component1(): Effect = potion
operator fun EffectInstance.component2(): Int = duration
operator fun EffectInstance.component3(): Int = amplifier