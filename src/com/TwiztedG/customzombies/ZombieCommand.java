package com.TwiztedG.customzombies;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ZombieCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("czombies")){
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(args.length==0){
					sendMessage(sender, "&4&lNo zombie type! Example. "+command.getName()+" Cat");
				}else if(args.length==1){
					Zombies z = null;
					
					for(Zombies zombie : Zombies.values()){
						if(args[0].equalsIgnoreCase(zombie.toString())){
							z = zombie;
						}
					}
					
					if(z==null){
						sendMessage(sender, "&cInvalid zombie!");
					}else{
						if(sender.hasPermission("customz."+z.toString().toLowerCase())){
							z.spawn(player.getTargetBlock((HashSet<Byte>) null, 5).getLocation());
						}else{
							sendMessage(sender, "&cYou don't have permission to use this command!");
						}
					}
				}
			}else{
				sendMessage(sender, "&cYou must be a player to use this command!");
			}
		}
		return true;
	}
	
	public void sendMessage(CommandSender sender, String msg){
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

}
