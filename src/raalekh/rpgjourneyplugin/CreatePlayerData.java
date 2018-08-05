//Gives new players properly detailed configuration files on login. Bug: players in survival
//gamemode should not be affected by calculations made in the PlayerStats class.
package raalekh.rpgjourneyplugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import raalekh.rpgjourneyplugin.classes.PlayerStats;

public class CreatePlayerData implements Listener {
	private RPGAdventurePlugin plugin = RPGAdventurePlugin.getPlugin(RPGAdventurePlugin.class);
	private File userData = new File(plugin.getDataFolder(), File.separator + "Players");
	public File getuserData(File user) {
		return userData;
	}
	private UUID id;
	private String name;
	private File f = new File(userData, File.separator + name +".yml");
	public File getUserFile(File g,UUID id,String name) {
		return f;
	}
	public UUID getPlayerId(UUID id1) {
		return id;
	}
	
	//}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		id = e.getPlayer().getUniqueId();
		name = e.getPlayer().getName();
		File f = new File(userData, File.separator + name + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		
		
		if(!f.exists()) {
			try {
				playerData.createSection("UUID");
				String empty = "none";
				playerData.set("UUID".toString(), id.toString());
				playerData.set("Class",empty.toString());
				playerData.set("Stats", empty.toString());
				playerData.set("Nature", "Neutral");
				playerData.createSection("Traits.Honesty");
				playerData.createSection("Traits.Altriusm");
				playerData.createSection("Traits.Ambition");
				playerData.createSection("Traits.Patience");
				playerData.createSection("Traits.Scholarship");
				playerData.createSection("Traits.Strategy");
				playerData.createSection("Traits.Curiosity");
				playerData.createSection("Traits.Romance");
				playerData.createSection("Traits.Empathy");
				playerData.createSection("Traits.Charisma");
				playerData.createSection("Traits.Courage");
				playerData.createSection("Traits.Adaptability");
				playerData.createSection("Reputation.NPCs");
				playerData.createSection("Reputation.Areas");
				playerData.createSection("Camps");
				playerData.createSection("Quests");
				playerData.createSection("Objectives");
				playerData.createSection("Objectives.Values");
				playerData.createSection("Objectives.Values.SlowFall");
				playerData.set("Objectives.Waiting", true);
				
				System.out.println(playerData.getString("Class"));
				playerData.save(f);
				if(!playerData.isSet("Classes.Stats.Health")) {
					System.out.println("Hello Gannon1");
					PlayerStats ps = new PlayerStats();
					ps.setStats(e.getPlayer(), e.getPlayer().getLevel());	
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
}
