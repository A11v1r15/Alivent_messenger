package net.a11v1r15.aliventmessenger.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;

import net.a11v1r15.aliventmessenger.AliventMessengerConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Objects;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin
		extends MerchantEntity {
	public VillagerEntityMixin(EntityType<? extends MerchantEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "onDeath", at = @At("HEAD"))
	private void aliventMessenger$onVillagerDeath(DamageSource damageSource, CallbackInfo ci) {
		if (!(this.getEntityWorld() instanceof ServerWorld serverWorld)) return;
		if (!serverWorld.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES)) return;
		if (!AliventMessengerConfig.villagerMessages) return;

		List<ServerPlayerEntity> players = Objects.requireNonNull(serverWorld.getServer()).getPlayerManager().getPlayerList();
		players.forEach(player -> player.sendMessage(this.getDamageTracker().getDeathMessage(), false));
	}


	@WrapWithCondition(
			method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V",
			at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V")
	)
	private boolean aliventMessenger$conditionallyRemoveVillagerMessageFromLog(Logger instance, String message, Object p0, Object p1) {
		return !AliventMessengerConfig.aliventMessageServerSpamRemover;
	}

	@WrapWithCondition(
			method = "onStruckByLightning(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LightningEntity;)V",
			at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V")
	)
	private boolean aliventMessenger$conditionallyRemoveWitchMessageFromLog(Logger instance, String message, Object p0, Object p1) {
		return !AliventMessengerConfig.aliventMessageServerSpamRemover;
	}
}
