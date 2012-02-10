package com.nitrikx.minecraft.bukkit.battlegrounds.commands.construction;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.player.PlayerManager;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class ConstructionModeManager {
	
	public static void toggle(CommandSender sender, String [] args){
		
		if(args.length < 1){
			sender.sendMessage(ErrorMessage.MissingParameters);
		}
		else{
			
			String player = sender.getName();
			
			//If a player is designed
			if(args.length >= 2){
				
				player = args[1];
				
				//If player designed is in a team
				if(!TeamsManager.getInstance().retrievePlayerTeam(player).equals("")){
					
					//If sender is admin of designed player
					if(TeamsManager.getInstance().isAdminOfPlayer(sender.getName(), player) || sender.hasPermission("battlegrounds.team.setconstructor")){
						
						//If now constructor
						if(PlayerManager.getInstance().toggleConstructor(player)){
							
							try{
								Bukkit.getServer().getPlayer(player).sendMessage(ChatColor.YELLOW + "You enter into the constructor mode.");
							}
							catch(NullPointerException e) {}
							
							sender.sendMessage(ChatColor.GREEN + String.format("Player [%s] enter in the constructor mode.", player));
							
						}else{
						
							try{
								Bukkit.getServer().getPlayer(player).sendMessage(ChatColor.YELLOW + "You leave the constructor mode.");
							}
							catch(NullPointerException e) {}
							
							sender.sendMessage(ChatColor.GREEN + String.format("Player [%s] leaves the constructor mode.", player));
						}
						
					}
					else{
						sender.sendMessage(ErrorMessage.NotAllowed);
					}
				}
				else{
					sender.sendMessage(ChatColor.RED + String.format("Player [%s] has no team.", player));
				}
				
			}
			else{
				
				//If player is in a team
				if(!TeamsManager.getInstance().retrievePlayerTeam(sender.getName()).equals("")){
					
				}
				
				
			}
			
			
			
			
		}
		
		
	}
	
	
	
}
