package net.a11v1r15.alivent.messenger;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Category;

public class AliventRules {
    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_ALL_MOBS = GameRuleRegistry.register("aliventAllMobs", Category.MOBS, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_VILLAGERS = GameRuleRegistry.register("aliventVillagers", Category.MOBS, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_LORE_DROPS = GameRuleRegistry.register("aliventLoreDrops", Category.MOBS, GameRuleFactory.createBooleanRule(true));
    //public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_SPECIES_NAME = GameRuleRegistry.register("aliventSpeciesName", Category.MOBS, GameRuleFactory.createBooleanRule(false));
}