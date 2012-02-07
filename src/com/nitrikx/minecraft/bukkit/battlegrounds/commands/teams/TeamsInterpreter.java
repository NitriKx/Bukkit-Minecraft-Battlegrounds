package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;

public class TeamsInterpreter {
	
	public static boolean interpret(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//if no args : /bg team
		if(args.length < 2){
			HelpTeam.sendHelpTeam(sender);
			return true;
		}
		else if(args[1].equalsIgnoreCase(BattlegroundsCommands.Team.List)){
			ListTeams.listAllTeams(sender);
			return true;
		}
		else if(args[1].equalsIgnoreCase(BattlegroundsCommands.Team.Help)){
			HelpTeam.sendHelpTeam(sender);
			return true;
		}
		else if(args[1].equalsIgnoreCase(BattlegroundsCommands.Team.Create)){
			CreateTeam.create(sender, args);
			return true;
		}
		else if(args[1].equalsIgnoreCase(BattlegroundsCommands.Team.Delete)){
			DeleteTeam.delete(sender, args);
			return true;
		}
		
		return false;
	}
	
	
}
