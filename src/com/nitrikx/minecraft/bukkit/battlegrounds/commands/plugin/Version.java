package com.nitrikx.minecraft.bukkit.battlegrounds.commands.plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;

public class Version {
	
	public static void sendVersion(Player sender, Battlegrounds plugin){
		sender.sendMessage("Battlegrounds version : " + ChatColor.GREEN + plugin.getDescription().getVersion());
	}
	
}
