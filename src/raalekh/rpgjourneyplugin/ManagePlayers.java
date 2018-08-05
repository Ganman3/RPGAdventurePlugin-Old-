package raalekh.rpgjourneyplugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_12_R1.GenericAttributes;

public class ManagePlayers extends BukkitRunnable implements Listener {
	private static Map<UUID,Boolean> statCheck = new HashMap<UUID,Boolean>();
	public static Map<UUID,Boolean> getStatCheck() {
		return statCheck;
	}
	public static void setStatCheck(Map<UUID,Boolean> statCheck) {
		ManagePlayers.statCheck = statCheck;
	}
	private static Map<UUID,Boolean> classCheck = new HashMap<UUID,Boolean>();
	public static Map<UUID,Boolean> getClassCheck() {
		return classCheck;
	}
	public static void setClassCheck(Map<UUID,Boolean> classCheck) {
		ManagePlayers.classCheck = classCheck;
	}
	private String name;
	public RPGAdventurePlugin getRPGPlugin(RPGAdventurePlugin rpg) {
		return this.rpg;
	}
	private RPGAdventurePlugin rpg = RPGAdventurePlugin.getPlugin(RPGAdventurePlugin.class);
	public ManagePlayers(RPGAdventurePlugin rpg) {
		this.rpg = rpg;
		this.rpg.getServer().getPluginManager().registerEvents(this,rpg);
	}
	private File userData = new File(rpg.getDataFolder(), File.separator + "Players");
	public File getuserData(File user) {
		return userData;
	}
	private File f = new File(userData, File.separator + name +".yml");
	public File getUserFile(File g,UUID id,String name) {
		return f;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(Player player1: Bukkit.getOnlinePlayers()) {
			if(player1!=null) {
			Player player = player1.getPlayer();
			CraftPlayer cp = (CraftPlayer) player;
			if(player.getGameMode().equals(GameMode.ADVENTURE)) {
				if(player.getWorld().getName().equals("Raalekh2")) {
					UUID id = player.getUniqueId();
					name=player.getName();
					Boolean stats = statCheck.get(id);
					if(stats == null) {
						File f = new File(userData, File.separator + name + ".yml");
						FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
						if(f.exists() && playerData.getInt("Stats.Health") > 0) {
						double health = cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).getValue();
						if(playerData.getInt("Stats.Health") != health) {
							cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(playerData.getInt("Stats.Health"));
							statCheck.put(id, true);
							}
						}
					}
					Boolean classAssigned = classCheck.get(id);
					if(classAssigned == null) {
						File f = new File(userData, File.separator + name + ".yml");
						FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
						if(f.exists() && playerData.getString("Class").equals("none") && playerData.getBoolean("Waiting") == true) {
							
						}
						else if(f.exists() && playerData.getString("Class").equals("none") && playerData.getBoolean("Waiting") == false) {
							classCheck.put(id, false);
						}
					}
					
				}
			}
		}
	}
	}
}