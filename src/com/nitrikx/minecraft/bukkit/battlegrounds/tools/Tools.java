package com.nitrikx.minecraft.bukkit.battlegrounds.tools;

import org.bukkit.entity.Player;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;

public class Tools {
	
	public static boolean isPlayerOnline(String playerName){
		
		boolean isOnline = false;
		
		Player[] players = Battlegrounds.plugin.getServer().getOnlinePlayers();
		
		//Looking for the player
		for(Player player : players){
			if(player.getName().equalsIgnoreCase(playerName)){
				isOnline = true;
			}
		}
		
		return isOnline;
	}
	
	
}
