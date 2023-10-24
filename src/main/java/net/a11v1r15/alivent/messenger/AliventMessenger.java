package net.a11v1r15.alivent.messenger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class AliventMessenger implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "alivent-messenger";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final net.a11v1r15.alivent.messenger.AliventMessengerConfig CONFIG = net.a11v1r15.alivent.messenger.AliventMessengerConfig.createAndLoad();

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        
        LOGGER.info("TheGrimReaper entered the chat");
    }
}
