package net.a11v1r15.alivent.messager.mixin;

import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerEntity.class)
public class VillagerEntityMixin {
	VillagerEntity This = ((VillagerEntity)(Object)this);
	@Inject(at = @At(value = "HEAD"), method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V")
	private void init(CallbackInfo info) {
        if (!This.world.isClient &&
		     This.world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) &&
		     This.world instanceof ServerWorld &&
		    !This.hasCustomName()) {
				This.world.getPlayers().forEach(player -> player.sendSystemMessage(This.getDamageTracker().getDeathMessage(), Util.NIL_UUID));
		}
	}
}
