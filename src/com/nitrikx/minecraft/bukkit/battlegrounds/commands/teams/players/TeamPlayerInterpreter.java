package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.players;

import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;

public class TeamPlayerInterpreter {
	
	/**
	 * Interpret commands with suffix "/bg team player"
	 * @param sender
	 * @param args
	 * @return
	 */
	public static boolean interpret(CommandSender sender, String[] args){
		//if no args : /bg team player
		if(args.length < 3){
			HelpPlayerTeam.sendHelpPlayerTeam(sender);
			return true;
		}
		else if(args[2].equalsIgnoreCase(BattlegroundsCommands.Team.Player.Add)){
			AddPlayerToTeam.add(sender, args);
			return true;
		}
		else if(args[2].equalsIgnoreCase(BattlegroundsCommands.Team.Player.Remove)){
			RemovePlayerFromTeam.remove(sender, args);
			return true;
		}
		
		return false;
	}
}
