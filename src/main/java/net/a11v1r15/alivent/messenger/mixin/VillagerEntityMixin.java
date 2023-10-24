package net.a11v1r15.alivent.messenger.mixin;

import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.WrapWithCondition;

import net.a11v1r15.alivent.messenger.AliventMessenger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.world.World;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin
extends Entity {
    public VillagerEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @WrapWithCondition(
	    method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V", 
	    at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V")
    )
    private boolean aliventMessenger$conditionallyRemoveVillagerMessageFromLog(Logger instance, String message, Object p0, Object p1) {
        return !AliventMessenger.CONFIG.aliventMessageServerSpamRemover();
    }

    @WrapWithCondition(
	    method = "onStruckByLightning(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LightningEntity;)V", 
	    at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V")
    )
    private boolean aliventMessenger$conditionallyRemoveWitchMessageFromLog(Logger instance, String message, Object p0, Object p1) {
        return !AliventMessenger.CONFIG.aliventMessageServerSpamRemover();
    }
}
