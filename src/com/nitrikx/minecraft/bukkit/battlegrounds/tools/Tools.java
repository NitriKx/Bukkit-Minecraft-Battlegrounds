package com.nitrikx.minecraft.bukkit.battlegrounds.tools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Tools {
	
	public static boolean isPlayerOnline(String playerName){
		
		boolean isOnline = true;
		
		Player other = (Bukkit.getServer().getPlayer(playerName));
        if (other == null) {
        	isOnline= false;
        }
		
		return isOnline;
	}
	
	
}
