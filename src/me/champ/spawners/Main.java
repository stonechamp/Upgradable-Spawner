package me.champ.spawners;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import me.champ.spawners.listeners.ClickListeners;
import me.champ.spawners.listeners.OnSpawnerPlaceAndBreak;
import me.champ.spawners.listeners.SpawnerSpawnListener;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	public GUI upgradeMenu;
	
	public Location spawnerToChange; //Pass spawner location around to different classes
	
	public void onEnable() {
		plugin = this;
		upgradeMenu = new GUI();
		
		this.registerEvents();
	}
	
	public static Main getInstance() {
		return plugin;
	}
	
	public void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new ClickListeners(), this);
		this.getServer().getPluginManager().registerEvents(new OnSpawnerPlaceAndBreak(), this);
		this.getServer().getPluginManager().registerEvents(new SpawnerSpawnListener(), this);
		
	}

}
