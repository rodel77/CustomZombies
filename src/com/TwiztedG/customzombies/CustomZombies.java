package com.TwiztedG.customzombies;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomZombies extends JavaPlugin{
	@Override
	public void onEnable() {
		getCommand("czombies").setExecutor(new ZombieCommand());
		getServer().getPluginManager().registerEvents(new ZombieListener(), this);
	}
}
