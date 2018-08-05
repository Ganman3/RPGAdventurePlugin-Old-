//Triggers player call 

package raalekh.rpgjourneyplugin;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
//import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
//import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;



public class HoldCompass implements Listener {
	
	private RPGAdventurePlugin plugin = RPGAdventurePlugin.getPlugin(RPGAdventurePlugin.class);
	private File userData = new File(plugin.getDataFolder(), File.separator + "Players");
	public File getuserData(File user) {
		return userData;
	}
	
	private String name;
	private File f = new File(userData, File.separator + name +".yml");
	public File getUserFile(File g,UUID id,String name) {
		return f;
	}
	@EventHandler
	public void RightClickwComp(PlayerInteractEvent e) {
		String name = e.getPlayer().getName();
		File f = new File(userData, File.separator + name + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		//Make sure player is holding something
		Player player = e.getPlayer();
		//id=player.getUniqueId();
		final ItemStack item = player.getInventory().getItemInMainHand();
		if(item== null) {
			
			return;
			
		}
		else {
			
		if(player.getGameMode() == GameMode.ADVENTURE) {
			
			
		if(item != null) {
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR){
				
				ItemStack statsi = new ItemStack(Material.SIGN);
				ItemMeta statsmeta = statsi.getItemMeta();
				Inventory cmenu = Bukkit.createInventory(null,27,"World Menu");
				
				statsmeta.setDisplayName(ChatColor.WHITE + "Your stats");
				statsmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				ArrayList <String> statsLore = new ArrayList<String>();
				statsLore.add(ChatColor.GRAY + "Level: " + player.getLevel());
				statsLore.add(ChatColor.GRAY + "Health: "+ playerData.getInt("Stats.Health"));
				statsLore.add(ChatColor.GRAY + "Attack: "+ playerData.getInt("Stats.Attack"));
				statsLore.add(ChatColor.GRAY + "Defense: "+ playerData.getInt("Stats.Defense"));
				statsLore.add(ChatColor.GRAY + "Attunement: "+ playerData.getInt("Stats.Attunement"));
				statsLore.add(ChatColor.GRAY + "Resistance: "+ playerData.getInt("Stats.Resistance"));
				statsLore.add(ChatColor.GRAY + "Speed: "+ playerData.getInt("Stats.Speed"));
				statsmeta.setLore(statsLore);
				statsi.setItemMeta(statsmeta);
				cmenu.setItem(0,statsi);
				ItemStack ihandstack = player.getInventory().getItemInMainHand();
				Material ihand = player.getInventory().getItemInMainHand().getType();
				ItemMeta ihandmeta = ihandstack.getItemMeta();
				String ihandname = ihandmeta.getDisplayName();
				if(ihand == Material.WATCH && ihandmeta.hasLore() && ihandname.equals("Raalekh Compass")) {
					player.openInventory(cmenu);
					e.setCancelled(true);
					//System.out.println("This fired.");
					//player.setPlayerWeather(WeatherType.DOWNFALL);
					
			}
				
				}
				
				
			}
	}
	}
	}
	@EventHandler
	public void StopClick(InventoryClickEvent ev) {
		HumanEntity player = ev.getWhoClicked();
		if(player instanceof Player) {
			if(player.getGameMode() == GameMode.ADVENTURE) {
				if(ev.getClickedInventory().getName().equals("World Menu")) {
					ev.setCancelled(true);
			}
			
		}
		
		}
	}
}
