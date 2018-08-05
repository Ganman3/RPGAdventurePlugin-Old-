package raalekh.rpgjourneyplugin.testfeatures;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class SummonVillager implements CommandExecutor {
	public Location location;	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Location location = player.getLocation();
			location.add(1, 12, 1);
			Villager villager = player.getWorld().spawn(location, Villager.class);
			EntityEquipment equipment = villager.getEquipment();
			equipment.setChestplate(new ItemStack(Material.ELYTRA));
			villager.isGliding();
			villager.setCustomName("Harold");
			villager.setProfession(Profession.NITWIT);
			villager.setCollidable(false);
			villager.isLeashed();
			villager.setLeashHolder(player);
		}
		
		
		return true;
	}
	
	
	
}
