package raalekh.rpgjourneyplugin.mobs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import com.google.common.collect.Sets;

import net.minecraft.server.v1_12_R1.EntityHuman;
import net.minecraft.server.v1_12_R1.EntityInsentient;
import net.minecraft.server.v1_12_R1.EntityTypes;
import net.minecraft.server.v1_12_R1.EntityVillager;
import net.minecraft.server.v1_12_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_12_R1.PathfinderGoalInteract;
import net.minecraft.server.v1_12_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_12_R1.PathfinderGoalLookAtTradingPlayer;
import net.minecraft.server.v1_12_R1.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_12_R1.PathfinderGoalRandomStroll;
import net.minecraft.server.v1_12_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_12_R1.World;

public class NPCGeneric extends EntityVillager {
	public static void registerEntity(String name, int id, Class<? extends EntityInsentient> nmsClass, Class<? extends EntityInsentient> customClass){
        try {
     
            List<Map<?, ?>> dataMap = new ArrayList<Map<?, ?>>();
            for (Field f : EntityTypes.class.getDeclaredFields()){
                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())){
                    f.setAccessible(true);
                    dataMap.add((Map<?, ?>) f.get(null));
                }
            }
     
            if (dataMap.get(2).containsKey(id)){
                dataMap.get(0).remove(name);
                dataMap.get(2).remove(id);
            }
     
            Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, int.class);
            method.setAccessible(true);
            method.invoke(null, customClass, name, id);
     
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public NPCGeneric(Location loc) {
		
		super(((CraftWorld)loc.getWorld()).getHandle());
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		 try {
             Field bField = PathfinderGoalSelector.class.getDeclaredField("b");
             bField.setAccessible(true);
             Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
             cField.setAccessible(true);
    
             bField.set(goalSelector,  Sets.newLinkedHashSet());
             bField.set(targetSelector,  Sets.newLinkedHashSet());
             cField.set(goalSelector,  Sets.newLinkedHashSet());
             cField.set(targetSelector,  Sets.newLinkedHashSet());
     } catch (Exception e) {
             e.printStackTrace();
     }    

     this.goalSelector.a(0, new PathfinderGoalFloat(this));
     this.goalSelector.a(1, new PathfinderGoalLookAtTradingPlayer(this));
     this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 0.6D));
     this.goalSelector.a(9, new PathfinderGoalInteract(this, EntityHuman.class, 3.0F, 1.0F));
     this.goalSelector.a(9, new PathfinderGoalInteract(this, EntityVillager.class, 5.0F, 0.02F));
     this.goalSelector.a(9, new PathfinderGoalRandomStroll(this, 0.6D));
     this.goalSelector.a(10, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
}
	public static Villager spawn(Location loc) {
		World world = ((CraftWorld) loc.getWorld()).getHandle();
		final NPCGeneric npcGeneric = new NPCGeneric(loc);
		world.addEntity(npcGeneric,SpawnReason.CUSTOM);
		return (Villager) npcGeneric.getBukkitEntity();
	}
		
	}
