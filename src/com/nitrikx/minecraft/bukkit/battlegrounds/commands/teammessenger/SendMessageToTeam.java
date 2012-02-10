package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teammessenger;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class SendMessageToTeam {
	
	/**
	 * Send a message to the team player
	 * @param sender The command sender
	 * @param args The text of the message
	 */
	public static boolean send(CommandSender sender, String [] args){
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}
		
		if(player != null){
			
			if(!TeamsManager.getInstance().retrievePlayerTeam(player.getName()).equals("")){
				String message = "";
				
				//Concat message
				for(String arg : args){
					message += arg + " ";
				}
				
				List<String> playersToSend = TeamsManager.getInstance().getTeamByName(
						TeamsManager.getInstance().retrievePlayerTeam(player.getName()))
						.getMembers();
				
				for(String playerToSend : playersToSend){
					
					//send message to players of team
					try{
						Bukkit.getServer().getPlayer(playerToSend).sendMessage(ChatColor.BLUE + "<" + player.getDisplayName() + "> " + message);
					}
					catch(NullPointerException e) {}
					
				}
				
				return true;
			}
			else{
				player.sendMessage(ChatColor.RED + "You don't have team !");
				return true;
			}
		}
		else{
			return false;
		}
	}
	
	
	
}
