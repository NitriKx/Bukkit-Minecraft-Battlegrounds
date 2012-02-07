package com.nitrikx.minecraft.bukkit.battlegrounds.tools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Tools {
	
	/**
	 * Check if a player is online.
	 * @param playerName The name of the player.
	 * @return True if player is online. False else.
	 */
	public static boolean isPlayerOnline(String playerName){
		
		boolean isOnline = true;
		
		Player other = (Bukkit.getServer().getPlayer(playerName));
        if (other == null) {
        	isOnline= false;
        }
		
		return isOnline;
	}
	
	
}
