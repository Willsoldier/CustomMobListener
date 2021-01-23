package me.Adrenalize.TrialOne;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class Main extends JavaPlugin implements Listener {
	@Override 
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override 
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("hello")) {
			if (sender instanceof Player) {
				Player player = (Player) sender; 
				player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Hey. This is a challenge 4 u.");
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Enjoy! &2Note: mobs are in Hard Mode."));
				return true;
			} else {
				sender.sendMessage("Hey console");
				return true;
			}
		}
		return false;
	}
	@EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Zombie) { //check if the creature that just spawned (event.getEntity()) is a Zombie
            EntityEquipment entityEquipment = event.getEntity().getEquipment(); //Obtain the entity equipment from that zombie
            entityEquipment.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE)); //set chestplate to that entity equipment
            entityEquipment.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS)); // repeat with leggings
            entityEquipment.setBoots(new ItemStack(Material.DIAMOND_BOOTS)); // repeat with boots
            entityEquipment.setHelmet(new ItemStack(Material.DIAMOND_HELMET)); // repeat with helmet
            entityEquipment.setItemInMainHand(new ItemStack(Material.NETHERITE_AXE)); //deprecated in 1.16, use setItemInMainHand
            }
	}
	@EventHandler
	public void onSpawn1(CreatureSpawnEvent event) {
		if (event.getEntity() instanceof Creeper) {
			Creeper creeper = (Creeper) event.getEntity();
			creeper.setPowered(true);
		}
	}
	@EventHandler
	public void onSpawn2(CreatureSpawnEvent event) {
		if (event.getEntity() instanceof Skeleton) {
			Skeleton skeleton = (Skeleton) event.getEntity();
			skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 3));
			skeleton.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 2));
			skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999999, 3));
		}
	}
	@EventHandler
	public void onSpawn3(CreatureSpawnEvent event) {
		if (event.getEntity() instanceof Spider) {
			Spider spider = (Spider) event.getEntity();
			spider.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999999, 2));
			spider.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 4));
			//spider.addPassenger(EntityType.SKELETON); 
		}
	}
	@EventHandler
	public void onSpawn4(CreatureSpawnEvent event) {
		if (event.getEntity() instanceof Enderman) {
			Enderman ender = (Enderman) event.getEntity(); 
			ender.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 4));
			ender.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 2));
			ender.setPersistent(true);
			ender.setGliding(true);
		}
		}
	@EventHandler
	public void onSpawn5(CreatureSpawnEvent event) {
		if (event.getEntity() instanceof Pig) {
			Pig pig = (Pig) event.getEntity();
			Player player = (Player) event.getEntity();
			pig.attack(player);
			pig.setHealth(20.0);
		}
	}
}	
