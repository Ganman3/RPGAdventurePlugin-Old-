package raalekh.rpgjourneyplugin.mobs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SplittableRandom;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
//import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
//import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
//import org.bukkit.event.inventory.InventoryType;
//import org.bukkit.event.entity.EntityDeathEvent;
//import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import raalekh.rpgjourneyplugin.RoutineLocationCheck;
//import net.minecraft.server.v1_12_R1.GenericAttributes;
import raalekh.rpgjourneyplugin.RPGAdventurePlugin;

public class RoutineMobSpawn extends BukkitRunnable implements Listener {

	
	RPGAdventurePlugin plugin;
	public RoutineMobSpawn(RPGAdventurePlugin plugin) {
		this.plugin=plugin;
	}
	private static ArrayList<Entity> hostilemobList;
	public ArrayList<Entity> gethostilemoblist() {
		return hostilemobList;
	}
	
	@Override
	
	public void run() {
		
			for(Player player1: Bukkit.getOnlinePlayers()) {
		
					Player player = player1.getPlayer();
					String world = player.getWorld().getName();
				
					/*if(player==null) {
						continue;
					}*/
					UUID playerid = player.getUniqueId();
					Map<UUID,String> getplayerlmap = RoutineLocationCheck.getlocationMap();
					String getstringplayerlmap = getplayerlmap.get(playerid);
					if(getstringplayerlmap != null && getstringplayerlmap.equals("Wilderness")) {
					
					if(world.equals("Raalekh2")) {
						if(player.getGameMode().equals(GameMode.ADVENTURE)) {
							//player.sendMessage("Hello me!");
							List<Entity> mobList = player.getNearbyEntities(32, 32, 16);
							ArrayList<Entity> hostileMobList = new ArrayList<Entity>();
							Location loc = player.getLocation();
							double x1 = loc.getX();
							double y1 = loc.getY();
							double z1 = loc.getZ();
							
							
							//Calculates percentage chance of mob spawn 
							SplittableRandom random = new SplittableRandom();
							double spawnChance = random.nextDouble(1, 100);
							
							//Creates coordinate range based on player location for mob spawn
							double rangex1 = x1 + 8;
							double rangex2 = x1 - 8;
							double rangez1 = z1 + 8;
							double rangez2 = z1 - 8;
							
							//Creates random double in player coordinate range
							
							for (Entity entity: mobList) {
								if(entity.getType().equals(EntityType.ZOMBIE) || entity.getType().equals(EntityType.SKELETON) || entity.getType().equals(EntityType.WITCH) || entity.getType().equals(EntityType.ENDERMAN) || entity.getType().equals(EntityType.SILVERFISH) || entity.getType().equals(EntityType.GUARDIAN) || entity.getType().equals(EntityType.SPIDER)) {
									hostileMobList.add(entity);
									//System.out.println(hostilemobList);	
								}
								/*if(hostileMobCount >= 3) {
									player.sendMessage("x1 is " + x1 + " y1 is " + y1 + " z1 is " + z1);
								}*/
								
							}
							int hostilemobCount = 0;
							if(!hostileMobList.isEmpty()) {
							hostilemobCount = hostileMobList.size();
							}
							System.out.print(hostilemobCount);

							
							SplittableRandom randomCoord = new SplittableRandom();
							double randomX = randomCoord.nextDouble(rangex2, rangex1);
							double randomZ = randomCoord.nextDouble(rangez2, rangez1);
							if(hostilemobCount <= 2) {
								if(spawnChance <= 22) {
									//I know that all of this code can be condensed. I need to look at it later.
								Location checkSpawnCoordLower = new Location(player.getWorld(),randomX, y1, randomZ);
								Location checkSpawnCoordUpper = new Location(player.getWorld(),randomX, y1 + 1, randomZ);
								Location checkSpawnCoordUpper1 = new Location(player.getWorld(),randomX, y1 + 2, randomZ);
								Location checkSpawnCoordUpper2 = new Location(player.getWorld(),randomX, y1 + 3, randomZ);
								Location checkSpawnCoordUpper3 = new Location(player.getWorld(),randomX, y1 + 4, randomZ);
								Location checkSpawnCoordUpper4 = new Location(player.getWorld(),randomX, y1 + 5, randomZ);
								Location checkSpawnCoordUpper5 = new Location(player.getWorld(),randomX, y1 + 6, randomZ);
								Location checkSpawnCoordUnder = new Location(player.getWorld(),randomX, y1 - 1, randomZ);
								Location checkSpawnCoordUnder1 = new Location(player.getWorld(),randomX, y1 - 2, randomZ);
								Location checkSpawnCoordUnder2 = new Location(player.getWorld(),randomX, y1 - 3, randomZ);
								Location checkSpawnCoordUnder3 = new Location(player.getWorld(),randomX, y1 - 4, randomZ);
								Location checkSpawnCoordUnder4 = new Location(player.getWorld(),randomX, y1 - 5, randomZ);
								Location checkSpawnCoordUnder5 = new Location(player.getWorld(),randomX, y1 - 6, randomZ);

								if(checkSpawnCoordLower.getBlock().isEmpty()) {
									if(checkSpawnCoordUpper.getBlock().isEmpty()) {
										if(checkSpawnCoordUnder.getBlock().isEmpty()) {
											if(checkSpawnCoordUnder1.getBlock().isEmpty()) {
												if(checkSpawnCoordUnder2.getBlock().isEmpty()) {
													if(checkSpawnCoordUnder3.getBlock().isEmpty()) {
														if(checkSpawnCoordUnder4.getBlock().isEmpty()) {
															if(checkSpawnCoordUnder5.getBlock().isEmpty()) {
																
															}
															else {
																PondSprite.spawn(checkSpawnCoordUnder4).setCustomName("Pond Sprite");
															}
														}
														else {
															PondSprite.spawn(checkSpawnCoordUnder3).setCustomName("Pond Sprite");
														}
													}
													else {
														PondSprite.spawn(checkSpawnCoordUnder2).setCustomName("Pond Sprite");
													}
												}
												else {
													PondSprite.spawn(checkSpawnCoordUnder1).setCustomName("Pond Sprite");
												}
											}
											else {
												PondSprite.spawn(checkSpawnCoordUnder).setCustomName("Pond Sprite");
											}
										}
										else {
											PondSprite.spawn(checkSpawnCoordLower).setCustomName("Pond Sprite");
										}	
									}
											
								}
								else if(!checkSpawnCoordLower.getBlock().isEmpty()){
									if(checkSpawnCoordUpper.getBlock().isEmpty()) {
										if(checkSpawnCoordUpper1.getBlock().isEmpty()) {
											PondSprite.spawn(checkSpawnCoordUpper).setCustomName("Pond Sprite");
										}
									}
										else if(checkSpawnCoordUpper1.getBlock().isEmpty()) {
											if(checkSpawnCoordUpper2.getBlock().isEmpty()) {
												PondSprite.spawn(checkSpawnCoordUpper1).setCustomName("Pond Sprite");
											}
										}
										else if(checkSpawnCoordUpper2.getBlock().isEmpty()) {
											if(checkSpawnCoordUpper3.getBlock().isEmpty()) {
												PondSprite.spawn(checkSpawnCoordUpper2).setCustomName("Pond Sprite");
											}
										}
										else if(checkSpawnCoordUpper3.getBlock().isEmpty()) {
											if(checkSpawnCoordUpper4.getBlock().isEmpty()) {
												PondSprite.spawn(checkSpawnCoordUpper3).setCustomName("Pond Sprite");
											}
										}
										else if(checkSpawnCoordUpper4.getBlock().isEmpty()) {
											if(checkSpawnCoordUpper5.getBlock().isEmpty()) {
												PondSprite.spawn(checkSpawnCoordUpper4).setCustomName("Pond Sprite");
											}
										}
									
									}
									
								}
								
								
											
										
								
								//PondSprite.spawn(newSpawnCoord).setCustomName("Pond Sprite");
							}
							
							//player.sendMessage("Random number is: " + spawnChance);
							//System.out.println(Bukkit.getWorld(world).getTime());
							
							//player.sendMessage("Current mob count is " + hostileMobCount);
							}
					}
							}
						}
					}
			
				}
	
	


		// TODO Auto-generated method stub
		

		
	

