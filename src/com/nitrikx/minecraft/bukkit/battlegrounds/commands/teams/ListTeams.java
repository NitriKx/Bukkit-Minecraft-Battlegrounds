package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamStub;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class ListTeams {
	
	public static void listAllTeams(Player sender){
		
		//If no teams
		if(TeamsManager.getInstance().getTeams().size() == 0){
			sender.sendMessage(ChatColor.YELLOW + "No team found");
		}
		else{
			sender.sendMessage("Teams are : ");
			
			for(TeamStub team : TeamsManager.getInstance().getTeams()){
				sender.sendMessage(ChatColor.GREEN + team.getName());
			}
		}
	}
	
	
	
	
}
