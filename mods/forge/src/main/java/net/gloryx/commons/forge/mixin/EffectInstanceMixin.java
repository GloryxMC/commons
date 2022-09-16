package net.gloryx.commons.forge.mixin;

import net.gloryx.commons.forge.model.potion.GPotion;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EffectInstance.class)
public abstract class EffectInstanceMixin {
    @Shadow
    private int duration;

    @Shadow
    private int amplifier;

    @Shadow
    @Final
    private Effect potion;

    @Shadow
    public abstract void performEffect(LivingEntity entity);

    @Shadow
    protected abstract int deincrementDuration();

    @Shadow
    EffectInstance hiddenEffects;

    @Shadow
    abstract void func_230117_a_(EffectInstance instance);

    /*
    @SuppressWarnings({"ConstantConditions"})
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/potion/EffectInstance;performEffect(Lnet/minecraft/entity/LivingEntity;)V"))
    private void gReady(LivingEntity entity, Runnable ticking, CallbackInfoReturnable<Boolean> info) {
        boolean isReady = potion.isReady(duration, amplifier);
        if (((Object) this) instanceof GPotion)
            isReady = isReady || ((GPotion) (Object) this).isReady(entity, duration, amplifier);


    }
     */

    /**
     * @author nothen
     * @reason To tick with GPotion & LivingEntity
     */
    @Overwrite
    public boolean tick(LivingEntity entity, Runnable ticking) {
        if (this.duration > 0) {
            boolean isReady = this.potion.isReady(this.duration, this.amplifier);
            if (this.potion instanceof GPotion) isReady = isReady || ((GPotion) this.potion).isReady(entity, duration, amplifier);
            if (isReady) {
                this.performEffect(entity);
            }

            this.deincrementDuration();
            if (this.duration == 0 && this.hiddenEffects != null) {
                this.func_230117_a_(this.hiddenEffects);
                this.hiddenEffects = ((EffectInstanceMixin) (Object) this.hiddenEffects).hiddenEffects;
                ticking.run();
            }
        }

        return this.duration > 0;
    }


}
