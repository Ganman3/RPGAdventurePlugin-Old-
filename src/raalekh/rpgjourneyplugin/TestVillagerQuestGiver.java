package raalekh.rpgjourneyplugin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
//import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import raalekh.rpgjourneyplugin.mobs.NPCGeneric;

//import net.minecraft.server.v1_12_R1.EntityHuman;
//import net.minecraft.server.v1_12_R1.EntityPlayer;
//import net.minecraft.server.v1_12_R1.*;
//import net.minecraft.server.v1_12_R1.EnumHand;

public class TestVillagerQuestGiver implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if (sender instanceof Player) {
		Player player = (Player) sender;
		Location loc = player.getLocation();
		NPCGeneric.spawn(loc);
		
		
		
	}
		return true;

}
	/*@Override
	public boolean a(EntityHuman entity, EnumHand enumhand) {
		((Player)CraftPlayer.getEntity(entity.getWorld().getServer(), (EntityPlayer)entity, entity)).sendMessage("Hello, I'm a generic NPC");
		super.a(entity, enumhand);
	}*/
}
