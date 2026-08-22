package net.a11v1r15.aliventmessenger;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AliventMessenger implements ModInitializer {
	public static final String MOD_ID = "alivent-messenger";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, AliventMessengerConfig.class);
		LOGGER.info("TheGrimReaper entered the chat");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
