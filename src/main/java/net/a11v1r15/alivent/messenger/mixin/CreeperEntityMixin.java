package net.a11v1r15.alivent.messenger.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.a11v1r15.alivent.messenger.AliventRules;
import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin
extends HostileEntity
implements SkinOverlayOwner {
	protected CreeperEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Inject(at = @At(value = "HEAD"), method = "explode()V")
	private void init(CallbackInfo info) {
        if (!this.world.isClient &&
		     this.world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) &&
		     (this.hasCustomName() || this.world.getGameRules().getBoolean(AliventRules.ALIVENT_ALL_MOBS))) {
				 this.damage(DamageSource.explosion(this.world.createExplosion(null, this.getX(), this.getY(), this.getZ(), 0, World.ExplosionSourceType.NONE)), Float.MAX_VALUE);
		}
	}
}
