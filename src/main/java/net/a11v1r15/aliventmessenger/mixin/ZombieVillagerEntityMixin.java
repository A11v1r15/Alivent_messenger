package net.a11v1r15.aliventmessenger.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.text.Text;
import net.minecraft.registry.Registries;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.World;

@Mixin(ZombieVillagerEntity.class)
public abstract class ZombieVillagerEntityMixin
extends ZombieEntity{
	public ZombieVillagerEntityMixin(EntityType<? extends ZombieEntity> entityType, World world) {
		super(entityType, world);
	}
	@Shadow abstract VillagerData getVillagerData();
	@Override
    protected Text getDefaultName() {
		if(!this.getVillagerData().getProfession().equals(VillagerProfession.NONE)){
			Text profession = Text.translatable(this.getType().getTranslationKey().replace("zombie_", "") + "." + Registries.VILLAGER_PROFESSION.getId(this.getVillagerData().getProfession()).getPath());
			Text specie = this.getType().getName();
			return Text.translatable("commands.list.nameAndId", specie, profession);
		}
		return this.getType().getName();
    }
}
