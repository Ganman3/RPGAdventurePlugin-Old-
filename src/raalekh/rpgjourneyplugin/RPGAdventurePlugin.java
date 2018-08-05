package raalekh.rpgjourneyplugin;


/*import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;*/
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import raalekh.rpgjourneyplugin.classes.PlayerStats;
import raalekh.rpgjourneyplugin.classes.TestClassGUI;
import raalekh.rpgjourneyplugin.dependencies.NMSUtils;
import raalekh.rpgjourneyplugin.dependencies.NMSUtils.Type;
import raalekh.rpgjourneyplugin.mobs.ClearSpawnLists;
import raalekh.rpgjourneyplugin.mobs.NPCGeneric;
import raalekh.rpgjourneyplugin.mobs.NaturalMobClearing;
import raalekh.rpgjourneyplugin.mobs.NoMobDropsTest;
import raalekh.rpgjourneyplugin.mobs.PondSprite;
import raalekh.rpgjourneyplugin.mobs.PreventCombustion;
import raalekh.rpgjourneyplugin.mobs.PreventCombustion2;
import raalekh.rpgjourneyplugin.mobs.SimpleMobSpawnTest;
//import raalekh.rpgjourneyplugin.npcs.ServerTime;
import raalekh.rpgjourneyplugin.servercheck.TimeCheck;
import raalekh.rpgjourneyplugin.servercheck.WeatherCheck;
import raalekh.rpgjourneyplugin.testfeatures.SummonVillager;
import raalekh.rpgjourneyplugin.worldfit.CancelItemUI;

public class RPGAdventurePlugin extends JavaPlugin {	
	//private ConfigManager cfg;
	@SuppressWarnings("unused")
	@Override
	
	
	public void onEnable() {
		//loadConfigManager();
		BukkitTask weathercheck = new WeatherCheck(this).runTaskTimer(this,0,15);
		BukkitTask tmc = new TimeCheck(this).runTaskTimer(this,0,1);
		BukkitTask plm = new ManagePlayers(this).runTaskTimer(this,0,20);
		//BukkitTask rms = new RoutineMobSpawn(this).runTaskTimer(this, 0, 75);
		BukkitTask rlc = new RoutineLocationCheck(this).runTaskTimer(this, 0, 20);
		BukkitTask restoremana = new RestoreHunger(this).runTaskTimer(this, 0, 15);
		BukkitTask depletemana = new DepleteHunger(this).runTaskTimer(this, 0, 20);
		this.getCommand("gettext").setExecutor(new GetText(this));
		this.getCommand("vsummon").setExecutor(new SummonVillager());
		this.getServer().getPluginManager().registerEvents(new YouAreHere(), this);
		this.getCommand("phase").setExecutor(new PlayerTeleportTest());
		this.getServer().getPluginManager().registerEvents(new HoldCompass(), this);
		this.getServer().getPluginManager().registerEvents(new SimpleMobSpawnTest(), this);
		this.getCommand("clearspawns").setExecutor(new ClearSpawnLists());
		this.getServer().getPluginManager().registerEvents(new NoMobDropsTest(), this);
		this.getCommand("vsummonnew").setExecutor(new TestVillagerQuestGiver());
		this.getCommand("testclass").setExecutor(new TestClassGUI());
		this.getServer().getPluginManager().registerEvents(new CancelItemUI(), this);
		this.getServer().getPluginManager().registerEvents(new CancelItemUI(), this);
		NMSUtils.registerEntity("genericNPC", Type.VILLAGER,NPCGeneric.class, false);
		NMSUtils.registerEntity("pondsprite", Type.ZOMBIE, PondSprite.class, false);
		this.getServer().getPluginManager().registerEvents(new TestClassGUI(), this);
		this.getServer().getPluginManager().registerEvents(new NaturalMobClearing(), this);
		this.getServer().getPluginManager().registerEvents(new PreventCombustion(), this);
		//this.getServer().getPluginManager().registerEvents(new CancelHungerInAdventure(), this);
		this.getServer().getPluginManager().registerEvents(new PreventCombustion2(), this);
		this.getServer().getPluginManager().registerEvents(new CreatePlayerData(), this);
		//this.getServer().getPluginManager().registerEvents(new ExampleListener(this), this);
		//new ExampleListener(this);
		this.getServer().getPluginManager().registerEvents(new PlayerStats(), this);
	}
	
	/*public void loadConfigManager() {
		cfg = new ConfigManager();
		cfg.setup();
		cfg.savePlayers();
		cfg.reloadPlayers();
	}*/
	
	
	@Override
	
	public void onDisable() {
		
	}
}
