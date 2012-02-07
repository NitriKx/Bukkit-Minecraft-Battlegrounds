package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.players;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class TogglePlayerAdmin {
	
	/**
	 * Set/unset a player administorator of a team. (/bg team player admin <playername>)
	 * @param sender The command sender
	 * @param args Command args
	 */
	public static void toggle(CommandSender sender, String [] args){
		
		//team + player + admins + playername + teamname
		if(args.length < 2+2){
			sender.sendMessage(ErrorMessage.MissingParameters);
		}
		else{
			
			String playerName = args[3];
			
			String teamPlayer = TeamsManager.getInstance().retrievePlayerTeam(playerName);
			
			//If player has no team
			if(teamPlayer.equals("")){
				sender.sendMessage(ChatColor.RED + String.format("%s has not team.", playerName));
			}
			else{
				
				//If allowed to add an administrator
				if(sender.hasPermission("battlegrounds.team.player.admin") || TeamsManager.getInstance().isAdminOf(sender.getName(), teamPlayer)){
					
					//If now admin
					if(TeamsManager.getInstance().toggleAdministration(playerName)){
						sender.sendMessage(ChatColor.GREEN + String.format("%s is now ADMIN of %s.", playerName, teamPlayer));
						
						try{
							Bukkit.getServer().getPlayer(playerName).sendMessage(ChatColor.GOLD + String.format("You are now an administrator of %s !", teamPlayer));
						}
						catch(NullPointerException e){}
					}
					//If now a simple player
					else{
						sender.sendMessage(ChatColor.YELLOW + String.format("%s is now a SIMPLE PLAYER of %s.", playerName, teamPlayer));
						
						try{
							Bukkit.getServer().getPlayer(playerName).sendMessage(ChatColor.GOLD + String.format("You lost your administrator status of %s !", teamPlayer));
						}
						catch(NullPointerException e){}
					}
				}
				else{
					sender.sendMessage(ErrorMessage.NotAllowed);
				}
			
			}
			
		}
		
		
		
		
	}
	
	
	
}
