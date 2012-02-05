package com.nitrikx.minecraft.bukkit.battlegrounds.errors;

import org.bukkit.ChatColor;

public class ErrorMessage {
	
	public static final String CommandFail = ChatColor.RED + "A problem occuring during execution of this command. Report to the server log for more informations.";
	
	public static final String MissingParameters = ChatColor.RED + "Missing parameters.";
	
	public static final String TooManyParameters = ChatColor.RED + "Too many parameters.";
	
	public static final String OfflinePlayer = ChatColor.RED + "Can't do this on a offline player.";
	
	public static final String NotAllowed = ChatColor.RED + "You are not allowed to do this.";
	
}
