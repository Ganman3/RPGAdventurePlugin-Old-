package raalekh.rpgjourneyplugin.classes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.event.entity.EntityDamageEvent;
//import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_12_R1.GenericAttributes;
//import raalekh.rpgjourneyplugin.GetText;
import raalekh.rpgjourneyplugin.ManagePlayers;
import raalekh.rpgjourneyplugin.RPGAdventurePlugin;

//import net.minecraft.server.v1_12_R1.AttributeInstance;
//import net.minecraft.server.v1_12_R1.EntityPlayer;
//import net.minecraft.server.v1_12_R1.GenericAttributes;

public class PlayerStats implements Listener {
	public static int expToLevel;
	public UUID id;
	private String name;
	public RPGAdventurePlugin getRPGPlugin(RPGAdventurePlugin rpg) {
		return this.rpg;
	}
	private RPGAdventurePlugin rpg = RPGAdventurePlugin.getPlugin(RPGAdventurePlugin.class);
	private File userData = new File(rpg.getDataFolder(), File.separator + "Players");
	public File getuserData(File user) {
		return userData;
	}
	private File f = new File(userData, File.separator + name +".yml");
	public File getUserFile(File g,UUID id,String name) {
		return f;
	}
	
	private static Map<UUID,Double> playerHealthMap = new HashMap<UUID,Double>();
	private static Map<UUID,Double> playerAttackMap = new HashMap<UUID,Double>();
	private static Map<UUID,Double> playerDefenseMap = new HashMap<UUID,Double>();
	
	
	public static void setphmap(HashMap<UUID,Double> playerHealthMap) {
		PlayerStats.playerHealthMap = playerHealthMap;
	}
	public static void setpamap(HashMap<UUID,Double> playerAttackMap) {
		PlayerStats.playerAttackMap = playerAttackMap;
	}
	public static void setpdmap(HashMap<UUID,Double> playerDefenseMap) {
		PlayerStats.playerDefenseMap = playerDefenseMap;
	}
	public static Map<UUID,Double> getphmap() {
		return PlayerStats.playerHealthMap;
	}
	public static Map<UUID,Double> getpamap() {
		return PlayerStats.playerAttackMap;
	}
	public static Map<UUID,Double> getpdmap() {
		return PlayerStats.playerDefenseMap;
	}
	
	public void setStats(Player player, int currentLevel) {
		String name = player.getName();
		File f = new File(userData, File.separator + name + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		if(playerData.getString("Class").equals("none")) {
			CraftPlayer cp = (CraftPlayer) player;
			cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(1 + 0.02 * currentLevel);
			double health = cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).getValue();
			
			double attack = 1 + 0.02 * currentLevel;
			
			double defense = 1 + 0.02 * currentLevel;
			
			double attunement = 1 + 0.02 * currentLevel;
			
			double resistance = 1 + 0.02 * currentLevel;
			
			double speed = 2 + 0.02 * currentLevel;
			
			double diplomacy = 2 + 0.02 * currentLevel;
			
			double dodge = 2 + 0.02 * currentLevel;
			
			double absorption = 1 + 0.02 * currentLevel;
			
			double luck = 1 + 0.02 * currentLevel;
			
			try {
				playerData.set("Stats.Health", health);
				playerData.set("Stats.Attack", attack);
				playerData.set("Stats.Defense", defense);
				playerData.set("Stats.Attunement", attunement);
				playerData.set("Stats.Resistance", resistance);
				playerData.set("Stats.Speed", speed);
				playerData.set("Stats.Diplomacy", diplomacy);
				playerData.set("Stats.Dodge", dodge);
				playerData.set("Stats.Absorption", absorption);
				playerData.set("Stats.Luck", luck);
				playerData.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	public static void addExperience(Player player, int currentLevel, int experienceGained, float LevelBar) {
		//CraftPlayer cp = (CraftPlayer) player;
		//UUID id = player.getUniqueId();
		if(currentLevel < 5) {
			int expToLevel = 60 + ((currentLevel * currentLevel)*30);
			/*Double attack = 1.0; Double defense = 1.0; Double health = 6.0;
			playerHealthMap.put(id,health);
			playerDefenseMap.put(id, defense);
			playerAttackMap.put(id, attack);
			cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(health);
			cp.getHandle().getAttributeInstance(GenericAttributes.h).setValue(defense);
			cp.getHandle().getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(attack);
			cp.getHandle().getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.699999988079071);*/
			double initialtotalExperience = (double)(LevelBar * expToLevel); 
			if(initialtotalExperience + experienceGained >= expToLevel) {
				double finalExperience = initialtotalExperience + experienceGained - expToLevel;
				player.setLevel(currentLevel += 1);
				player.setExp((float)finalExperience / expToLevel);
				System.out.println(expToLevel);
				System.out.println(finalExperience);
				System.out.println(initialtotalExperience);
			}
			else {
				double finalExperience = initialtotalExperience + experienceGained;
				player.setExp((float)finalExperience/expToLevel);
			}
		}
		else if(currentLevel < 10 && currentLevel >= 5) {
			int expToLevel = 540 + ((currentLevel - 3) * (currentLevel - 3) /3);
			double initialtotalExperience = (double)(LevelBar * expToLevel); 
			if(initialtotalExperience + experienceGained >= expToLevel) {
				double finalExperience = initialtotalExperience + experienceGained - expToLevel;
				player.setLevel(currentLevel += 1);
				player.setExp((float)finalExperience / expToLevel);
			}
			else {
				double finalExperience = initialtotalExperience + experienceGained;
				player.setExp((float)finalExperience/expToLevel);
			}
		}
		else if(currentLevel >= 10 && currentLevel < 30) {
			int expToLevel = 2000 + ((currentLevel * currentLevel * currentLevel) /3);
			double initialtotalExperience = (double)(LevelBar * expToLevel); 
			if(initialtotalExperience + experienceGained >= expToLevel) {
				double finalExperience = initialtotalExperience + experienceGained - expToLevel;
				player.setLevel(currentLevel += 1);
				player.setExp((float)finalExperience / expToLevel);
			}
			else {
				double finalExperience = initialtotalExperience + experienceGained;
				player.setExp((float)finalExperience/expToLevel);
			}
		}

	}
	@EventHandler
	public void resetManagePlayers (PlayerGameModeChangeEvent e) {
		Player player = e.getPlayer();
		if(player.getWorld().getName().equals("Raalekh2")) {
			
				UUID id = player.getUniqueId();
				ManagePlayers.getStatCheck().remove(id);
			}
		}
	@EventHandler
	public void resetManagePlayers2 (PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if(player.getWorld().getName().equals("Raalekh2")) {
			
				UUID id = player.getUniqueId();
				ManagePlayers.getStatCheck().remove(id);
			}
		}

	@EventHandler
	public void resetManagePlayers3 (PlayerChangedWorldEvent e) {
	Player player = e.getPlayer();
	if(player.getWorld().getName().equals("Raalekh2")) {
		
			UUID id = player.getUniqueId();
			ManagePlayers.getStatCheck().remove(id);
		}
	}

}

	


	

