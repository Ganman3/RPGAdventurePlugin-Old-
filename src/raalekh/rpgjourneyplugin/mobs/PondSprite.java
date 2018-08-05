package raalekh.rpgjourneyplugin.mobs;

import net.minecraft.server.v1_12_R1.*;
import raalekh.rpgjourneyplugin.dependencies.NMSUtils.Attributes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
//import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.LivingEntity;
//import org.bukkit.entity.Player;
//import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
//import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
//import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.EntityEquipment;

import com.google.common.collect.Sets;

public class PondSprite extends EntityZombie { //implements IRangedEntity {
	private int level;
	public int getLevel() {
		return level;
	}
	public static void setLevel(int level) {
	}
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
	public PondSprite(Location loc) {
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
		 this.goalSelector.a(2, new PathfinderGoalZombieAttack(this, 1.2D, false));
		 this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.2D));
		 this.goalSelector.a(7, new PathfinderGoalRandomStrollLand(this, 1.2D));
		 this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		 this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
		 this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true, new Class[] { EntityPigZombie.class }));
		 this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<> (this, EntityHuman.class, true));
		 this.goalSelector.a(0, new PathfinderGoalPanic(this, 1.25D));
		 PondSprite.setLevel(1);
		 
		 
}
	@Override
	protected void initAttributes() {
		super.initAttributes();
		this.getAttributeInstance(Attributes.MAX_HEALTH.asIAttribute()).setValue(6.0);
		this.getAttributeInstance(Attributes.ARMOR.asIAttribute()).setValue(2.0);
		this.getAttributeInstance(Attributes.ATTACK_DAMAGE.asIAttribute()).setValue(2.0);
	}
	
	public void getInitAttributes() {
		initAttributes();
	}
	
	@SuppressWarnings("deprecation")
	public static Zombie spawn(Location loc) {
		World world = ((CraftWorld) loc.getWorld()).getHandle();
		PondSprite pondSprite = new PondSprite(loc);
		LivingEntity en = (LivingEntity) pondSprite.getBukkitEntity();
        EntityEquipment equip = en.getEquipment();
        ItemStack iv = new ItemStack(Material.SKULL_ITEM,1, (short) SkullType.PLAYER.ordinal());
        SkullMeta psmeta = (SkullMeta) iv.getItemMeta();
        
        psmeta.setOwner("MHF_GUARDIAN");
        iv.setItemMeta(psmeta);
        equip.setHelmet(iv);
        
		//pondSprite.setEquipment(EnumItemSlot.HEAD,CraftItemStack.as
		//ItemStack is = pondSprite.getEquipment(EnumItemSlot.HEAD);
		
		//net.minecraft.server.v1_12_R1.ItemStack pskull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		//SkullMeta meta = (SkullMeta) pskull.getItemMeta();
		//meta.setOwner("Luci");
		//pskull.setItemMeta(meta);
		//pondSprite.setSlot(EnumItemSlot.HEAD,new ItemStack pskull);
		/*Material pskull = Material.SKULL_ITEM;
		ItemStack skull = new ItemStack(Material.SKULL, 1, (short) 3);
		SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
		skullMeta.setOwner("Luci");
		skull.setItemMeta(skullMeta);
		pondSprite.getEquipment().setHelmet(skull);*/
		world.addEntity(pondSprite,SpawnReason.CUSTOM);
		return (Zombie) pondSprite.getBukkitEntity();
		
		
	}
	
	
	//@Override
	/*protected void r() {
		this.goalSelector.a(0, new PathfinderGoalFloat(this));
		
		
	}

	@Override
	public void a(EntityLiving arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}*/
	
}
