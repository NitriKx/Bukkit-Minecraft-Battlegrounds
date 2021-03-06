package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.infos;

import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;

public class TeamInfosInterpreter {
	
	/**
	 * Interpret commands with suffix "/bg team player"
	 * @param sender
	 * @param args
	 * @return
	 */
	public static boolean interpret(CommandSender sender, String[] args){
		//if no args : /bg team player
		if(args.length < 3){
			HelpInfosTeam.sendHelp(sender);
			return true;
		}
		else if(args[2].equalsIgnoreCase(BattlegroundsCommands.Team.Infos.ListPlayers)){
			InfosPlayers.list(sender, args);
			return true;
		}
		else if(args[2].equalsIgnoreCase(BattlegroundsCommands.Team.Infos.ListAdmins)){
			InfosAdmins.list(sender, args);
			return true;
		}
	
		return false;
	}
	
}
