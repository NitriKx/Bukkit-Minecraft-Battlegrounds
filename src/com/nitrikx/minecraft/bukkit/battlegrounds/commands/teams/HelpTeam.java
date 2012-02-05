package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;

public class HelpTeam {
	
	private static final Logger log = Logger.getLogger("Batlegrounds");
	
	private static final String suffix = "/bg team ";
	
	public static String[] commandsName = {
		"list"
	};
	
	public static String[] commandsDescription = {
		"get the list of teams"
	};
	
	public static void sendHelpTeam(CommandSender sender){
		
		if(commandsName.length != commandsDescription.length){
			log.severe("Problem during help generation.");
			sender.sendMessage(ErrorMessage.CommandFail);
		}
		else{
			sender.sendMessage(ChatColor.RED + "Battlegrounds help : ");
			
			//Print all the command descriptions
			for(int i = 0 ; i < commandsName.length ; i++){
				sender.sendMessage(suffix + commandsName[i] + " : " + commandsDescription[i]);
			}
			
			sender.sendMessage(ChatColor.RED + "END");
		}
	}
	
	
}
