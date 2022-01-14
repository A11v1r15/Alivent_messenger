package net.a11v1r15.alivent.messenger;

import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Category;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AliventRules {
    public static final Logger LOGGER = LogManager.getLogger("Alivent");

    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_ALL_MOBS = GameRuleRegistry.register("aliventAllMobs", Category.CHAT, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_VILLAGERS = GameRuleRegistry.register("aliventVillagers", Category.CHAT, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_LORE_DROPS = GameRuleRegistry.register("aliventLoreDrops", Category.DROPS, GameRuleFactory.createBooleanRule(true));
    //public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_NAME_COLOUR = GameRuleRegistry.register("aliventNameColour", Category.CHAT, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_SPECIES_NAME = GameRuleRegistry.register("aliventSpeciesName", Category.MOBS, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_SERVER_SPAM_REMOVER = GameRuleRegistry.register("aliventServerSpamRemover", Category.MISC, GameRuleFactory.createBooleanRule(true));

    public static void startGameRules(){
        LOGGER.info("TheGrimReaper entered the chat");
    }
}