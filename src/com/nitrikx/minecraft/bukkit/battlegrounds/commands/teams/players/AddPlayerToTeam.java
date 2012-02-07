package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.players;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;
import com.nitrikx.minecraft.bukkit.battlegrounds.config.ConfigBG;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;
import com.nitrikx.minecraft.bukkit.battlegrounds.tools.Tools;

public class AddPlayerToTeam {
	
	public static final String usage = ChatColor.YELLOW + "/" + BattlegroundsCommands.suffix + " " 
			+ BattlegroundsCommands.Team.suffix + " "
			+ BattlegroundsCommands.Team.Player.suffix + " " + BattlegroundsCommands.Team.Player.Add
			+ " <playername> <teamname>"; 
	
	/**
	 * Add a player to a team.
	 * @param sender The command sender
	 * @param args The args linked with the command
	 */
	public static void add(CommandSender sender, String [] args){
		
		//If user allowed
		if(sender.hasPermission("battlegrounds.team.player.add") || TeamsManager.getInstance().isAdminOf(args[3], args[4])){
			
			//team + player + add + player + team
			if(args.length < 2+3){
				sender.sendMessage(ErrorMessage.MissingParameters);
			}
			else{
				String playerName = args[3];
				String teamName = args[4];
				
				//If team name length is correct
				if(teamName.length() > ConfigBG.maxTeamNameLength || teamName.length() < ConfigBG.minTeamNameLength){
					sender.sendMessage(ErrorMessage.InvalidNameLength);
				}
				else{
					//If player is online
					if(Tools.isPlayerOnline(playerName)){
						
						String playerTeam = TeamsManager.getInstance().retrievePlayerTeam(playerName);
						
						//If player has no team
						if(playerTeam.equals("")){
							
							//If player can be added
							if(TeamsManager.getInstance().addPlayerToTeam(playerName, teamName)){
								sender.sendMessage(ChatColor.GREEN + String.format("[%s] added in [%s].", playerName, teamName));
								try{
									Bukkit.getServer().getPlayer(playerName).sendMessage(ChatColor.GOLD + String.format("You are now in team %s.", teamName));
								}
								catch(NullPointerException e){}
							}
							else{
								sender.sendMessage(ChatColor.RED + String.format("Can not add [%s] in [%s]. Team is full or does not exist ?", playerName, teamName));
							}
							
						}
						else{
							sender.sendMessage(ChatColor.RED + String.format("%s is already in a team (%s)", playerName, playerTeam));
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
