package raalekh.rpgjourneyplugin.classes;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.GenericAttributes;
import raalekh.rpgjourneyplugin.RPGAdventurePlugin;

public class UpdateStatsSneak {
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
	public void setStats (Player player, int currentLevel) {
		String name = player.getName();
		File f = new File(userData, File.separator + name + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		if(currentLevel <= 20) {
			CraftPlayer cp = (CraftPlayer) player;
			cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(4 + currentLevel * 0.4);
			double health = cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).getValue();
			double attack = 2 + currentLevel * 0.8;
			double defense = 3 + currentLevel * 0.8;
			double attunement = 1 + currentLevel * 0.8;
			double resistance = 2 + currentLevel * 0.8;
			double speed = 5 + currentLevel * 0.8;
			double diplomacy = 4 + currentLevel * 0.8;
			double dodge = 5 + currentLevel * 0.8;
			double absorption = 1 + currentLevel * 0.8;
			double luck = 3 + currentLevel * 0.8;
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
				playerData.set("Class","Sneak");
				playerData.set("Nature", "Neutral");
				System.out.println(playerData.getDouble("Stats.Attack"));
				System.out.println("Hello " + player.getName());
				playerData.save(f);
				playerData = YamlConfiguration.loadConfiguration(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(currentLevel > 20 && currentLevel <= 150) {
			CraftPlayer cp = (CraftPlayer) player;
			cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(10 + currentLevel * 0.4);
			double health = cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).getValue();
			double attack = 10 + currentLevel * 0.4;
			double defense = 15 + currentLevel * 0.4;
			double attunement = 5 + currentLevel * 0.4;
			double resistance = 10 + currentLevel * 0.4;
			double speed = 25 + currentLevel * 0.4;
			double diplomacy = 20 + currentLevel * 0.4;
			double dodge = 25 + currentLevel * 0.4;
			double absorption = 5 + currentLevel * 0.4;
			double luck = 15 + currentLevel * 0.4;
			
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
				playerData.set("Class","Sneak");
				playerData.set("Nature", "Neutral");
				System.out.println("Hello Gannon");
				playerData.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
