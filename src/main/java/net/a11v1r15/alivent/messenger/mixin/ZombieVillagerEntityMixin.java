package net.a11v1r15.alivent.messenger.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

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
			TranslatableText profession = new TranslatableText(this.getType().getTranslationKey().replace("zombie_", "") + "." + Registry.VILLAGER_PROFESSION.getId(this.getVillagerData().getProfession()).getPath());
			return new LiteralText(profession.getString() + " (" + super.getDefaultName() + ")");
		}
		return super.getDefaultName();
    }
}
