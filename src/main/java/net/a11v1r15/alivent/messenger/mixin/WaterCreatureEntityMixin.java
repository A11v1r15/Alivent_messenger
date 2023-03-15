package net.a11v1r15.alivent.messenger.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

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

	
	@ModifyArgs(method = "tickWaterBreathingAir(I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
	private void injected(Args args) {
		DamageSource a0 = args.get(0);
		float a1 = args.get(1);
		args.set(0, this.getDamageSources().dryOut());
		args.set(1, a1);
	}
}
