package net.a11v1r15.aliventmessenger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import eu.midnightdust.lib.config.MidnightConfig;

public class AliventMessenger implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "alivent-messenger";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        MidnightConfig.init(MOD_ID, AliventMessengerConfig.class);
        LOGGER.info("TheGrimReaper entered the chat");
    }
}
