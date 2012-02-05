package com.nitrikx.minecraft.bukkit.battlegrounds.commands.plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help {
	
	public static String[] commandsName = {
		"/bg version",
		"/bg help"
	};
	
	public static String[] commandsDescription = {
		"get the version of battlegrounds.",
		"get this help"
	};
	
	public static void sendHelp(Player sender){
		
		sender.sendMessage(ChatColor.RED + "Battlegrounds help : ");
		
		//Print all the command descriptions
		for(int i = 0 ; i < commandsName.length ; i++){
			sender.sendMessage(commandsName[i] + " : " + commandsDescription[i]);
		}
		
		sender.sendMessage(ChatColor.RED + "END");
	}
	
}
