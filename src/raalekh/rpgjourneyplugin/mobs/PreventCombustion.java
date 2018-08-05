package raalekh.rpgjourneyplugin.mobs;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;

public class PreventCombustion implements Listener {
	@EventHandler
	public void preventFire(EntityCombustEvent e) {
		if(e!= null) {
			Entity entity = e.getEntity();
			if(entity!=null) {
		String entityName = e.getEntity().getCustomName();
		if(entityName!= null && (entityName.equals("Pond Sprite") || entityName.equals("Camp Corpse"))) {
			e.setCancelled(true);
		}	
		}
	}
}
}