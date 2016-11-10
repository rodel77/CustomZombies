package com.TwiztedG.customzombies;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class ZombieListener implements Listener{
	@EventHandler
	public void onCreatureSpawnEvent(CreatureSpawnEvent e){
		if(e.getEntity().getType()==EntityType.ZOMBIE && new Random().nextInt(10)==0){
			Zombies.values()[new Random().nextInt(Zombies.values().length)].spawn(e.getLocation());
			e.setCancelled(true);
		}
	}
}
