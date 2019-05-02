package me.champ.spawners;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {

	public Inventory lvl1inv;
	public Inventory lvl2inv;
	public Inventory lvl3inv;
	public Inventory lvl4inv;
	public Inventory lvl5inv;
	public Inventory inv;
	
	public String lvl1Name = ChatColor.GOLD + "[Upgrade Menu] Level 1";
	public String lvl2Name = ChatColor.GOLD + "[Upgrade Menu] Level 2";
	public String lvl3Name = ChatColor.GOLD + "[Upgrade Menu] Level 3";
	public String lvl4Name = ChatColor.GOLD + "[Upgrade Menu] Level 4";
	public String lvl5Name = ChatColor.GOLD + "[Upgrade Menu] Max Level";
	
	public GUI() {
		inv = Bukkit.createInventory(null, 18, lvl1Name );
		lvl2inv = Bukkit.createInventory(null, 18, lvl2Name );
		lvl3inv = Bukkit.createInventory(null, 18, lvl3Name );
		lvl4inv = Bukkit.createInventory(null, 18, lvl4Name );
		lvl5inv = Bukkit.createInventory(null, 18, lvl5Name );
	}
	
	public void initializeItems() {
        inv.setItem(0, createGuiItem( ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW + "Level:"+ ChatColor.WHITE + " 1", ChatColor.YELLOW + "Mobs Spawned: " + ChatColor.WHITE + "3")), Material.MOB_SPAWNER));
        inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:" + ChatColor.WHITE + " 250k", ChatColor.YELLOW + "About:" + ChatColor.WHITE + " +1 Mob Spawned")), Material.EMERALD));
        inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:" + ChatColor.WHITE +" 2",ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 4" )), Material.BOOK));
        inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL)); 
        
        lvl2inv.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 2", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 4")), Material.MOB_SPAWNER));
        lvl2inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:"+ ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
        lvl2inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 3", ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 5" )), Material.BOOK));
        lvl2inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL)); 
        
        lvl3inv.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 3", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 5")), Material.MOB_SPAWNER));
        lvl3inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:" + ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
        lvl3inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 4", ChatColor.YELLOW + "Mobs Per Spawn:" + ChatColor.WHITE +" - 6" )), Material.BOOK));
        lvl3inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
        
        lvl4inv.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 4", ChatColor.YELLOW + "Mobs Spawned:"+ ChatColor.WHITE +" 6")), Material.MOB_SPAWNER));
        lvl4inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Cost:"+ ChatColor.WHITE +" 250k", ChatColor.YELLOW + "About:"+ ChatColor.WHITE +" +1 Mob Spawned")), Material.EMERALD));
        lvl4inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 5", ChatColor.YELLOW + "Mobs Per Spawn:"+ ChatColor.WHITE +" - 7" )), Material.BOOK));
        lvl4inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
        
        lvl5inv.setItem(0, createGuiItem(ChatColor.AQUA + "Spawner Stats", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"Level:"+ ChatColor.WHITE +" 5", ChatColor.YELLOW + "Mobs Spawned: 7")), Material.MOB_SPAWNER));
        lvl5inv.setItem(4, createGuiItem(ChatColor.AQUA + "Upgrade", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"You have reached the max level.")), Material.EMERALD));
        lvl5inv.setItem(8, createGuiItem(ChatColor.AQUA + "Next Level", new ArrayList<String>(Arrays.asList(ChatColor.YELLOW +"You have reached the max level." )), Material.BOOK));
        lvl5inv.setItem(13, createGuiItem(ChatColor.YELLOW + "Close GUI", new ArrayList<String>(Arrays.asList("")), Material.ANVIL));
    }
	
	public ItemStack createGuiItem(String name, ArrayList<String> desc, Material mat) {
        ItemStack i = new ItemStack(mat, 1);
        ItemMeta iMeta = i.getItemMeta();
        iMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        iMeta.setDisplayName(name);
        iMeta.setLore(desc);
        i.setItemMeta(iMeta);
        return i;
    }
	
	public void openInventory(Player p, Inventory i) {
        p.openInventory(i);
        return;
    }
	
	
}
