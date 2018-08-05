package raalekh.rpgjourneyplugin.classes;

import java.io.File;
//import java.io.IOException;
import java.util.UUID;

//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.YamlConfiguration;
//import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
//import org.bukkit.entity.Player;

//import net.minecraft.server.v1_12_R1.GenericAttributes;
import raalekh.rpgjourneyplugin.RPGAdventurePlugin;

//import java.util.UUID;

public class Junker extends ServerClass {
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
	public Junker(UUID playerid, String classname) {
		super(playerid, classname);
		classMap.put(playerid,"Junker");
	}
	

	

	
}
