//THIS CLASS DOES NOT DO ANYTHING AT THE MOMENT. IT WILL BE USED TO PREVENT PLAYERS FROM USING CRAFTING TABLES.
package raalekh.rpgjourneyplugin.worldfit;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
//import org.bukkit.event.inventory.InventoryOpenEvent;
//import org.bukkit.event.block.Action;
//import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.event.player.PlayerInteractEvent;


//WHY DOESN'T THIS WORK? IT DOES NOTHING AT THE MOMENT. 
public class CancelItemUI implements Listener {
	@EventHandler
	public void CancelCraft(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getPlayer().getGameMode().equals(GameMode.ADVENTURE)) {
		if(e.getPlayer().getWorld().getName().equals("Raalekh2")) {
				if(e.getClickedBlock().getType().equals(Material.WORKBENCH)||
						e.getClickedBlock().getType().equals(Material.ANVIL)||
						e.getClickedBlock().getType().equals(Material.CHEST)||
						e.getClickedBlock().getType().equals(Material.BREWING_STAND)||
						e.getClickedBlock().getType().equals(Material.ENCHANTMENT_TABLE)||
						e.getClickedBlock().getType().equals(Material.BED)||
						e.getClickedBlock().getType().equals(Material.TRAPPED_CHEST)||
						e.getClickedBlock().getType().equals(Material.DISPENSER) ||
						e.getClickedBlock().getType().equals(Material.BED_BLOCK) ||
						e.getClickedBlock().getType().equals(Material.BREWING_STAND_ITEM) ||
						e.getClickedBlock().getType().equals(Material.FURNACE) ||
						e.getClickedBlock().getType().equals(Material.TRAP_DOOR) ||
						e.getClickedBlock().getType().equals(Material.HOPPER) ||
						e.getClickedBlock().getType().equals(Material.TNT)) {
					e.setCancelled(true);
				}
		}
			}
		}
	}
}
