package com.camellias.gulliverreborn;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config
{
	public static Configuration config;
	
	public static float MAX_SIZE;

	public static boolean HARVEST_MODIFIER;
	
	public static boolean DO_ADJUSTED_RENDER;
	public static boolean PICKUP_SMALL_ENTITIES;
	public static boolean RIDE_BIG_ENTITIES;
	public static boolean CLIMB_SOME_BLOCKS;
	public static boolean CLIMB_WITH_SLIME;
	public static boolean GLIDE_WITH_PAPER;
	public static boolean HOT_BLOCKS_GIVE_LIFT;
	public static boolean ROSES_HURT;
	public static boolean PLANTS_SLOW_SMALL_DOWN;
	public static boolean SMALL_IS_INVISIBLE_TO_NONCATS_OR_NONSPIDERS;
	
	public static void init(File file)
	{
		config = new Configuration(file);
		
		String category;
		
		category = "Gulliver Reborn Config Options";
		config.addCustomCategoryComment(category, "");
		
		MAX_SIZE = config.getFloat("Set the maximum player size", category, Float.MAX_VALUE, 1F, Float.MAX_VALUE, "Max player size");
		DO_ADJUSTED_RENDER = config.getBoolean("Player render is more normal at small sizes, but may cause problems with other mods", category, true, "Enable the re-scaled player render?");
		PICKUP_SMALL_ENTITIES = config.getBoolean("Enable/disable the ability to pick up small entities", category, true, "Can players pick up smaller entities?");
		RIDE_BIG_ENTITIES = config.getBoolean("Enable/disable the ability to ride large entities with String", category, true, "Can small players ride bigger entities with String?");
		CLIMB_SOME_BLOCKS = config.getBoolean("Enable/disable the ability to climb some blocks (dirt, grass, leaves, etc)", category, true, "Are some blocks naturally climbable?");
		CLIMB_WITH_SLIME = config.getBoolean("Enable/disable the ability to climb with Slimeballs or Slime Blocks", category, true, "Can small players climb with Slimeballs/Slime Blocks?");
		GLIDE_WITH_PAPER = config.getBoolean("Enable/disable the ability to glide with paper", category, true, "Can small players glide with paper?");
		HOT_BLOCKS_GIVE_LIFT = config.getBoolean("Enable/disable hot blocks giving gliding players lift (requires the ability to glide with paper to be enabled)", category, true, "Do hot blocks give lift?");
		ROSES_HURT = config.getBoolean("Enable/disable rose/poppy thorns", category, true, "Do Rose Bushes/Poppies hurt small players?");
		PLANTS_SLOW_SMALL_DOWN = config.getBoolean("Enable/disable plants slowing down small players", category, true, "Do small players get slowed by plants?");
		SMALL_IS_INVISIBLE_TO_NONCATS_OR_NONSPIDERS = config.getBoolean("Enable/disable the ability for small players to be unnoticed by non-ocelots and non-spiders", category, true, "Are small players undetected by non-ocelots/non-spiders?");

		HARVEST_MODIFIER = config.getBoolean("Enable/disable the harvest speed modifier", category, true, "Harvest speed is scaled with size");

		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		GulliverReborn.config = new File(event.getModConfigurationDirectory() + "/" + GulliverReborn.MODID);
		GulliverReborn.config.mkdirs();
		init(new File(GulliverReborn.config.getPath(), GulliverReborn.MODID + ".cfg"));
	}
}
