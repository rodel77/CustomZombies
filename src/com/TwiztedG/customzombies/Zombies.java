package com.TwiztedG.customzombies;

import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

import com.github.cc007.headsplugin.bukkit.HeadCreator;
import com.github.cc007.headsplugin.exceptions.AuthenticationException;
import com.github.cc007.headsplugin.utils.HeadsUtils;

public enum Zombies {
	CAT("Cat", getHead("cat", 3)),
	ZOMBIE("Zombie", getHead("zombie", 0));
	
	String name;
	ItemStack head;
	
	Zombies(String name, ItemStack head){
		this.name = name;
		this.head = head;
	}
	
	public static ItemStack getHead(String n, int index){
		try {
			return HeadCreator.getItemStack(HeadsUtils.getInstance().getHead(n, index));
		} catch (IOException | AuthenticationException e) {
			return new ItemStack(Material.AIR);
		}
	}
	
	public void spawn(Location location){
		Zombie cz = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
		cz.getEquipment().setHelmet(head);
	}
}
