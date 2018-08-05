package raalekh.rpgjourneyplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerTeleportTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			String world = player.getWorld().getName();
			Location location = player.getLocation();
			double x1 = location.getX();
			double y1 = location.getY();
			double z1 = location.getZ();
			float pitch1 = location.getPitch();
			float yaw1 = location.getYaw();
			if (world.equals("I love you")) {
				player.sendMessage("You are in world " + world);
				Location underplayer = new Location(Bukkit.getWorld("Raalekh2"), location.getBlockX(),location.getBlockY()-1,location.getBlockZ());
				Location bottomblock = new Location(Bukkit.getWorld("Raalekh2"), location.getBlockX(),location.getBlockY(),location.getBlockZ());
				Location topblock = new Location(Bukkit.getWorld("Raalekh2"), location.getBlockX(),location.getBlockY()+1,location.getBlockZ());
				if(underplayer.getBlock().isEmpty()) {
					player.sendMessage("There's a glitch in the phasing process!");
				} else if(!bottomblock.getBlock().isEmpty()){
					player.sendMessage("There's a glitch in the phasing process!");
				} else if(!topblock.getBlock().isEmpty()){
					player.sendMessage("There's a glitch in the phasing process!");
				} else {
					player.teleport(new Location(Bukkit.getWorld("Raalekh2"),x1,y1,z1,yaw1,pitch1));
				}
			}
				
			else if (world.equals("Raalekh2")) {
				player.sendMessage("You are in world " + world);
				Location underplayer = new Location(Bukkit.getWorld("I love you"), location.getBlockX(),location.getBlockY()-1,location.getBlockZ());
				Location bottomblock = new Location(Bukkit.getWorld("I love you"), location.getBlockX(),location.getBlockY(),location.getBlockZ());
				Location topblock = new Location(Bukkit.getWorld("I love you"), location.getBlockX(),location.getBlockY()+1,location.getBlockZ());
				if(underplayer.getBlock().isEmpty()) {
					player.sendMessage("There's a glitch in the phasing process!");
				} else if(!bottomblock.getBlock().isEmpty()){
					player.sendMessage("There's a glitch in the phasing process!");
				} else if(!topblock.getBlock().isEmpty()){
					player.sendMessage("There's a glitch in the phasing process!");
				} else {
					player.teleport(new Location(Bukkit.getWorld("I love you"),x1,y1,z1,yaw1,pitch1));
				}
				
			}
			
		}
		return true;
	}

}
