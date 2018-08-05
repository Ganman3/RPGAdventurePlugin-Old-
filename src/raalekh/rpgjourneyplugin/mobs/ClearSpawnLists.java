package raalekh.rpgjourneyplugin.mobs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ClearSpawnLists implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if(sender instanceof Player) {
			SimpleMobSpawnTest.getpond1list().clear();
			SimpleMobSpawnTest.getcamp1list().clear();
			Player player = (Player) sender;
			player.sendMessage("Lists cleared!");
				
			}
			
		
	return true;
	}
	

	
}
