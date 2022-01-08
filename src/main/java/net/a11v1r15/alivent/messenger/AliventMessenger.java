package net.a11v1r15.alivent.messenger;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Category;

public class AliventMessenger implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LogManager.getLogger("Alivent");

    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_ALL_MOBS = GameRuleRegistry.register("aliventAllMobs", Category.MOBS, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_VILLAGERS = GameRuleRegistry.register("aliventVillagers", Category.MOBS, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> ALIVENT_LORE_DROPS = GameRuleRegistry.register("aliventLoreDrops", Category.MOBS, GameRuleFactory.createBooleanRule(true));

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        LOGGER.info("TheGrimReaper entered the chat");
    }
}
