package raalekh.rpgjourneyplugin.locales.boggeun;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
//import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
//import net.citizensnpcs.api.trait.Trait;
//import net.citizensnpcs.api.npc.NPCRegistry;
import raalekh.rpgjourneyplugin.RoutineLocationCheck;

//import net.citizensnpcs.api.npc.NPCRegistry;

public class BoggeunLoad {
	Map<UUID,String> getplayerlmap = RoutineLocationCheck.getlocationMap();
	int count = 1;
	
	Location grieuLocation;
	Location bilouLocation;
	Location nilorLocation;
	Location kiirnLocation;
	Location gilalLocation;
	Location cionLocation;
	Location adinLocation;
	Location kainLocation;
	Location abinLocation;
	Location geunLocation;
	Location rilaLocation;
	Location kiiskLaneLocation;
	Location ralenLocation;
	Location filanLocation;
	Location farnauLocation;
	Location genneuLocation;
	Location faleuLocation;
	Location kienLocation;
	
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void unloadNPCS() {
			for(Player player1: Bukkit.getOnlinePlayers()) {
			
			Player player = player1.getPlayer();
			UUID playerid = player.getUniqueId();
			String getstringplayerlmap = getplayerlmap.get(playerid);
			//World world = player.getWorld();
			if(getstringplayerlmap.equals("Boggeun")) {
			NPC grieu = CitizensAPI.getNPCRegistry().getById(1);
			NPC bilou = CitizensAPI.getNPCRegistry().getById(2);
			NPC nilor = CitizensAPI.getNPCRegistry().getById(3);
			NPC kiirn = CitizensAPI.getNPCRegistry().getById(18);
			NPC gilal = CitizensAPI.getNPCRegistry().getById(4);
			NPC cion = CitizensAPI.getNPCRegistry().getById(5);
			NPC adin = CitizensAPI.getNPCRegistry().getById(6);
			NPC kain = CitizensAPI.getNPCRegistry().getById(7);
			NPC abin = CitizensAPI.getNPCRegistry().getById(8);
			NPC geun = CitizensAPI.getNPCRegistry().getById(9);
			NPC rila = CitizensAPI.getNPCRegistry().getById(10);
			NPC kiiskLane = CitizensAPI.getNPCRegistry().getById(11);
			NPC ralen = CitizensAPI.getNPCRegistry().getById(12);
			NPC filan = CitizensAPI.getNPCRegistry().getById(13);
			NPC farnau = CitizensAPI.getNPCRegistry().getById(14);
			NPC genneu = CitizensAPI.getNPCRegistry().getById(15);
			NPC faleu = CitizensAPI.getNPCRegistry().getById(16);
			NPC kien = CitizensAPI.getNPCRegistry().getById(17);
				grieu.destroy();
				bilou.destroy();
				nilor.destroy();
				kiirn.destroy();
				gilal.destroy();
				cion.destroy();
				adin.destroy();
				kain.destroy();
				abin.destroy();
				geun.destroy();
				rila.destroy();
				kiiskLane.destroy();
				ralen.destroy();
				filan.destroy();
				farnau.destroy();
				genneu.destroy();
				faleu.destroy();
				kien.destroy();
			}
		}
	}
	public void loadNPCs() {
		System.out.println(count);
		for(Player player1: Bukkit.getOnlinePlayers()) {
			
			Player player = player1.getPlayer();
			UUID playerid = player.getUniqueId();
			String getstringplayerlmap = getplayerlmap.get(playerid);
			World world = player.getWorld();
			grieuLocation = new Location(world,180,67,179);
			bilouLocation= new Location(world,199,64,85);
			nilorLocation= new Location(world,275, 63, 73);
			kiirnLocation= new Location(world,239, 72, 120);
			gilalLocation= new Location(world,251, 64, 117);
			cionLocation= new Location(world,260, 72, 109);
			adinLocation= new Location(world,110, 74, 164);
			kainLocation= new Location(world,135, 75, 122);
			abinLocation= new Location(world,111, 82, 128);
			geunLocation= new Location(world,136, 82, 105);
			rilaLocation= new Location(world,198, 69, 74);
			kiiskLaneLocation= new Location(world,198, 73, 69);
			ralenLocation= new Location(world,195,69,83);
			filanLocation= new Location(world,181,65,130);
			farnauLocation= new Location(world,211,69,214);
			genneuLocation= new Location(world,258,81,169);
			faleuLocation= new Location(world,233,72,168);
			kienLocation= new Location(world,216, 64, 129);
			Grieu grieu = new Grieu();
			if(CitizensAPI.getNPCRegistry().getById(1) != null) {
				grieu.move();
				System.out.println("Test your hat");
			}
			if(getstringplayerlmap != null && getstringplayerlmap.equals("Wilderness")) {
				System.out.println("Hello");
				
				grieu.spawn();
				
				/*NPC bilou = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 2, "Bilou");
				NPC nilor = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 3, "Nilor");
				NPC gilal = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 4, "Gilal");
				NPC cion = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 5, "Cion");
				NPC adin = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 6, "Adin");
				NPC kain = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.fromString("513e6e90-0180-4ec8-a0cc-e35dbbeda180"), 7, "Kain");
				NPC abin = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 8, "Abin");
				NPC geun = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 9, "Geun");
				NPC rila = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 10, "Rila");
				NPC kiiskLane = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 11, "Kiisk Lane");
				NPC ralen = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 12, "Ralen");
				NPC filan = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 13, "Filan");
				NPC farnau = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 14, "Farnau");
				NPC genneu = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 15, "Genneu");
				NPC faleu = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 16, "Faleu");
				NPC kien = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 17, "Kien");
				NPC kiirn = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, UUID.randomUUID(), 18, "Kiirn");*/
				/*kain.data().remove(NPC.PLAYER_SKIN_UUID_METADATA);
				kain.data().remove(NPC.PLAYER_SKIN_TEXTURE_PROPERTIES_METADATA);
				kain.data().remove(NPC.PLAYER_SKIN_TEXTURE_PROPERTIES_SIGN_METADATA);
				kain.data().remove("cached-skin-uuid-name");
				kain.data().remove("cached-skin-uuid");
				kain.data().remove(NPC.PLAYER_SKIN_UUID_METADATA);*/
				//kain.data().setPersistent(NPC.PLAYER_SKIN_UUID_METADATA, "Ganman3");
				//String sdata = kain.getUniqueId().toString();
				
				/*bilou.spawn(bilouLocation);
				nilor.spawn(nilorLocation);
				gilal.spawn(gilalLocation);
				cion.spawn(cionLocation);
				adin.spawn(adinLocation);
				kain.spawn(kainLocation);
				abin.spawn(abinLocation);
				geun.spawn(geunLocation);
				rila.spawn(rilaLocation);
				kiiskLane.spawn(kiiskLaneLocation);
				ralen.spawn(ralenLocation);
				filan.spawn(filanLocation);
				farnau.spawn(farnauLocation);
				genneu.spawn(genneuLocation);
				faleu.spawn(faleuLocation);
				kien.spawn(kienLocation);
				kiirn.spawn(kiirnLocation);*/
				//System.out.println(count);
				}
		}
	}
}
