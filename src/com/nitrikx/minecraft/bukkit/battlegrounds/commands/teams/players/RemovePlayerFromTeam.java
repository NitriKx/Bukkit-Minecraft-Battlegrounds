package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.players;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class RemovePlayerFromTeam {
	
	public static final String usage = ChatColor.YELLOW + "/" + BattlegroundsCommands.suffix + " " 
			+ BattlegroundsCommands.Team.suffix + " "
			+ BattlegroundsCommands.Team.Player.suffix + " " + BattlegroundsCommands.Team.Player.Remove
			+ " <playername>"; 
	
	public static void remove(CommandSender sender, String[] args){
		
			
		//team + player + add + player
		if(args.length < 2+2){
			sender.sendMessage(ErrorMessage.MissingParameters);
		}
		else{
			
			String playerName = args[3];
			String playerTeam = TeamsManager.getInstance().retrievePlayerTeam(playerName);
			
			//If player has a team
			if(!playerTeam.equals("")){
				
				//If user allowed (permission or admin of player team)
				if(sender.hasPermission("battlegrounds.team.player.remove") || TeamsManager.getInstance().isAdminOfPlayer(sender.getName(), args[3])){
					
					//If player can be added
					if(TeamsManager.getInstance().removePlayerFromTeam(playerName)){
						sender.sendMessage(ChatColor.GREEN + String.format("[%s] removed from [%s].", playerName, playerTeam));
						Bukkit.getServer().getPlayer(playerName).sendMessage(ChatColor.GOLD + String.format("You leave the %s team.", playerTeam));
					}
					else{
						sender.sendMessage(ChatColor.RED + String.format("Can not remove [%s] from [%s].", playerName, playerTeam));
					}
					
				}
				//Else not allowed
				else{
					sender.sendMessage(ErrorMessage.NotAllowed);
				}
			}
			else{
				sender.sendMessage(ChatColor.RED + String.format("%s has no team.", playerName));
			}
					
		}
				
	}
}
