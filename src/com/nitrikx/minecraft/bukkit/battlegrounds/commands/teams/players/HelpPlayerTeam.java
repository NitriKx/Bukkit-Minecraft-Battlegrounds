package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.players;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;

public class HelpPlayerTeam {

private static final Logger log = Logger.getLogger("Batlegrounds");
	
	private static final String suffix = "/bg team player ";
	
	public static String[] commandsName = {
		"list",
		"add",
		"remove",
	};
	
	public static String[] commandsDescription = {
		"list all players of a team.",
		"add a player to a team.",
		"remove a player from his team.",
	};
	
	public static String[] commandsArgs = {
		"",
		" <playername> <teamname>",
		" <playername>",
		" <playername> <teamname>",
	};
	
	public static void sendHelpPlayerTeam(CommandSender sender) {
		
		if(commandsName.length != commandsDescription.length){
			log.severe("Problem during help generation.");
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
