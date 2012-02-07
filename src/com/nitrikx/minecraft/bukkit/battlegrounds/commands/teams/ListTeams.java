package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamStub;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class ListTeams {
	
	private static final Logger log = Logger.getLogger("Battlegrounds");
	
	public static void listAllTeams(CommandSender sender){
		if(TeamsManager.getInstance().getTeams() == null){
			log.severe(Battlegrounds.logSuffix + "Teams are not initialized !");
			sender.sendMessage(ErrorMessage.CommandFail);
		}
		else{
			//If no teams
			if(TeamsManager.getInstance().getTeams().size() == 0){
				sender.sendMessage(ChatColor.YELLOW + "No team found.");
			}
			else{
				for(TeamStub team : TeamsManager.getInstance().getTeams()){
					sender.sendMessage(ChatColor.GREEN + team.getName());
				}
			}
		}
	}
	
	
	
	
}
