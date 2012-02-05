package com.nitrikx.minecraft.bukkit.battlegrounds.commands.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;

public class Version {
	
	public static void sendVersion(CommandSender sender, Battlegrounds plugin){
		sender.sendMessage("Battlegrounds version : " + ChatColor.GREEN + plugin.getDescription().getVersion());
	}
	
}
