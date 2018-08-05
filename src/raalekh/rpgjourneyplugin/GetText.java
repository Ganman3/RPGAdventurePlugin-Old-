//A bloated test method- if I have a new feature I want to test, I temporarily attach it to this command 
//before I implement it, just to iron it out.
package raalekh.rpgjourneyplugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

//import java.io.File;
//import java.util.UUID;

import org.bukkit.Bukkit;

//import java.util.UUID;

//import java.util.ArrayList;
//import java.util.List;

//import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
//import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.event.entity.EntityDamageEvent;
//import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
//import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
//import org.bukkit.scheduler.BukkitTask;
//import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class GetText implements CommandExecutor,Listener {
	private HashMap<UUID,Boolean> playerslowFall = new HashMap<UUID,Boolean>();
	public UUID id;
	public Boolean getslowFall = getPlayerslowFall().get(id);
	private String name;
	//private final RPGAdventurePlugin rpg;
	public RPGAdventurePlugin getRPGPlugin(RPGAdventurePlugin rpg) {
		return this.rpg;
	}
	private RPGAdventurePlugin rpg = RPGAdventurePlugin.getPlugin(RPGAdventurePlugin.class);
	public GetText(RPGAdventurePlugin rpg) {
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
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			name = player.getName();
			File f = new File(userData, File.separator + name + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			
			UUID id = player.getUniqueId();
			getPlayerslowFall().put(id, false);
			//Block d = player.getLocation().getBlock();
			Location l = player.getLocation();
			double x1 = l.getX();
			double y1 = l.getY();
			double z1 = l.getZ();
			World w = player.getWorld();
			//String name = player.getName();
			
			/*File userData = new File(rpg.getDataFolder(), File.separator + "Players");
			File f = new File(userData, File.separator + name +".yml");
			if(f.exists()) {
				System.out.println("Hello18");
			}
			else {
				System.out.println("Goodbye22");
			}*/
			//File f;
			//List<Block> blockList = new ArrayList<Block>();
			//UUID id = player.getUniqueId();
			new BukkitRunnable(){
				int count = 0;
				@Override
				public void run() {
					
					if(count<16) {
						w.getBlockAt((int)x1,(int)y1+count,(int)z1).setType(Material.GRAVEL);
						count++;
					}
					
					
				}
				
			}.runTaskTimer(this.rpg, 0, 2);
			
			new BukkitRunnable() {

				RPGAdventurePlugin rpg = getRPGPlugin(this.rpg);
				int count = 0;
				@Override
				public void run() {
					new BukkitRunnable() {

						@Override
						public void run() {
							
							if(count<16) {
							player.teleport(new Location(w,(int)x1+0.5,(int)y1+1+count,(int)z1+0.5));
							count++;
							}
							
						}
						
					}.runTaskTimer(this.rpg, 0, 2);
					
				}
				
			}.runTaskLater(this.rpg, 1);
			
			/*Bukkit.getScheduler().scheduleSyncDelayedTask(this.rpg, new Runnable() {	
				public void run() {
					for(int h = 1; h < 15; h++) {
						player.teleport(new Location(w,x1,y1+count,z1));
						
						w.getBlockAt((int)x1,(int)y1+h,(int)z1).setType(Material.GRAVEL);
				
				
				}

				}
			}, j + 3);	*/	
								
								//Block block = w.getBlockAt(int)x1,(int)y1+h,(int)z1);
								//blockList.put(block);
					
				
							
				
				
						
						
			
			
			ItemStack diamond = new ItemStack(Material.DIAMOND);
			
			ItemStack bricks = new ItemStack(Material.BRICK, 20);
			player.getInventory().addItem(bricks,diamond);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.rpg, new Runnable() {
				
			    public void run() {
			    	
			    	player.setVelocity(new Vector(0,15,0));  
			    	System.out.println(getPlayerslowFall().get(id));
			    	getPlayerslowFall().put(id, true);
			    	try {
			    	playerData.set("Objectives.Values.SlowFall",true);
			    	playerData.save(f);
			    	} catch (IOException ex) {
			    	ex.printStackTrace();
			    	}
			    	player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,300000,253));
			    	player.setFallDistance(-1000000f);
			    }
			    
			}, 31);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.rpg, new Runnable() {
			    public void run() {
			    	if((int)player.getVelocity().getY() == 0 && playerData.getBoolean("Objectives.Values.Slowfall") == true) {
			    		getPlayerslowFall().put(id, false);
			    		try {
			    		playerData.set("Objectives.Values.SlowFall",false);
			    		playerData.save(f);
			    		} catch (IOException ex) {
			    			ex.printStackTrace();
			    		}
			    		player.removePotionEffect(PotionEffectType.LEVITATION);
			    	}
			    	else {
			    		System.out.println("Filler text");
			    		
			    	}
			    }
			},33);
			
			
			//if(player.getVelocity().getY() > 0) {
				System.out.println("Hello 1");
			//}
			//while(player.getVelocity().getY() < 0) {
				System.out.println("Hello 2");
			//}
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.rpg, new Runnable() {
				public void run() {
			for(int i=0;i<17;i++) {
			w.getBlockAt((int)x1,(int)y1+i,(int)z1).setType(Material.AIR);
			
		    }
			
			}
		}, 31);
			
			
		
		
		
	}

		return true;

}


	public HashMap<UUID,Boolean> getPlayerslowFall() {
		return playerslowFall;
	}


	public void setPlayerslowFall(HashMap<UUID,Boolean> playerslowFall) {
		this.playerslowFall = playerslowFall;
	}
	
	
}
