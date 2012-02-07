package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;
import com.nitrikx.minecraft.bukkit.battlegrounds.config.ConfigBG;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class DeleteTeam {

	public static final String usage = ChatColor.YELLOW + "/" + BattlegroundsCommands.suffix + " " 
				+ BattlegroundsCommands.Team.suffix + " " + BattlegroundsCommands.Team.Delete
				+ " <teamname>"; 
		
		@SuppressWarnings("unused")
		private static final Logger log = Logger.getLogger("Battlegrounds");
		
		public static void delete(CommandSender sender, String [] args){
			
			if(sender.hasPermission("battlegrounds.team.delete")){
				//If missing parameters
				if(args.length < 2+1){
					sender.sendMessage(ErrorMessage.MissingParameters);
					sender.sendMessage(ChatColor.YELLOW + usage);
				}
				else if(args.length > 2+1+1){
					sender.sendMessage(ErrorMessage.TooManyParameters);
					sender.sendMessage(ChatColor.YELLOW + usage);
				}
				else{
					String name = args[2];
					
					//If name is too long of too short
					if(name.length() < ConfigBG.minTeamNameLength || name.length() > ConfigBG.maxTeamNameLength){
						sender.sendMessage(ChatColor.RED + "Your team name is too long or too short.");
					}
					else if(TeamsManager.getInstance().isTeamExist(name)){
						
						for(String teamPlayers : TeamsManager.getInstance().getTeamByName(name).getMembers()){
							try{
								Bukkit.getServer().getPlayer(teamPlayers).sendMessage(ChatColor.GOLD + String.format("Team %s has been deleted.", name));
							}
							catch(NullPointerException e){}
						}
						
						TeamsManager.getInstance().deleteTeam(name);
						sender.sendMessage(ChatColor.GREEN + String.format("Team [%s] delete.", name));
					}
					else{
						sender.sendMessage(ChatColor.RED + String.format("Can not delete team [%s].", name));
					}
				}
			}
			else{
				sender.sendMessage(ErrorMessage.NotAllowed);
			}
			
			
		}
		
}
