package net.a11v1r15.alivent.messenger.mixin;

import net.a11v1r15.alivent.messenger.AliventRules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTracker;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import org.slf4j.Logger;

import com.llamalad7.mixinextras.injector.WrapWithCondition;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin
extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow abstract DamageTracker getDamageTracker();
    
    @Inject(at = @At(value = "HEAD"), method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V")
    private void init(CallbackInfo info) {
        if (!this.world.isClient &&
            this.world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES)) {
            if (this.hasCustomName() || this.world.getGameRules().getBoolean(AliventRules.ALIVENT_ALL_MOBS)) {
                final boolean test = ((Object)this instanceof TameableEntity && ((TameableEntity)(Object)this).getOwner() instanceof ServerPlayerEntity);
                this.world.getPlayers().forEach(player -> {if (!(test && ((TameableEntity)(Object)this).getOwnerUuid() == player.getUuid())) player.sendSystemMessage(this.getDamageTracker().getDeathMessage(), Util.NIL_UUID);});
            } else if(this.world.getGameRules().getBoolean(AliventRules.ALIVENT_VILLAGERS)){
                if ((Object)this instanceof VillagerEntity) {
                    this.world.getPlayers().forEach(player -> player.sendSystemMessage(this.getDamageTracker().getDeathMessage(), Util.NIL_UUID));
                } else if ((Object)this instanceof ZombieVillagerEntity && !(((ZombieVillagerEntity)(Object)this).canImmediatelyDespawn(Double.MAX_VALUE))) {
                    this.world.getPlayers().forEach(player -> player.sendSystemMessage(this.getDamageTracker().getDeathMessage(), Util.NIL_UUID));
                }
            }
        }
    }

    @WrapWithCondition(
	    method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V", 
	    at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V")
    )
    private boolean jnit(Logger instance, String message, Object p0, Object p1) {
        return !this.world.getGameRules().getBoolean(AliventRules.ALIVENT_SERVER_SPAM_REMOVER);
    }
}
