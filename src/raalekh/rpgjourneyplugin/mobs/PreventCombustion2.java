package raalekh.rpgjourneyplugin.mobs;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PreventCombustion2 implements Listener {
	@EventHandler
	public void preventFire(EntityDamageEvent e) {
		if(e!= null) {
			Entity entity= e.getEntity();
			String entityName = entity.getCustomName();
			if(entity!=null && entityName != null) {
				if(entityName.equals("Pond Sprite") && entityName.equals("Camp Corpse")) {
					if(e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
						e.setCancelled(true);
					}
				}
			}
		}
	}

}
