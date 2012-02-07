package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.players;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;

public class HelpPlayerTeam {

	private static final Logger log = Logger.getLogger("Batlegrounds");
	
	private static final String suffix = "/bg team player ";
	
	public static String[] commandsName = {
		"add",
		"remove",
		"admin"
	};
	
	public static String[] commandsDescription = {
		"add a player to a team.",
		"remove a player from his team.",
		"set/unset a player as his team administrator"
	};
	
	public static String[] commandsArgs = {
		" <playername> <teamname>",
		" <playername>",
		" <playername>"
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
