package raalekh.rpgjourneyplugin.classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
//import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import raalekh.rpgjourneyplugin.RPGAdventurePlugin;

public class TestClassGUI implements CommandExecutor, Listener {
	public Inventory classMenu = Bukkit.createInventory(null, 9, "Your class?");
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
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if(sender instanceof Player) {
		Player player = (Player) sender;
			
		if(player.getGameMode() == GameMode.ADVENTURE) {
		
		ItemStack junkeri = new ItemStack(Material.DIRT);
		ItemMeta juimeta = junkeri.getItemMeta();
		
		ItemStack stabi = new ItemStack(Material.WOOD_SWORD);
		ItemMeta stimeta = stabi.getItemMeta();
		
		ItemStack sneaki = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta snimeta = sneaki.getItemMeta();
		
		ItemStack diplomati = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta dmimeta = diplomati.getItemMeta();
		
		ItemStack spongei = new ItemStack(Material.SPONGE);
		ItemMeta spimeta = spongei.getItemMeta();
		
		ItemStack wizardi = new ItemStack(Material.ENCHANTMENT_TABLE);
		ItemMeta wzimeta = wizardi.getItemMeta();
		
		ItemStack energisti = new ItemStack(Material.EXP_BOTTLE);
		ItemMeta enemeta = energisti.getItemMeta();
		
		ItemStack playeri = new ItemStack(Material.AIR);
	
		
		enemeta.setDisplayName(ChatColor.WHITE + "Energist Class");
		enemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> enitemLore = new ArrayList<String>();
		enitemLore.add(ChatColor.GRAY + "Energy specialist. ");
		enitemLore.add(ChatColor.GRAY + "Takes or gives life.");
		enemeta.setLore(enitemLore);
		energisti.setItemMeta(enemeta);
		
		
		juimeta.setDisplayName(ChatColor.WHITE + "Junker Class");
		juimeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> juitemLore = new ArrayList<String>();
		juitemLore.add(ChatColor.GRAY + "Use 'creative' solutions ");
		juitemLore.add(ChatColor.GRAY + "to navigate and survive");
		juimeta.setLore(juitemLore);
		junkeri.setItemMeta(juimeta);
		
		stimeta.setDisplayName(ChatColor.WHITE + "Stab Class");
		stimeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> stitemLore = new ArrayList<String>();
		stitemLore.add(ChatColor.GRAY + "Kill them dead, without ");
		stitemLore.add(ChatColor.GRAY + "fail, 50% of the time.");
		stimeta.setLore(stitemLore);
		stabi.setItemMeta(stimeta);
		
		snimeta.setDisplayName(ChatColor.WHITE + "Sneak Class");
		snimeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> snitemLore = new ArrayList<String>();
		snitemLore.add(ChatColor.GRAY + "Hide, and leave bodies ");
		snitemLore.add(ChatColor.GRAY + "at your discretion");
		snimeta.setLore(snitemLore);
		sneaki.setItemMeta(snimeta);
		
		wzimeta.setDisplayName(ChatColor.WHITE + "Wizard Class");
		wzimeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> wzitemLore = new ArrayList<String>();
		wzitemLore.add(ChatColor.GRAY + "Just a regular, ");
		wzitemLore.add(ChatColor.GRAY + "everyday, normal mage");
		wzimeta.setLore(wzitemLore);
		wizardi.setItemMeta(wzimeta);
		
		dmimeta.setDisplayName(ChatColor.WHITE + "Diplomat Class");
		dmimeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> dmitemLore = new ArrayList<String>();
		dmitemLore.add(ChatColor.GRAY + "Win friends and ");
		dmitemLore.add(ChatColor.GRAY + "influence people.");
		dmimeta.setLore(dmitemLore);
		diplomati.setItemMeta(dmimeta);
		
		spimeta.setDisplayName(ChatColor.WHITE + "Sponge Class");
		spimeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> spitemLore = new ArrayList<String>();
		spitemLore.add(ChatColor.GRAY + "Absorbent, durable, and ");
		spitemLore.add(ChatColor.GRAY + "now available in yellow");
		spimeta.setLore(spitemLore);
		spongei.setItemMeta(spimeta);
		
		
		classMenu.setItem(0, junkeri);
		classMenu.setItem(1, stabi);
		classMenu.setItem(2, sneaki);
		classMenu.setItem(4, energisti);
		classMenu.setItem(3, diplomati);
		classMenu.setItem(5, spongei);
		classMenu.setItem(6, wizardi);
		classMenu.setItem(7, playeri);
		
		player.openInventory(classMenu);
		
		
		}	
	}
		return true;
		
	}
	@EventHandler
	public void ClickInventoryIcon(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		String name = player.getName();
		File f = new File(userData, File.separator + name + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		InventoryView view = e.getView();
		if(player.getGameMode().equals(GameMode.ADVENTURE) && view.getTopInventory().getName().equals("Your class?"));
		UUID playeruuid = player.getUniqueId();
		String hasEntry = ServerClass.classMap.get(playeruuid);
		

		int slot = e.getRawSlot();
		ItemStack getCurrentItem = e.getCurrentItem();
		//Inventory inventory = e.getInventory();
		//ItemStack clicked = e.getCurrentItem();
		if(getCurrentItem != null) {
			if (view.getTopInventory().getName().equals("Your class?")) {
				if(view.getTopInventory()!= null && slot < view.getTopInventory().getSize()) {
					if(getCurrentItem.getType() == Material.DIRT) {
						Stab.getclassMap().remove(playeruuid);
						Sneak.getclassMap().remove(playeruuid);
						Diplomat.getclassMap().remove(playeruuid);
						Wizard.getclassMap().remove(playeruuid);
						Sponge.getclassMap().remove(playeruuid);
						Energist.getclassMap().remove(playeruuid);
						Junker.getclassMap().put(playeruuid, "Junker");
						playerData.set("Class","Junker");
						UpdateStatsJunker usj = new UpdateStatsJunker();
						usj.setStats((Player)player, player.getLevel());
						System.out.println(player);
						System.out.println(player.getLevel());
						player.sendMessage("You are a junker!");
					}
					else if(getCurrentItem.getType() == Material.WOOD_SWORD) {
						Junker.getclassMap().remove(playeruuid);
						Sneak.getclassMap().remove(playeruuid);
						Diplomat.getclassMap().remove(playeruuid);
						Wizard.getclassMap().remove(playeruuid);
						Sponge.getclassMap().remove(playeruuid);
						Energist.getclassMap().remove(playeruuid);
						Stab.getclassMap().put(playeruuid, "Stab");
						playerData.set("Class","Stab");
						UpdateStatsStab usst = new UpdateStatsStab();
						usst.setStats((Player)player, player.getLevel());
						System.out.println(player);
						System.out.println(player.getLevel());
						player.sendMessage("You are a stab!");
						
					}
					else if(getCurrentItem.getType() == Material.LEATHER_BOOTS) {
						Junker.getclassMap().remove(playeruuid);
						Stab.getclassMap().remove(playeruuid);
						Diplomat.getclassMap().remove(playeruuid);
						Wizard.getclassMap().remove(playeruuid);
						Sponge.getclassMap().remove(playeruuid);
						Energist.getclassMap().remove(playeruuid);
						Sneak.getclassMap().put(playeruuid, "Sneak");
						playerData.set("Class","Sneak");
						UpdateStatsSneak ussn = new UpdateStatsSneak();
						ussn.setStats((Player)player, player.getLevel());
						System.out.println(player);
						System.out.println(player.getLevel());
						player.sendMessage("You are a sneak!");
					}
					else if(getCurrentItem.getType() == Material.BOOK_AND_QUILL) {
						Junker.getclassMap().remove(playeruuid);
						Stab.getclassMap().remove(playeruuid);
						Sneak.getclassMap().remove(playeruuid);
						Wizard.getclassMap().remove(playeruuid);
						Sponge.getclassMap().remove(playeruuid);
						Energist.getclassMap().remove(playeruuid);
						Diplomat.getclassMap().put(playeruuid, "Diplomat");
						playerData.set("Class","Diplomat");
					
						UpdateStatsDiplomat usd = new UpdateStatsDiplomat();
						usd.setStats(player,player.getLevel());
						usd.setStats((Player)player, player.getLevel());
						System.out.println(player);
						System.out.println(player.getLevel());
						player.sendMessage("You are a diplomat!");
					}
					else if(getCurrentItem.getType() == Material.ENCHANTMENT_TABLE) {
						Junker.getclassMap().remove(playeruuid);
						Stab.getclassMap().remove(playeruuid);
						Sneak.getclassMap().remove(playeruuid);
						Diplomat.getclassMap().remove(playeruuid);
						Sponge.getclassMap().remove(playeruuid);
						Energist.getclassMap().remove(playeruuid);
						Wizard.getclassMap().put(playeruuid, "Wizard");
						playerData.set("Class","Wizard");
						UpdateStatsWizard usw = new UpdateStatsWizard();
						usw.setStats((Player)player, player.getLevel());
						System.out.println(player);
						System.out.println(player.getLevel());
						player.sendMessage("You are a wizard!");
					}
					else if(getCurrentItem.getType() == Material.SPONGE) {
						Junker.getclassMap().remove(playeruuid);
						Stab.getclassMap().remove(playeruuid);
						Sneak.getclassMap().remove(playeruuid);
						Diplomat.getclassMap().remove(playeruuid);
						Wizard.getclassMap().remove(playeruuid);
						Energist.getclassMap().remove(playeruuid);
						Sponge.getclassMap().put(playeruuid, "Sponge");
						playerData.set("Class","Sponge");
						UpdateStatsSponge ussp = new UpdateStatsSponge();
						ussp.setStats((Player)player, player.getLevel());
						System.out.println(player);
						System.out.println(player.getLevel());
						player.sendMessage("You are a sponge!");
					}
					else if(getCurrentItem.getType() == Material.EXP_BOTTLE) {
						Junker.getclassMap().remove(playeruuid);
						Stab.getclassMap().remove(playeruuid);
						Sneak.getclassMap().remove(playeruuid);
						Diplomat.getclassMap().remove(playeruuid);
						Wizard.getclassMap().remove(playeruuid);
						Sponge.getclassMap().remove(playeruuid);
						Energist.getclassMap().put(playeruuid, "Energist");
						UpdateStatsEnergist use = new UpdateStatsEnergist();
						use.setStats((Player)player, player.getLevel());
						playerData.set("Class","Energist");
						System.out.println(player);
						System.out.println(player.getLevel());
						player.sendMessage("You are an energist!");
					}
					else if(getCurrentItem.getType() == Material.AIR) {
						Stab.getclassMap().remove(playeruuid);
						Sneak.getclassMap().remove(playeruuid);
						Diplomat.getclassMap().remove(playeruuid);
						Wizard.getclassMap().remove(playeruuid);
						Sponge.getclassMap().remove(playeruuid);
						Energist.getclassMap().remove(playeruuid);
						Junker.getclassMap().remove(playeruuid);
						player.sendMessage("You have chosen the player class.");
						player.sendMessage("Are you sure?");
						playerData.set("Class","none");
						try {
							playerData.save(f);
						} catch (IOException exc) {
							exc.printStackTrace();
						}
				
			}
				
			
		}
				if(hasEntry != null) {
					
					if(hasEntry.equals("Junker")) {
						System.out.println("Testhello");
					}
					else if(hasEntry.equals("Stab")) {
						System.out.println("Testgoodbye");
					}
					else if(hasEntry.equals("Sneak")) {
						System.out.println("Testadidas");
					}
					else if(hasEntry.equals("Diplomat")) {
						System.out.println("Hanging chad");
					}
					else if(hasEntry.equals("Wizard")) {
						System.out.println("Zabbityzook");
					}
					else if(hasEntry.equals("Sponge")) {
						System.out.println("Who lives in a pineapple under the sea?");
					}
					}
				player.closeInventory();	
		}
			
		}
			
		
	}
	
	@EventHandler
	public void StopClick(InventoryClickEvent ev) {
		if(ev.getClickedInventory()!=null && (ev.getClickedInventory().getName().equals("Your class?"))) {
			if(ev.getAction().equals(InventoryAction.CLONE_STACK)||ev.getAction().equals(InventoryAction.COLLECT_TO_CURSOR)||
			ev.getAction().equals(InventoryAction.HOTBAR_MOVE_AND_READD) || ev.getAction().equals(InventoryAction.HOTBAR_SWAP)
			||ev.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
				Player player = (Player) ev.getWhoClicked();
				
		
		if(player.getGameMode() == GameMode.ADVENTURE) {
			
			ev.setCancelled(true);
	}
			}
		}
	}
	
	/*@EventHandler
	public void StopDrag(InventoryDragEvent eve) {
		if(eve.getInventory().getName().equals("Your class?")) {
			eve.setCancelled(true);
			
		}

}*/
}

