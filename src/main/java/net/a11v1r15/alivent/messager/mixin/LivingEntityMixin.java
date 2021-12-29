package net.a11v1r15.alivent.messager.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	LivingEntity This = ((LivingEntity)(Object)this);
	@Inject(at = @At(value = "HEAD"), method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V")
	private void init(CallbackInfo info) {
        if (!This.world.isClient &&
		     This.world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) &&
		     This.hasCustomName()) {
				 final boolean test = (This instanceof TameableEntity && ((TameableEntity)This).getOwner() instanceof ServerPlayerEntity);
				 This.world.getPlayers().forEach(player -> {if(!(test && ((TameableEntity)This).getOwnerUuid() == player.getUuid())) player.sendSystemMessage(This.getDamageTracker().getDeathMessage(), Util.NIL_UUID);});
		}
	}
}
