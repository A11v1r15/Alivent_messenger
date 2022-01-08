package net.a11v1r15.alivent.messenger.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.util.Nameable;
import net.minecraft.world.entity.EntityLike;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

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
    @ModifyVariable(at = @At(value = "STORE"), ordinal = 0, method = "dropStack(Lnet/minecraft/item/ItemStack;F)Lnet/minecraft/entity/ItemEntity;")
    private ItemEntity init(ItemEntity x) {
        if(this.hasCustomName() && this.world.getGameRules().getBoolean(GameRules.ALIVENT_LORE_DROPS)){
            NbtList lore = new NbtList();
            lore.add(0, NbtString.of("{\"text\":\"" + this.getCustomName().getString() + "\"}"));
            NbtCompound display = x.getStack().getOrCreateSubNbt(ItemStack.DISPLAY_KEY);
            display.put(ItemStack.LORE_KEY, lore);
        }
        return x;
    }
}
