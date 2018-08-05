package raalekh.rpgjourneyplugin.locales.boggeun;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.entity.EntityType;


//import com.sk89q.worldedit.world.World;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.goals.MoveToGoal;
import net.citizensnpcs.api.npc.NPC;

//import net.citizensnpcs.api.trait.Trait;

public class Grieu {
	
	Server s;
	
	long spawntime = Bukkit.getWorld("Raalekh2").getTime();
		public void spawn() {
			
			Location l;
			CraftWorld w = (CraftWorld) Bukkit.getWorld("Raalekh2");
					if(CitizensAPI.getNPCRegistry().getById(1) == null) {
						if(spawntime < 2000 || spawntime >= 14000) {
							l = null;
						} else if(spawntime < 4000 && spawntime >= 2000) {
							l = new Location(w,180,67,179);
							materialize(l);
							System.out.println("Hiza hiza");
						} else if(spawntime >= 4000 && spawntime < 5000) {
							l = new Location(w,130,74,156);
							materialize(l);
						} else if(spawntime < 6000 && spawntime >= 5000) {
							l = new Location(w,176,75,175);
							materialize(l);
						} else if(spawntime < 14000 && spawntime >= 6000) {
							l = new Location(w,182,65,175);
							materialize(l);
						}
					}
				}
		public void materialize(Location l) {
			NPC grieu = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 1, "Grieu");
			System.out.println("Grieu's id is " + grieu.getId());
			grieu.spawn(l);
		}
		
		public void move() {
			CraftWorld w = (CraftWorld) Bukkit.getWorld("Raalekh2");
			NPC grieu = CitizensAPI.getNPCRegistry().getById(1);
			Location l = grieu.getStoredLocation();
			
			if(spawntime < 2000 && spawntime >= 14000) {
				Location m = new Location(w,182,65,175);
				MoveToGoal mt = new MoveToGoal(grieu,m);
				if(l != m) {
					mt.shouldExecute();
				}
				else {
					return;
				}
			} else if(spawntime < 4000 && spawntime >= 2000) {
				//Location m = new Location(w,180,67,179);
				/*if(grieu.isSpawned() == false) {
					grieu.spawn(m);
					System.out.println("Hello");
				}
				else {
					return;
				}*/
			} else if(spawntime >= 4000 && spawntime < 5000) {
				Location m = new Location(w,130,74,156);
				MoveToGoal mt = new MoveToGoal(grieu,m);
				if(l != m) {
					mt.shouldExecute();
					System.out.println("This worked");
				}
				else {
					System.out.println("This didn't worked");
					return;
					
				}
			} else if(spawntime < 6000 && spawntime >= 5000) {
				Location m = new Location(w,176,65,175);
				MoveToGoal mt = new MoveToGoal(grieu,m);
				if(l != m) {
					mt.shouldExecute();
				}
				else {
					return;
				}
			} else if(spawntime < 14000 && spawntime >= 6000) {
				
				if(grieu.isSpawned()) {
					
					grieu.despawn();
				}
				else {
					return;
				}
			}{
				
			}
		}
	
		// TODO Auto-generated constructor stub
}
	

