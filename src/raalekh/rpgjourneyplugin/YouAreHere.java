package raalekh.rpgjourneyplugin;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class YouAreHere implements Listener {
	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
        
		String world = player.getWorld().getName();
		//player.sendMessage("You are in world "+ world);
		if(world.equals("I love you")) {
			player.sendTitle("Welcome, " + player.getName(), "You are in world survival!", 15, 35, 15);
		}
		else if(world.equals("Raalekh2")) {
			player.sendTitle("Welcome, " + player.getName(), "You are in Irolai!", 15, 35, 15);
		}
		
	}
}
