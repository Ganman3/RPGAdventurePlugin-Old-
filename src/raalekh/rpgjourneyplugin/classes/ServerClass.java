package raalekh.rpgjourneyplugin.classes;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

//import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerClass {
	public static ConcurrentHashMap<UUID, String> classMap = new ConcurrentHashMap<>();
	public Player player;
	public static ConcurrentHashMap<UUID, String> getclassMap() {
		return classMap;
	}
	public UUID playerid;
	
	public ServerClass(UUID playerid, String classname) {
		this.playerid = playerid;
		
		//Double check this code. If anything, this could be your problem.
		int level = player.getLevel();
		if(level == 0) {
			
		}
	}
}
