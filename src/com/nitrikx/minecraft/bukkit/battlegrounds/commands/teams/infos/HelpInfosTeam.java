package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.infos;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;

public class HelpInfosTeam {
	
	private static final Logger log = Logger.getLogger("Batlegrounds");
	
	private static final String suffix = "/bg team infos ";
	
	public static String[] commandsName = {
		"players",
		"admins",
	};
	
	public static String[] commandsDescription = {
		"list all players of a team.",
		"list all administrators of a team."
	};
	
	public static String[] commandsArgs = {
		" <teamname>",
		" <teamname> ",
	};
	
	public static void sendHelp(CommandSender sender) {
		
		if(commandsName.length != commandsDescription.length){
			log.severe(Battlegrounds.logSuffix + "Problem during help generation.");
			sender.sendMessage(ErrorMessage.CommandFail);
		}
		else{
			sender.sendMessage(ChatColor.RED + "Battlegrounds [team player] help : ");
			
			//Print all the command descriptions
			for(int i = 0 ; i < commandsName.length ; i++){
				sender.sendMessage(suffix + commandsName[i] + commandsArgs[i] + " : " + commandsDescription[i]);
			}
		}
		
	}
	
}
