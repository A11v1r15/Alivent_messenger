package net.a11v1r15.alivent.messenger.mixin;

import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerProfession;

import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombieVillagerEntity.class)
public class ZombieVillagerEntityMixin{
	ZombieVillagerEntity This = ((ZombieVillagerEntity)(Object)this);
    protected Text getDefaultName() {
		if(!This.getVillagerData().getProfession().equals(VillagerProfession.NONE)){
			TranslatableText profession = new TranslatableText(This.getType().getTranslationKey().replace("zombie_", "") + "." + Registry.VILLAGER_PROFESSION.getId(This.getVillagerData().getProfession()).getPath());
        	TranslatableText zombie = new TranslatableText("entity.minecraft.zombie_villager");
			return new LiteralText(profession.getString() + " (" + zombie.getString() + ")");
		}
		return new TranslatableText("entity.minecraft.zombie_villager");
    }
}
