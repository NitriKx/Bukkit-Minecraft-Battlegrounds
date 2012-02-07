package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.infos;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class InfosPlayers {
	
	/**
	 * List all player of a team. (/bg team infos list)
	 * @param sender
	 * @param args
	 */
	public static void list(CommandSender sender, String[] args){
		
		//If player not allowed to list team
		if(sender.hasPermission("battlegrounds.team.player.list")){
			
			if(args.length < 2+1){
				sender.sendMessage(ErrorMessage.MissingParameters);
			}
			else{
				String teamName = args[3];
				
				if(TeamsManager.getInstance().isTeamExist(teamName)){
					
					//Get list of player
					List<String> playerList = TeamsManager.getInstance().getTeamByName(teamName).getMembers();
					
					//List all players
					for(String player : playerList){
						sender.sendMessage(ChatColor.GREEN + player);
					}
				}
				else{
					sender.sendMessage(ChatColor.RED + String.format("Team [%s] does not exist.", teamName));
				}
			}
			
			
		}
		else{
			sender.sendMessage(ErrorMessage.NotAllowed);
		}

		
	}
	
}
