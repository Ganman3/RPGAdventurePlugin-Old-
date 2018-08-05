package raalekh.rpgjourneyplugin.servercheck;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
//import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import raalekh.rpgjourneyplugin.RPGAdventurePlugin;

public class WeatherCheck extends BukkitRunnable {
	/*NOTE: If you want to access this in another class, you're going to need to make getter and setter methods for this 
	 * class.
	 */
	private RPGAdventurePlugin rpg;
	public RPGAdventurePlugin getRPGAdventurePlugin(RPGAdventurePlugin rpg) {
		return rpg;
	}
	public RPGAdventurePlugin getRpg() {
		return rpg;
	}
	public void setRpg(RPGAdventurePlugin rpg) {
		this.rpg = rpg;
	}
//Constructor to update weather check
public WeatherCheck(RPGAdventurePlugin rpg) {
this.setRpg(rpg);
}
	@Override
	public void run() {
		int count = 0;
		if(count < 1) {
			//Iterate over and target one online player; check if player's in adventure mode, and double-check count is less than one, and check that they're in adventure world
		for(Player player:Bukkit.getOnlinePlayers()) if(player.getGameMode() == (GameMode.ADVENTURE) && count <1 && player.getWorld().getName().equals("Raalekh2")) {
			if(player.getGameMode() == (GameMode.ADVENTURE)) {
				//Stops player check- ensures only one person is targeted at a time
				count++;
				if(!(player.getPlayerWeather() == null)) {
				//String world = player.getWorld().getName();
				String weather = player.getPlayerWeather().toString();
				System.out.println(weather);
		
	}
			}

}
		}
	}
}
