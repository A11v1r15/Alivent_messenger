package net.a11v1r15.alivent.messenger.mixin;

import net.a11v1r15.alivent.messenger.AliventRules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.world.World;

import org.slf4j.Logger;

import com.llamalad7.mixinextras.injector.WrapWithCondition;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

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
    private boolean jnit(Logger instance, String message, Object p0, Object p1) {
        return !this.world.getGameRules().getBoolean(AliventRules.ALIVENT_SERVER_SPAM_REMOVER);
    }
}
