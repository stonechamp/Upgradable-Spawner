package me.champ.spawners;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class SpawnCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can run this command.");
		}
		
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("uspawner")) {
			ItemStack spawner = new ItemStack(Material.MOB_SPAWNER);
			ItemMeta name = spawner.getItemMeta();
			name.setDisplayName(ChatColor.GOLD + "[Spawner] Level 1");
			spawner.setItemMeta(name);
			player.getInventory().addItem(spawner);
			
			
		}
		
		
		return true;
	}
	
	

}
