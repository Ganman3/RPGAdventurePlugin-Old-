package raalekh.rpgjourneyplugin;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class RaalekhLevel implements Listener {
	@EventHandler
	public void playerLevelInRaalekhAdv(PlayerLevelChangeEvent e) {
		Player player = e.getPlayer();
		if(player!= null) {
			if(player.getWorld().getName().equals("Raalekh2")) {
				if(player.getGameMode().equals(GameMode.ADVENTURE)) {
					
				}
			}
		}
	}
}
