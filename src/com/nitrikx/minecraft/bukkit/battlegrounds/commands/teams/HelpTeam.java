package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;

public class HelpTeam {
	
	private static final Logger log = Logger.getLogger("Batlegrounds");
	
	private static final String suffix = "/bg team ";
	
	public static String[] commandsName = {
		"list",
		"create",
		"delete",
		"addplayer",
		"removeplayer"
	};
	
	public static String[] commandsDescription = {
		"get the list of teams.",
		"create a team.",
		"delete a team.",
		"add a player to a team",
		"remove a player from his team"
	};
	
	public static String[] commandsArgs = {
		"",
		" <teamname>",
		" <teamname>",
		" <playername> <teamname>",
		" <playername>"
	};
	
	public static void sendHelpTeam(CommandSender sender){
		
		if(commandsName.length != commandsDescription.length){
			log.severe("Problem during help generation.");
			sender.sendMessage(ErrorMessage.CommandFail);
		}
		else{
			sender.sendMessage(ChatColor.RED + "Battlegrounds team help : ");
			
			//Print all the command descriptions
			for(int i = 0 ; i < commandsName.length ; i++){
				sender.sendMessage(suffix + commandsName[i] + commandsArgs[i] + " : " + commandsDescription[i]);
			}
		}
	}
	
	
}
