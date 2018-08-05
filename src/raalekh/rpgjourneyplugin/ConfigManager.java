//========================THIS IS UNUSED- NOT SURE HOW TO PULL SEPARATED FILE NAME STRINGS INTO OTHER CLASSES ========================

//This is currently unused, as I just reference the files I need when I need to use them. 
//It will be used with refinement of the base code and greater knowledge.
//1-24-17
package raalekh.rpgjourneyplugin;

import java.io.File;
import java.io.IOException;
//import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import net.md_5.bungee.api.ChatColor;

public class ConfigManager {

	private RPGAdventurePlugin plugin = RPGAdventurePlugin.getPlugin(RPGAdventurePlugin.class);
	public ConfigManager cfm;
	private FileConfiguration playerData;
	public File playersFile;
	private File userData;
	public File getuserData(File userData) {
		return new File(plugin.getDataFolder(), File.separator + "Players");
	}
	private String name;
	private File f = new File(plugin.getDataFolder(), File.separator + name +".yml");
	//public File getUserFile(File g,UUID id,String name) {
		//return new File(getUserData(), File.separator + name + ".yml");
	//}
	//----------------------------------------------------------------------------------
	public void setup(String name) {
		if(!userData.exists()) {
			
			userData.mkdir();
			try {
				userData.createNewFile();
			} catch(IOException e) {
				
			}
		}
		
		f = new File(userData, File.separator + name + ".yml");
		if(!f.exists()) {
			try {
				f.createNewFile();
			}catch(IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Error creating config file 'players.yml'!");
			}
		}
		playerData = YamlConfiguration.loadConfiguration(f);
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Successfully loaded configuration file 'players.yml'!");
	}
	public FileConfiguration getPlayerData() {
		return playerData;
	}
	
	public void savePlayers() {
		try {
			playerData.save(f);
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Successfully saved configuration file 'players.yml'!");
		}catch(IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save to configuration file 'players.yml'!");
		}
	}
	
	public void reloadPlayers() {
			playerData = YamlConfiguration.loadConfiguration(f);
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Successfully reloaded configuration file 'players.yml'!");
		
	}
}
