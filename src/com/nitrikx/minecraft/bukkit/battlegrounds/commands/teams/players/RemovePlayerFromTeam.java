package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.players;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;
import com.nitrikx.minecraft.bukkit.battlegrounds.config.ConfigBG;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;
import com.nitrikx.minecraft.bukkit.battlegrounds.tools.Tools;

public class RemovePlayerFromTeam {
	
	public static final String usage = ChatColor.YELLOW + "/" + BattlegroundsCommands.suffix + " " 
			+ BattlegroundsCommands.Team.suffix + " " + BattlegroundsCommands.Team.RemovePlayer
			+ " <playername>"; 
	
	public static void remove(CommandSender sender, String[] args){
		
		//If user allowed
		if(sender.hasPermission("battlegrounds.team.player.remove") || TeamsManager.getInstance().isAdminOf(args[3], args[4])){
			
			//team + addplayer + player + team
			if(args.length < 2+2){
				sender.sendMessage(ErrorMessage.MissingParameters);
			}
			else{
				String playerName = args[2];
				String teamName = args[3];
				
				//If team name length  is correct
				if(teamName.length() > ConfigBG.maxTeamNameLength || teamName.length() < ConfigBG.minTeamNameLength){
					sender.sendMessage(ErrorMessage.InvalidNameLength);
				}
				else{
					//If player is online
					if(Tools.isPlayerOnline(playerName)){
						
						String playerTeam = TeamsManager.getInstance().retrievePlayerTeam(playerName);
						
						//If player has not team
						if(playerTeam.equals("")){
							
							//If player can be added
							if(TeamsManager.getInstance().addPlayerToTeam(playerName, teamName)){
								sender.sendMessage(ChatColor.GREEN + String.format("[%s] added in [%s].", playerName, teamName));
							}
							else{
								sender.sendMessage(ChatColor.RED + String.format("Can not add [%s] in [%s]. Team is full ?", playerName, teamName));
							}
							
						}
						else{
							sender.sendMessage(ChatColor.RED + String.format("Player is already in a team (%s)", playerTeam));
						}
						
					}
					else{
						sender.sendMessage(ErrorMessage.OfflinePlayer);
					}
				}
				
			}
			
		}
		//Else not allowed
		else{
			sender.sendMessage(ErrorMessage.NotAllowed);
		}
				
	}
}