package net.a11v1r15.aliventmessenger;

import net.minecraft.entity.EntityType;

import java.util.*;

public class AliventColorUtil {
	public static HashMap<EntityType, int[]> VANILLA = new HashMap<>();

	static {
		VANILLA.put(EntityType.PIG,                new int[]{0xF0A5A2, 0xDB635F});
		VANILLA.put(EntityType.CREEPER,            new int[]{0x0DA70B, 0x000000});
		VANILLA.put(EntityType.ZOMBIE,             new int[]{0x00AFAF, 0x799C65});
		VANILLA.put(EntityType.SKELETON,           new int[]{0xC1C1C1, 0x494949});
		VANILLA.put(EntityType.SPIDER,             new int[]{0x342D27, 0xA80E0E});
		VANILLA.put(EntityType.SHEEP,              new int[]{0xE7E7E7, 0xFFB5B5});
		VANILLA.put(EntityType.GIANT,              new int[]{0x00AFAF, 0x799C65}); // Same as Zombie
		VANILLA.put(EntityType.COW,                new int[]{0x443626, 0xA1A1A1});
		VANILLA.put(EntityType.SLIME,              new int[]{0x51A03E, 0x7EBF6E});
		VANILLA.put(EntityType.CHICKEN,            new int[]{0xA1A1A1, 0xFF0000});
		VANILLA.put(EntityType.GHAST,              new int[]{0xF9F9F9, 0xBCBCBC});
		VANILLA.put(EntityType.ZOMBIFIED_PIGLIN,   new int[]{0xEA9393, 0x4C7129});
		VANILLA.put(EntityType.SQUID,              new int[]{0x223B4D, 0x708899});
		VANILLA.put(EntityType.WOLF,               new int[]{0xD7D3D3, 0xCEAF96});
		VANILLA.put(EntityType.SILVERFISH,         new int[]{0x6E6E6E, 0x303030});
		VANILLA.put(EntityType.CAVE_SPIDER,        new int[]{0x0C40FE, 0xA80E0E});
		VANILLA.put(EntityType.ENDERMAN,           new int[]{0x161616, 0x000000});
		VANILLA.put(EntityType.BLAZE,              new int[]{0xF67F2F, 0xFFD98E});
		VANILLA.put(EntityType.MAGMA_CUBE,         new int[]{0x340000, 0xFCFC00});
		VANILLA.put(EntityType.MOOSHROOM,          new int[]{0xA00F10, 0xB7B7B7});
		VANILLA.put(EntityType.SNOW_GOLEM,         new int[]{0xD9F2F2, 0x81A4A4});
		VANILLA.put(EntityType.VILLAGER,           new int[]{0x563C33, 0xBD8B72});
		VANILLA.put(EntityType.ENDER_DRAGON,       new int[]{0x1C1C1C, 0xE079FA});
		VANILLA.put(EntityType.OCELOT,             new int[]{0xEFDE7D, 0x564434});
		VANILLA.put(EntityType.CAT,                new int[]{0xEFC88E, 0x957256});
		VANILLA.put(EntityType.IRON_GOLEM,         new int[]{0xDBCDC2, 0x74A332});
		VANILLA.put(EntityType.ZOMBIE_VILLAGER,    new int[]{0x563C33, 0x799C65});
		VANILLA.put(EntityType.WITHER,             new int[]{0x141414, 0x4D72A0});
		VANILLA.put(EntityType.WITHER_SKELETON,    new int[]{0x141414, 0x474D4D});
		VANILLA.put(EntityType.BAT,                new int[]{0x4C3E30, 0x0F0F0F});
		VANILLA.put(EntityType.WITCH,              new int[]{0x340000, 0x51A03E});
		VANILLA.put(EntityType.HORSE,              new int[]{0xC09E7D, 0xEEE500});
		VANILLA.put(EntityType.DONKEY,             new int[]{0x534539, 0x867566});
		VANILLA.put(EntityType.MULE,               new int[]{0x1B0200, 0x51331D});
		VANILLA.put(EntityType.SKELETON_HORSE,     new int[]{0x68684F, 0xE5E5D8});
		VANILLA.put(EntityType.ZOMBIE_HORSE,       new int[]{0x315234, 0x97C284});
		VANILLA.put(EntityType.ENDERMITE,          new int[]{0x161616, 0x6E6E6E});
		VANILLA.put(EntityType.GUARDIAN,           new int[]{0x5A8272, 0xF17D30});
		VANILLA.put(EntityType.ELDER_GUARDIAN,     new int[]{0xCECCBA, 0x747693});
		VANILLA.put(EntityType.RABBIT,             new int[]{0x995F40, 0x734831});
		VANILLA.put(EntityType.SHULKER,            new int[]{0x946794, 0x4D3852});
		VANILLA.put(EntityType.HUSK,               new int[]{0x797061, 0xE6CC94});
		VANILLA.put(EntityType.POLAR_BEAR,         new int[]{0xEEEEDE, 0xD5D6CD});
		VANILLA.put(EntityType.STRAY,              new int[]{0x617677, 0xDDEAEA});
		VANILLA.put(EntityType.LLAMA,              new int[]{0xC09E7D, 0x995F40});
		VANILLA.put(EntityType.VINDICATOR,         new int[]{0x959B9B, 0x275E61});
		VANILLA.put(EntityType.EVOKER,             new int[]{0x959B9B, 0x1E1C1A});
		VANILLA.put(EntityType.VEX,                new int[]{0x7A90A4, 0xE8EDF1});
		VANILLA.put(EntityType.PARROT,             new int[]{0x0DA70B, 0xFF0000});
		VANILLA.put(EntityType.ILLUSIONER,         new int[]{0x959B9B, 0x135893}); // Same primary as Evoker and Vindicator, plus it's cloth colour
		VANILLA.put(EntityType.PHANTOM,            new int[]{0x43518A, 0x88FF00});
		VANILLA.put(EntityType.TURTLE,             new int[]{0xE7E7E7, 0x00AFAF});
		VANILLA.put(EntityType.COD,                new int[]{0xC1A76A, 0xE5C48B});
		VANILLA.put(EntityType.SALMON,             new int[]{0xA00F10, 0x0E8474});
		VANILLA.put(EntityType.PUFFERFISH,         new int[]{0xF6B201, 0x37C3F2});
		VANILLA.put(EntityType.TROPICAL_FISH,      new int[]{0xEF6915, 0xFFF9EF});
		VANILLA.put(EntityType.DROWNED,            new int[]{0x8FF1D7, 0x799C65});
		VANILLA.put(EntityType.DOLPHIN,            new int[]{0x223B4D, 0xF9F9F9});
		VANILLA.put(EntityType.PANDA,              new int[]{0xE7E7E7, 0x1B1B22});
		VANILLA.put(EntityType.PILLAGER,           new int[]{0x959B9B, 0x532F36}); // Inverted the order to align with Evoker and Vindicator
		VANILLA.put(EntityType.RAVAGER,            new int[]{0x757470, 0x5B5049});
		VANILLA.put(EntityType.TRADER_LLAMA,       new int[]{0xEAA430, 0x456296});
		VANILLA.put(EntityType.WANDERING_TRADER,   new int[]{0x456296, 0xEAA430});
		VANILLA.put(EntityType.FOX,                new int[]{0xD5B69F, 0xCC6920});
		VANILLA.put(EntityType.BEE,                new int[]{0xEDC343, 0x43241B});
		VANILLA.put(EntityType.HOGLIN,             new int[]{0xC66E55, 0x5F6464});
		VANILLA.put(EntityType.PIGLIN,             new int[]{0x995F40, 0xF9F3A4});
		VANILLA.put(EntityType.STRIDER,            new int[]{0x9C3436, 0x4D494D});
		VANILLA.put(EntityType.ZOGLIN,             new int[]{0xC66E55, 0xE6E6E6});
		VANILLA.put(EntityType.PIGLIN_BRUTE,       new int[]{0x592A10, 0xF9F3A4});
		VANILLA.put(EntityType.AXOLOTL,            new int[]{0xFBC1E3, 0xA62D74});
		VANILLA.put(EntityType.GLOW_SQUID,         new int[]{0x095656, 0x85F1BC});
		VANILLA.put(EntityType.GOAT,               new int[]{0xA5947C, 0x55493E});
		VANILLA.put(EntityType.WARDEN,             new int[]{0x0F4649, 0x39D6E0});
		VANILLA.put(EntityType.FROG,               new int[]{0xD07444, 0xFFC77C});
		VANILLA.put(EntityType.TADPOLE,            new int[]{0x6D533D, 0x160A00});
		VANILLA.put(EntityType.ALLAY,              new int[]{0x00DAFF, 0x00ADFF});
		VANILLA.put(EntityType.CAMEL,              new int[]{0xFCC369, 0xCB9337});
		VANILLA.put(EntityType.SNIFFER,            new int[]{0x871E09, 0x25AB70});
		VANILLA.put(EntityType.BREEZE,             new int[]{0xAF94DF, 0x9166DF});
		VANILLA.put(EntityType.ARMADILLO,          new int[]{0xAD716D, 0x824848});
		VANILLA.put(EntityType.BOGGED,             new int[]{0x8A9C72, 0x314D1B});
		VANILLA.put(EntityType.CREAKING,           new int[]{0x5F5F5F, 0xFC7812});
		VANILLA.put(EntityType.HAPPY_GHAST,        new int[]{0xF9F9F9, 0xE69387}); // Same primary as the Ghast plus the colour from the Ghastling inside flesh
		VANILLA.put(EntityType.COPPER_GOLEM,       new int[]{0xE3826C, 0xFFA851}); // Copper "skin" and eyes
	}
}