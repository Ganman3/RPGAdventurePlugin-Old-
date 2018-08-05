package raalekh.rpgjourneyplugin.mobs;



import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import raalekh.rpgjourneyplugin.classes.PlayerStats;



public class NoMobDropsTest implements Listener {
@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		if(e.getEntityType().equals(EntityType.ZOMBIE)) {
			if(e.getEntity().getName().equals("Pond Sprite")) {
				
			
			e.getDrops().clear();
			e.setDroppedExp(0);
			if(e.getEntity().getKiller() instanceof Player) {
				Player killer = (Player) e.getEntity().getKiller();
				PlayerStats.addExperience(killer, killer.getLevel(), 5, killer.getExp());
			}
			
			}
		}
		
		if(e.getEntityType().equals(EntityType.SKELETON)) {
			if(e.getEntity().getName().equals("Camp Corpse")) {
			e.getDrops().clear();
			e.setDroppedExp(0);
			if(e.getEntity().getKiller() instanceof Player) {
				Player killer = (Player) e.getEntity().getKiller();
				PlayerStats.addExperience(killer, killer.getLevel(), 5, killer.getExp());
			}
		}
				
			}
			
		
	}
}
	

