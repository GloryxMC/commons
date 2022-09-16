package net.gloryx.commons.forge.model.potion

import cat.collections.Filter
import cat.ticks
import net.minecraft.entity.LivingEntity
import net.minecraft.potion.Effect
import net.minecraft.potion.EffectInstance
import org.jetbrains.annotations.ApiStatus.NonExtendable

fun EffectInstance.bind(entity: LivingEntity) = BoundEffect(this, entity)

data class BoundEffect(val instance: EffectInstance, val entity: LivingEntity) {
    val amplifier get() = instance.amplifier
    val duration get() = instance.duration.ticks
}

@NonExtendable
abstract class PotionAction(val action: (BoundEffect) -> Unit)

class FilteredAction(val filter: Filter<BoundEffect>, action: (BoundEffect) -> Unit) :
    PotionAction({ if (filter(it)) action(it) })

fun LivingEntity.getActivePotion(potion: Effect): BoundEffect? = getActivePotionEffect(potion)?.bind(this)