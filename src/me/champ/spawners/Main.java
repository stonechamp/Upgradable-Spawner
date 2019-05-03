package me.champ.spawners;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.champ.spawners.listeners.ClickListeners;
import me.champ.spawners.listeners.OnSpawnerPlaceAndBreak;
import me.champ.spawners.listeners.SpawnerSpawnListener;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	public GUI upgradeMenu;
	
	public Location spawnerToChange; //Pass spawner location around to different classes
	
	private Economy econ;
    private Permission perms;
    private Chat chat;

	
	public void onEnable() {
		plugin = this;
		
		upgradeMenu = new GUI();
		this.getCommand("uspawner").setExecutor(new SpawnCmd());
		this.registerEvents();
		
		
		if (!setupEconomy()) {
            this.getLogger().severe("Disabled due to no Vault dependency found!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        this.setupPermissions();
        this.setupChat();
	}
	
	public static Main getInstance() {
		return plugin;
	}
	
	public void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new ClickListeners(), this);
		this.getServer().getPluginManager().registerEvents(new OnSpawnerPlaceAndBreak(), this);
		this.getServer().getPluginManager().registerEvents(new SpawnerSpawnListener(), this);
		
	}
	
	private boolean setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        
        if (rsp == null) {
        	return false;
        }else {
        	chat = rsp.getProvider();
        	return chat != null;
        }
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public Economy getEcononomy() {
        return econ;
    }

    public Permission getPermissions() {
        return perms;
    }

    public Chat getChat() {
        return chat;
    }

}
