package raalekh.rpgjourneyplugin.mobs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//import java.util.HashMap;

import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

//import raalekh.rpgjourneyplugin.PlayerStats;
import raalekh.rpgjourneyplugin.RPGAdventurePlugin;



public class SimpleMobSpawnTest implements Listener {
	
	private static ArrayList<UUID> pond1list = new ArrayList<UUID>();
	
	public void setList(ArrayList<UUID> pond1list) {
		SimpleMobSpawnTest.pond1list = pond1list;
	}
	
	static ArrayList<UUID> getpond1list() {
		return SimpleMobSpawnTest.pond1list;
	}	
	
	private static ArrayList<UUID> camp1list = new ArrayList<UUID>();
	
	public void set2List(ArrayList<UUID> camp1list) {
		SimpleMobSpawnTest.camp1list = camp1list;
	}
	
	static ArrayList<UUID> getcamp1list() {
		return SimpleMobSpawnTest.camp1list;
	}
	private String name;
	public RPGAdventurePlugin plugin = RPGAdventurePlugin.getPlugin(RPGAdventurePlugin.class);
	private RPGAdventurePlugin rpg = RPGAdventurePlugin.getPlugin(RPGAdventurePlugin.class);
	private File userData = new File(rpg.getDataFolder(), File.separator + "Players");
	public File getuserData(File user) {
		return userData;
	}
	private File f = new File(userData, File.separator + name +".yml");
	public File getUserFile(File g,UUID id,String name) {
		return f;
	}
	
	@EventHandler
	public void WalkTest (PlayerMoveEvent e) {
		Player player = e.getPlayer();
		String name = player.getName();
		World worldspawn = player.getWorld();
		Location spawnCheck = player.getLocation();
		//Check if player's world is adventure, and if they're in the right location.
		double x1 = spawnCheck.getX();
		double y1 = spawnCheck.getY();
		double z1 = spawnCheck.getZ();
		UUID playerid = player.getUniqueId();
		File userData = new File(plugin.getDataFolder(), File.separator + "Players");
		File f = new File(userData, File.separator + name +".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
	
		
		String checkWorld = player.getWorld().getName();
		
			
		if(checkWorld.equals("Raalekh2")) {
			if(player.getGameMode().equals(GameMode.ADVENTURE)) {	
			
			if(x1 <= 370 && x1 > 325) {
				if(y1 <= 88 && y1 > 60) {
					if(z1 <= 176 && z1 > 141) {
						if(playerData.contains("Camps.PondCamp1") == true) {
							return;
							
						}
						for(UUID pond1id: pond1list) {
							if (pond1id.equals(playerid)) {
								return;
							}
						}
						
						
						//NavigationAbstract navigation = pondsprite.getNavigation();
						//PathEntity path = navigation.a(350, 67, 164);
						//navigation.a(path, 0.5);
						
						PondSprite.spawn(new Location(worldspawn, 350,67,164)).setCustomName("Pond Sprite");
						PondSprite.spawn(new Location(worldspawn, 343,67,165)).setCustomName("Pond Sprite");
						PondSprite.spawn(new Location(worldspawn, 352,66,162)).setCustomName("Pond Sprite");
						PondSprite.spawn(new Location(worldspawn, 356,64,150)).setCustomName("Pond Sprite");
						PondSprite.spawn(new Location(worldspawn, 348,63,150)).setCustomName("Pond Sprite");
						PondSprite.spawn(new Location(worldspawn, 345,67,141)).setCustomName("Pond Sprite");
						
						
						pond1list.add(playerid);
						try {
						playerData.createSection("Camps.PondCamp1");
						playerData.save(f);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						
			}
			}
		}
			
			if (x1 <= 411 && x1 > 373) {
				if (y1 <= 83 && y1 > 67) {
					if (z1 <= 232 && z1 > 171) {
						for (UUID camp1id: camp1list) {
							if(camp1id.equals(playerid)) {
								return;
							}
						}
						Skeleton skeleton1 = player.getWorld().spawn(new Location(worldspawn, 392, 67, 210), Skeleton.class);
						Skeleton skeleton2 = player.getWorld().spawn(new Location(worldspawn, 373, 65, 214), Skeleton.class);
						Skeleton skeleton3 = player.getWorld().spawn(new Location(worldspawn, 380, 65, 202), Skeleton.class);
						Skeleton skeleton4 = player.getWorld().spawn(new Location(worldspawn, 397, 66, 195), Skeleton.class);
						skeleton1.setCustomName("Camp Corpse");
						skeleton2.setCustomName("Camp Corpse");
						skeleton3.setCustomName("Camp Corpse");
						skeleton4.setCustomName("Camp Corpse");
						System.out.println("Hello310");
						camp1list.add(playerid);	
						
						
				    	}
					}
				}
			}
		if((int)player.getVelocity().getY() >= 0 && player.isOnGround() == true && playerData.getBoolean("Objectives.Values.SlowFall") == true && playerData.getBoolean("Objectives.Values.SlowFall",true)) {
    		playerData.set("Objectives.Values.SlowFall", false);
    		player.removePotionEffect(PotionEffectType.LEVITATION);
		}
		
}
	
	/*private void PondSprite1(Location location) {
		// TODO Auto-generated method stub
		
	}*/

	
	}
}