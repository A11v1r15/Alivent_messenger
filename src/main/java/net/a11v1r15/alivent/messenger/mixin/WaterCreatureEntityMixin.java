package net.a11v1r15.alivent.messenger.mixin;

import net.minecraft.entity.damage.DamageSources;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;

@Mixin(WaterCreatureEntity.class)
public abstract class WaterCreatureEntityMixin
extends PathAwareEntity {
	protected WaterCreatureEntityMixin(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}

    @Redirect(method = "tickWaterBreathingAir(I)V",
              at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/damage/DamageSources;drown()Lnet/minecraft/entity/damage/DamageSource;"))
    private DamageSource alivent$changeDrownToDryOut(DamageSources instance) {
        return instance.dryOut();
    }
}
