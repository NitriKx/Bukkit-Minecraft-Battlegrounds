package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TeamsInterpreter {
	
	public static boolean interpret(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//if no args : /bg team
		if(args.length < 1){
			HelpTeam.sendHelpTeam(sender);
			return true;
		}
		
		
		return false;
	}
	
	
}
