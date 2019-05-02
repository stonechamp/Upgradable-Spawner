package me.champ.spawners;

import org.bukkit.entity.ArmorStand;


public class CustomSpawner {
	
	ArmorStand name;
	String label;

	public CustomSpawner(ArmorStand name, String label) {
		this.name = name;
		name.setCustomName(label);
		
	}
	
	public String getName() {
		return name.getCustomName();
	}
	
	public void setup() {
		name.setArms(false);
        name.setGravity(false);
        name.setSmall(false);
        name.setVisible(false);
        name.setCustomNameVisible(true);
        name.setCanPickupItems(false);
	}
	
	
}
