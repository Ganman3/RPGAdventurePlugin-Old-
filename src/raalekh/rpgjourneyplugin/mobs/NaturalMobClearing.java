package raalekh.rpgjourneyplugin.mobs;

import org.bukkit.entity.Entity;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;


public class NaturalMobClearing implements Listener{
	@EventHandler
	public void BlockSpawns(CreatureSpawnEvent e) {
		LivingEntity entity = e.getEntity();
		Entity entity1 = e.getEntity();
		if(entity.getWorld().getName().equals("Raalekh2") || entity1.getWorld().getName().equals("Raalekh2")) {
			System.out.println(e.getEntity().getType());
			System.out.println(e.getSpawnReason());
		if(e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CHUNK_GEN || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.DEFAULT || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.EGG || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.ENDER_PEARL || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.INFECTION || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.JOCKEY || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.LIGHTNING || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.DISPENSE_EGG || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.MOUNT || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SILVERFISH_BLOCK || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.VILLAGE_INVASION || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.OCELOT_BABY || e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.VILLAGE_DEFENSE) {
			entity.remove();
			entity1.remove();
			
			
			
		
		return;
		}
		}
		
		
		}
	
	@EventHandler
	public void BlockEntityXP(EntityDeathEvent ev) {
		String worldname = ev.getEntity().getWorld().getName();
		if(worldname.equals("Raalekh2")) {
		System.out.println(ev.getEntity().getName());
		if(ev.getEntity().getName().equals("Cow")|| ev.getEntity().getName().equals("Chicken") ||ev.getEntity().getName().equals("Pig")
				|| ev.getEntity().getName().equals("Squid")|| ev.getEntity().getName().equals("Zombie") 
				||ev.getEntity().getName().equals("Horse")||ev.getEntity().getName().equals("Villager")
				||ev.getEntity().getName().equals("Wolf")||ev.getEntity().getName().equals("Ocelot")
				||ev.getEntity().getName().equals("Polar Bear")||ev.getEntity().getName().equals("Blaze")||
				ev.getEntity().getName().equals("Sheep")||ev.getEntity().getName().equals("Snow Golem")
				||ev.getEntity().getName().equals("Iron Golem")||ev.getEntity().getName().equals("Rabbit")) {
			ev.getDrops().clear();
			ev.setDroppedExp(0);
		}
	}
}
}