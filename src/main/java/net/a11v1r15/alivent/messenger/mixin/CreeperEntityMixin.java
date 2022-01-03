package net.a11v1r15.alivent.messenger.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.explosion.Explosion;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntity.class)
public class CreeperEntityMixin {
	CreeperEntity This = ((CreeperEntity)(Object)this);
	@Inject(at = @At(value = "HEAD"), method = "explode()V")
	private void init(CallbackInfo info) {
        if (!This.world.isClient &&
		     This.world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) &&
		     This.hasCustomName()) {
				 This.damage(DamageSource.explosion(This.world.createExplosion(null, This.getX(), This.getY(), This.getZ(), 0, Explosion.DestructionType.NONE)), Float.MAX_VALUE);
		}
	}
}
