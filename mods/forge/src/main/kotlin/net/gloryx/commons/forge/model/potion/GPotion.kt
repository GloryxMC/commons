package net.gloryx.commons.forge.model.potion

import cat.collections.Filter
import cat.void
import net.minecraft.entity.LivingEntity
import net.minecraft.potion.Effect
import net.minecraft.potion.EffectType

@Suppress("MemberVisibilityCanBePrivate")
abstract class GPotion(type: EffectType, liquidColor: Int) : Effect(type, liquidColor) {
    protected val does = mutableListOf<PotionAction>()
    open fun isReady(entity: LivingEntity, duration: Int, amplifier: Int) = true

    override fun performEffect(entityLiving: LivingEntity, amplifier: Int) {
        performEffect(entityLiving.getActivePotion(this)!!)
    }

    open fun performEffect(effect: BoundEffect) = if (does.isNotEmpty()) exec(effect) else performEffect(effect.entity, effect.instance.duration, effect.instance.amplifier)
    open fun performEffect(entity: LivingEntity, duration: Int, amplifier: Int) = Unit

    fun filtered(condition: Filter<BoundEffect> = { true }, action: (BoundEffect) -> Unit) =
        action(FilteredAction(condition, action))

    fun action(action: PotionAction) = does.add(action).void

    open fun exec(instance: BoundEffect) = does.forEach { it.action(instance) }
}