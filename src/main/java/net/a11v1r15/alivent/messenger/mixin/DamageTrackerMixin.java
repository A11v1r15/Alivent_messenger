package net.a11v1r15.alivent.messenger.mixin;

//import net.a11v1r15.alivent.messenger.AliventRules;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTracker;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DamageTracker.class)
public abstract class DamageTrackerMixin {
    @Shadow public LivingEntity entity;
    @ModifyExpressionValue(
        method = "getDeathMessage()Lnet/minecraft/text/Text;", 
        at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getDisplayName()Lnet/minecraft/text/Text;")
    )
    private Text init(Text x) {
        //if(this.entity.world.getGameRules().getBoolean(AliventRules.ALIVENT_SPECIES_NAME)){
            x = new LiteralText(x.getString() + " (" + this.entity.getType().getName().getString() + ")");
        //}
        return x;
    }
}
