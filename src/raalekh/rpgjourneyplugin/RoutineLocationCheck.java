package raalekh.rpgjourneyplugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
/*import org.bukkit.material.Door;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;*/
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
//import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
//import org.bukkit.World;
import org.bukkit.entity.Player;

import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_12_R1.GenericAttributes;
//import net.citizensnpcs.api.CitizensAPI;
import raalekh.rpgjourneyplugin.locales.boggeun.BoggeunLoad;
//import raalekh.rpgjourneyplugin.locales.boggeun.Grieu;
import raalekh.rpgjourneyplugin.mobs.RoutineMobSpawn;

public class RoutineLocationCheck extends BukkitRunnable {
	
	RPGAdventurePlugin plugin;
	public RoutineLocationCheck(RPGAdventurePlugin plugin) {
		this.plugin=plugin;
	}
	
	private static Map<UUID,String> locationMap = new HashMap<UUID,String>();
	public static Map <UUID,String> getlocationMap() {
		return locationMap;
	}
	static ArrayList<Integer> al = new ArrayList<>();
	
	/*public static <M> void printMe(M[] x) {
		for(M g: x)
			System.out.printf("%s ", g);
		System.out.println();
	}*/
	@Override
	public void run() {
		for(Player player1: Bukkit.getOnlinePlayers()) {
			
			
			Player player = player1.getPlayer();
			CraftPlayer cp = (CraftPlayer) player;
			String world = player.getWorld().getName();
			World world1 = player.getWorld();
			if(world.equals("Raalekh2")) {
				if(player.getGameMode() == GameMode.ADVENTURE) {
					/*Location y = new Location(world1,186,65,167);
					Block b = y.getBlock();
					BlockState bs = b.getState();
					Door door = (Door)bs.getData();
					if(door.isOpen() == false) {
						door.setOpen(true);
						bs.update();
					}*/
					Location y = new Location(world1,186,65,167);
					y = new PathPoint();
					if(player.getLevel() == 0) {
						cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(6.0);
					}
					
					
					
				}
				else {
					cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(20.0);
				}
			}
			
			else {
				cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(20.0);
			}
			//CraftPlayer cp = (CraftPlayer) player;
			Location loc = player.getLocation();
			double x1 = loc.getX();
			double y1 = loc.getY();
			double z1 = loc.getZ();
			UUID id = player.getUniqueId();
			String worldname = player.getWorld().getName();
			//World world = player.getWorld();
			if(worldname.equals("Raalekh2")) {
				if(player.getGameMode()==GameMode.ADVENTURE) {
			if((x1 >= 139 && x1 < 319 && z1 >= 64 && z1 < 257 && y1 >= 62 && y1 < 114) || 
				(x1 >= 65 && x1 < 188 && z1 >= 117 && z1 < 174 && y1 >= 62 && y1 < 100) || 
				(x1 >= 125 && x1 < 234 && z1 >= 49 && z1 < 117 && y1 >= 62 && y1 < 100) ||
				(x1 >= 98 && x1 < 165 && z1 >= 159 && z1 < 225 && y1 >= 62 && y1 < 144)){
				BoggeunLoad bl = new BoggeunLoad();
				bl.loadNPCs();
				locationMap.put(id, "Boggeun");
				
			}
			else {
				
				RoutineMobSpawn rms = new RoutineMobSpawn(plugin);
				rms.run();
				locationMap.put(id, "Wilderness");
			}
			
		}
	}
			
}
}

}

