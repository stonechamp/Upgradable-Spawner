package me.champ.spawners.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.BlockIterator;

import me.champ.spawners.Main;
import net.minecraft.server.v1_8_R1.BlockPosition;





public class OnSpawnerPlaceAndBreak implements Listener {
	
	Main plugin = Main.getInstance();
	
	@EventHandler
    public void on(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        
        
        if (e.getBlock().getType() == Material.MOB_SPAWNER) {
        	Block customSpawner = e.getBlock();
        	World world = customSpawner.getWorld();
        	Location loc = customSpawner.getLocation();
        	BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        	String itemName = p.getItemInHand().getItemMeta().getDisplayName();
        	System.out.println(itemName);
        	
        	if (itemName == null) {
        		customSpawner.setMetadata("Level One", new FixedMetadataValue(plugin, "lvl1"));
        	}
        	
        	if (itemName != null) {
        		if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Level 1")) {
            		customSpawner.setMetadata("Level One", new FixedMetadataValue(plugin, "lvl1"));
            	} else if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Level 2")) {
            		customSpawner.setMetadata("Level Two", new FixedMetadataValue(plugin, "lvl2"));
            	} else if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Level 3")) {
            		customSpawner.setMetadata("Level Three", new FixedMetadataValue(plugin, "lvl3"));
            	} else if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Level 4")) {
            		customSpawner.setMetadata("Level Four", new FixedMetadataValue(plugin, "lvl4"));
            	} else if (itemName.toString().contains(ChatColor.GOLD + "[Spawner] Max Level")) {
            		customSpawner.setMetadata("Level Five", new FixedMetadataValue(plugin, "lvl5"));
            	}
        	}
        	
            
        }
    }
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		ItemStack itemInHand = player.getItemInHand();
		if (block.getType() == Material.MOB_SPAWNER) {
			Enchantment silkTouch = new EnchantmentWrapper(33);
			if (itemInHand.containsEnchantment(silkTouch)){
				if (block.hasMetadata("Level One")) {
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Level 1");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				}else if (block.hasMetadata("Level Two")) {
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Level 2");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Level Three")) {
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Level 3");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Level Four")) {
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Level 4");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				} else if (block.hasMetadata("Level Five")) {
					event.setCancelled(true);
					block.setType(Material.AIR);
					ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
					ItemMeta meta = spawner.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "[Spawner] Max Level");
					spawner.setItemMeta(meta);
					
					block.getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(spawner));
				}
			}
		
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
