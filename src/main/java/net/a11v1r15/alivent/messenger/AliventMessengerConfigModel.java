package net.a11v1r15.alivent.messenger;

import blue.endless.jankson.Comment;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.*;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Category;

@SuppressWarnings("unused")
@Modmenu(modId = "alivent-messenger")
@Config(name = "alivent-messenger", wrapperName = "AliventMessengerConfig")
public class AliventMessengerConfigModel {

    @Comment("Gives aliven't messages for all mobs, instead of just ones with custom names")
    public boolean allMobMessages = false;

    @Comment("Gives aliven't messages for all Villagers and Zombie Villagers with trades")
    public boolean villagerMessages = true;

    @Comment("Gives lore info for items dropped from named mobs")
    public boolean loreDrops = true;

    @Comment("The names of the mobs will appear with colour")
    public boolean nameColour = false;

    @Comment("The aliven't message for named mobs will display their \"species\" between parenthesis")
    public boolean speciesName = false;

    @Comment("Removes the near-retundant log message of aliven't villagers and custom-named mobs")
    public boolean aliventMessageServerSpamRemover = true;
}
