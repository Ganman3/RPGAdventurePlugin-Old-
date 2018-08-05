package raalekh.rpgjourneyplugin;

//import java.util.Map;
//import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

//import net.minecraft.server.v1_12_R1.GenericAttributes;

public class RestoreHunger extends BukkitRunnable {

	RPGAdventurePlugin plugin;
	public RestoreHunger(RPGAdventurePlugin plugin) {
		this.plugin= plugin;
	}

	@Override
	public void run() {
		for(Player player1: Bukkit.getOnlinePlayers()) {
			Player player = player1.getPlayer();
			//UUID playerid = player.getUniqueId();
			/*
			Map<UUID,Double> getphealthmap = PlayerStats.getphmap();
			Map<UUID,Double> getpattackmap = PlayerStats.getpamap();
			Map<UUID,Double> getpdefensemap = PlayerStats.getpdmap();
			Double getplayerhealthfrommap = getphealthmap.get(playerid);
			Double getplayerdefensefrommap = getpdefensemap.get(playerid);
			Double getplayerattackfrommap = getpattackmap.get(playerid);*/
			CraftPlayer cp = (CraftPlayer) player;
			int hunger = cp.getFoodLevel();
			/*if(getplayerhealthfrommap != null) {
				cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(getplayerhealthfrommap);
			}
			if(getplayerdefensefrommap != null) {
				cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(getplayerdefensefrommap);
			}
			if(getplayerattackfrommap != null) {
				cp.getHandle().getAttributeInstance(GenericAttributes.maxHealth).setValue(getplayerattackfrommap);
			}*/
			
			if(!player.isSprinting()) {
				String worldname = player.getWorld().getName();
				if(worldname.equals("Raalekh2"));
				if(player.getGameMode().equals(GameMode.ADVENTURE)) {
					this.setCPlayerFoodLevel(cp, hunger);
				}
			}
	

	}
		
}
	public void setCPlayerFoodLevel(CraftPlayer cp,int hunger) {
		
		Player player = (Player) cp;
		String worldname = player.getWorld().getName();
		if(worldname.equals("Raalekh2")) {
			if(player.getGameMode().equals(GameMode.ADVENTURE)) {
				if(hunger>20) {
					hunger = 20;
				}
				
				if(!cp.isSprinting()) {
				if(hunger <= 19) {
				
				cp.setFoodLevel(hunger += 2);
				}
				}
			}
		}
	}

}
