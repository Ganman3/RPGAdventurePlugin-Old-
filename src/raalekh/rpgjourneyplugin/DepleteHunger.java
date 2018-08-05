//At any given point, this code depletes player energy if they are running. It will have 
//more functionality later.
package raalekh.rpgjourneyplugin;

//import java.util.Map;
//import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

//import raalekh.rpgjourneyplugin.worldfit.Timer;

//import net.minecraft.server.v1_12_R1.GenericAttributes;

public class DepleteHunger extends BukkitRunnable {
	RPGAdventurePlugin plugin;
	public DepleteHunger(RPGAdventurePlugin plugin) {
		this.plugin= plugin;
	}
	@Override
	public void run() {
		for(Player player1: Bukkit.getOnlinePlayers()) {
			Player player = player1.getPlayer();
			CraftPlayer cp = (CraftPlayer) player;
			int hunger = cp.getFoodLevel();
			//UUID playerid = player.getUniqueId();
			/*Map<UUID,Double> getphealthmap = PlayerStats.getphmap();
			Map<UUID,Double> getpattackmap = PlayerStats.getpamap();
			Map<UUID,Double> getpdefensemap = PlayerStats.getpdmap();
			Double getplayerhealthfrommap = getphealthmap.get(playerid);
			Double getplayerdefensefrommap = getpdefensemap.get(playerid);
			Double getplayerattackfrommap = getpattackmap.get(playerid);
			if(getplayerhealthfrommap != null) {
				cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(getplayerhealthfrommap);
			}
			if(getplayerdefensefrommap != null) {
				cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(getplayerdefensefrommap);
			}
			if(getplayerattackfrommap != null) {
				cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(getplayerattackfrommap);
			}*/
			if(player.isSprinting()) {
				String worldname = player.getWorld().getName();
					if(worldname.equals("Raalekh2"));
					if(player.getGameMode().equals(GameMode.ADVENTURE)) {
						this.setLPlayerFoodLevel(cp, hunger);
				}
			}
		
	}
}
	public void setLPlayerFoodLevel(CraftPlayer cp,int hunger) {
		Player player = (Player) cp;
		String worldname = player.getWorld().getName();
		if(worldname.equals("Raalekh2")) {
			if(player.getGameMode().equals(GameMode.ADVENTURE)) {
				if(hunger>20) {
					hunger = 20;
				}
				if(cp.isSprinting()) {
				cp.setFoodLevel(hunger -= 2);
				}
	}
}
	}
}
