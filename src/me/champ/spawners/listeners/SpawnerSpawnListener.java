package me.champ.spawners.listeners;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

public class SpawnerSpawnListener implements Listener {
	
	public ArrayList<String> lvl1Mobs = new ArrayList<String>();
	
	@EventHandler
	public void onSpawnerSpawn(SpawnerSpawnEvent event) {
		Random random = new Random();
		
		CreatureSpawner spawner = event.getSpawner();
		//CraftCreatureSpawner craftSpawner = (CraftCreatureSpawner) event.getSpawner();
		
		
		
		event.setCancelled(true);
		event.getEntity().remove();
		
		if (spawner.hasMetadata("Level One")) {
			
			event.setCancelled(true);
			Entity mob = event.getEntity();
		    World world = (World) event.getSpawner().getWorld(); 
		    
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
  
		}
		
		if (spawner.hasMetadata("Level Two")) {
			
			event.setCancelled(true);
			Entity mob = event.getEntity();
		    World world = (World) event.getSpawner().getWorld(); 
		    
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());

		}
		
        if (spawner.hasMetadata("Level Three")) {
			
			event.setCancelled(true);
			Entity mob = event.getEntity();
		    World world = (World) event.getSpawner().getWorld(); 
		    
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    
		}
		
		if (spawner.hasMetadata("Level Four")) {
			
			event.setCancelled(true);
			Entity mob = event.getEntity();
		    World world = (World) event.getSpawner().getWorld(); 
		    
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
			world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		}
		
		if (spawner.hasMetadata("Level Five")) {
			
			event.setCancelled(true);
			Entity mob = event.getEntity();
		    World world = (World) event.getSpawner().getWorld(); 
		    
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		    world.spawn(event.getSpawner().getLocation().add(getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5), getRandomNumberInRange(random, 0, 5)), mob.getClass());
		}

	}
	
	private int getRandomNumberInRange(Random r, int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
