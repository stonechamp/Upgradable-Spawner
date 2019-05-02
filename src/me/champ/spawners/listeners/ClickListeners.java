package me.champ.spawners.listeners;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.BlockIterator;

import me.champ.spawners.Main;

public class ClickListeners implements Listener  {
	
	Main plugin = Main.getInstance();
	
	
	@EventHandler
	public void onBlockClick(PlayerInteractEvent event) {
		
		Action action = event.getAction();
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		
		if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
			if (block.getType().equals(Material.MOB_SPAWNER)) {
				if (block.hasMetadata("Level One")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.inv);
					
				} else if (block.hasMetadata("Level Two")){
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.lvl2inv);
				} else if (block.hasMetadata("Level Three")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.lvl3inv);
				} else if (block.hasMetadata("Level Four")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.lvl4inv);
				} else if (block.hasMetadata("Level Five")) {
					plugin.upgradeMenu.initializeItems();
					plugin.upgradeMenu.openInventory(player, plugin.upgradeMenu.lvl5inv);
				}
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		String guiName = event.getInventory().getName();
		
		if(!(guiName == plugin.upgradeMenu.lvl1Name || guiName == plugin.upgradeMenu.lvl2Name || guiName == plugin.upgradeMenu.lvl3Name || guiName == plugin.upgradeMenu.lvl4Name || guiName == plugin.upgradeMenu.lvl5Name)) {
			return;
		}
		
		if (event.getClick().equals(ClickType.NUMBER_KEY)){
            event.setCancelled(true); 
        }
		
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        
        if (clickedItem == null || clickedItem.getType().equals(Material.AIR)) return;
        
        
        if (event.getRawSlot() == 4 && guiName == plugin.upgradeMenu.lvl1Name) {
            player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            player.closeInventory();
            
            
            Block spawnerToChange = getTargetBlock(player, 10);
            if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
            	spawnerToChange.removeMetadata("Level One", plugin);
                spawnerToChange.setMetadata("Level Two", new FixedMetadataValue(plugin, "lvl2"));
            }
            
            
        } else if (event.getRawSlot() == 4 && guiName == plugin.upgradeMenu.lvl2Name) {
        	
        	player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            player.closeInventory();

            Block spawnerToChange = getTargetBlock(player, 10);
            if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
            	spawnerToChange.removeMetadata("Level Two", plugin);
                spawnerToChange.setMetadata("Level Three", new FixedMetadataValue(plugin, "lvl3"));
            }
            
            
            
        } else if (event.getRawSlot() == 4 && guiName == plugin.upgradeMenu.lvl3Name) {
        	
        	player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            player.closeInventory();
            
            java.util.List<Entity> nearby = player.getNearbyEntities(4, 4, 4);
            
            Block spawnerToChange = getTargetBlock(player, 10);
            if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
            	 spawnerToChange.removeMetadata("Level Three", plugin);
                 spawnerToChange.setMetadata("Level Four", new FixedMetadataValue(plugin, "lvl4"));
            }

        }else if (event.getRawSlot() == 4 && guiName == plugin.upgradeMenu.lvl4Name) {
        	
        	player.sendMessage(ChatColor.GREEN + "[Spawners] Upgrade successful.");
            player.closeInventory();
            
            Block spawnerToChange = getTargetBlock(player, 10);
            if (spawnerToChange.getType() == Material.MOB_SPAWNER) {
            	spawnerToChange.removeMetadata("Level Four", plugin);
                spawnerToChange.setMetadata("Level Five", new FixedMetadataValue(plugin, "lvl5"));
            }
            
            
        } else if (event.getRawSlot() == 4 && guiName == plugin.upgradeMenu.lvl5Name) {
        	
        	player.sendMessage(ChatColor.RED + "[Spawners] Nothing left to upgrade.");
        	player.closeInventory();
	
            
        } else if (event.getRawSlot() == 13 && guiName == plugin.upgradeMenu.lvl1Name || guiName == plugin.upgradeMenu.lvl2Name || guiName == plugin.upgradeMenu.lvl3Name || guiName == plugin.upgradeMenu.lvl4Name || guiName == plugin.upgradeMenu.lvl5Name) {
        	player.closeInventory();
        }

        
		
	}
	
	public final Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        return lastBlock;
    }
	

}
