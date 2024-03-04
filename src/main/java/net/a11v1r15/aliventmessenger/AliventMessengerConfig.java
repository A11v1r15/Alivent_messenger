package net.a11v1r15.aliventmessenger;

import net.a11v1r15.aliventmessenger.config.TinyConfig;

public class AliventMessengerConfig extends TinyConfig {
    @Entry //Gives aliven't messages for all mobs, instead of just ones with custom names
    public boolean allMobMessages = false;

    @Entry //Gives aliven't messages for all Villagers and Zombie Villagers with trades
    public boolean villagerMessages = true;

    @Entry //Gives lore info for items dropped from named mobs
    public boolean loreDrops = true;

    @Entry //The names of the mobs will appear with colour
    public boolean nameColour = false;

    @Entry //The aliven't message for named mobs will display their "species" between parenthesis
    public boolean speciesName = false;

    @Entry //Removes the near-retundant log message of aliven't villagers and custom-named mobs
    public boolean aliventMessageServerSpamRemover = true;
}
