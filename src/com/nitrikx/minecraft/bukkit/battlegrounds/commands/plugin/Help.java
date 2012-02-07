package com.nitrikx.minecraft.bukkit.battlegrounds.commands.plugin;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;

public class Help {
	
	private static final Logger log = Logger.getLogger("Batlegrounds");
	
	public static String[] commandsName = {
		"/bg version",
		"/bg help",
		"/bg team"
	};
	
	public static String[] commandsDescription = {
		"get the version of battlegrounds.",
		"get this help",
		"get help for team sub-section"
	};
	
	public static void sendHelp(CommandSender sender){
		
		if(commandsName.length != commandsDescription.length){
			log.severe("Problem during help generation.");
			sender.sendMessage(ErrorMessage.CommandFail);
		}
		else{
		
			sender.sendMessage(ChatColor.RED + "Battlegrounds help : ");
			
			//Print all the command descriptions
			for(int i = 0 ; i < commandsName.length ; i++){
				sender.sendMessage(commandsName[i] + " : " + commandsDescription[i]);
			}
		}
	}
	
}
