package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.players;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class RemovePlayerFromTeam {
	
	public static final String usage = ChatColor.YELLOW + "/" + BattlegroundsCommands.suffix + " " 
			+ BattlegroundsCommands.Team.suffix + " " + BattlegroundsCommands.Team.RemovePlayer
			+ " <playername>"; 
	
	public static void remove(CommandSender sender, String[] args){
		
		//If user allowed
		if(sender.hasPermission("battlegrounds.team.player.remove")){
			
		//team + addplayer + player
		if(args.length < 2+1){
			sender.sendMessage(ErrorMessage.MissingParameters);
		}
		else{
			String playerName = args[2];

			String playerTeam = TeamsManager.getInstance().retrievePlayerTeam(playerName);
					
			//If player has a team
			if(!playerTeam.equals("")){
				
				//If player can be added
				if(TeamsManager.getInstance().removePlayerFromTeam(playerName)){
					sender.sendMessage(ChatColor.GREEN + String.format("[%s] removed from [%s].", playerName, playerTeam));
				}
				else{
					sender.sendMessage(ChatColor.RED + String.format("Can not remove [%s] from [%s].", playerName, playerTeam));
				}
				
			}
			else{
				sender.sendMessage(ChatColor.RED + String.format("%s has no team.", playerName));
			}
					
			}
				
		}
		//Else not allowed
		else{
			sender.sendMessage(ErrorMessage.NotAllowed);
		}
				
	}
}
