package net.a11v1r15.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	private static final Logger LOGGER2 = LogManager.getLogger("TheGrimReaper");

	@Inject(at = @At(value = "TAIL"), method = "onDeath()V")
	private void init(CallbackInfo info) {
		LOGGER2.info(((LivingEntity)(Object)this).getDamageTracker().getDeathMessage().getString());
	}
}
