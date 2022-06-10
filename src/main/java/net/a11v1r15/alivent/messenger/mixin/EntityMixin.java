package net.a11v1r15.alivent.messenger.mixin;

import net.a11v1r15.alivent.messenger.AliventRules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.world.entity.EntityLike;
import net.minecraft.world.World;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Entity.class)
public abstract class EntityMixin
implements Nameable,
EntityLike,
CommandOutput {
    @Shadow public World world;
    @ModifyVariable(
        method = "dropStack(Lnet/minecraft/item/ItemStack;F)Lnet/minecraft/entity/ItemEntity;",
        at = @At(value = "STORE"), ordinal = 0
        )
    private ItemEntity init(ItemEntity x) {
        if(this.hasCustomName() && this.world.getGameRules().getBoolean(AliventRules.ALIVENT_LORE_DROPS)){
            NbtList lore = new NbtList();
            lore.add(0, NbtString.of("{\"text\":\"" + this.getCustomName().getString() + "\"}"));
            NbtCompound display = x.getStack().getOrCreateSubNbt(ItemStack.DISPLAY_KEY);
            display.put(ItemStack.LORE_KEY, lore);
        }
        return x;
    }

    @Shadow abstract Text getDefaultName();
    @Shadow abstract EntityType<?> getType();
    @ModifyVariable(
        method = "getName()Lnet/minecraft/text/Text;",
        at = @At(value = "STORE"), ordinal = 0
        )
    private Text jnit(Text x) {
        if(x != null) {
            if(this.world.getGameRules().getBoolean(AliventRules.ALIVENT_SPECIES_NAME)){
                x = MutableText.of(new LiteralTextContent(x.getString() + " (" + this.getDefaultName().getString() + ")"));
            }
            if(SpawnEggItem.forEntity(this.getType()) != null && this.world.getGameRules().getBoolean(AliventRules.ALIVENT_NAME_COLOUR))
                ((MutableText)x).setStyle(x.getStyle().withColor(SpawnEggItem.forEntity(this.getType()).getColor(0)));
        }
        return x;
    }

    @ModifyExpressionValue(
        method = "getName()Lnet/minecraft/text/Text;", 
        at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getDefaultName()Lnet/minecraft/text/Text;")
        )
    private Text init(Text x) {
        if(SpawnEggItem.forEntity(this.getType()) != null && this.world.getGameRules().getBoolean(AliventRules.ALIVENT_NAME_COLOUR))
            ((MutableText)x).setStyle(x.getStyle().withColor(SpawnEggItem.forEntity(this.getType()).getColor(0)));
        return x;
    }
}