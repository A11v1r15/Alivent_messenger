package net.a11v1r15.alivent.messenger.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.world.World;

@Mixin(AllayEntity.class)
public abstract class AllayEntityMixin
extends PathAwareEntity {
    public AllayEntityMixin(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract Brain<AllayEntity> getBrain();
    
    @Inject(at = @At(value = "HEAD"), method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V")
    private void init(CallbackInfo info) {
        if (!this.world.isClient) {
            long likedPlayer = this.getBrain().getMemory(MemoryModuleType.LIKED_PLAYER);
            if (true) {
                this.world.getPlayers().forEach(player -> {if (player.getUuidAsString().equals(likedPlayer + "")) player.sendMessage(this.getDamageTracker().getDeathMessage(), false);});
            }
        }
    }
}
