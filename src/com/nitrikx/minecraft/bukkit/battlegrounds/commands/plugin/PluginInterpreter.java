package com.nitrikx.minecraft.bukkit.battlegrounds.commands.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;
import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;

public class PluginInterpreter {
	
	public static boolean interpret(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(args[0].equalsIgnoreCase(BattlegroundsCommands.Version)){
    		Version.sendVersion((Player) sender, Battlegrounds.plugin);
    		return true;
    	}
    	else if(args[0].equalsIgnoreCase(BattlegroundsCommands.Help)){
    		Help.sendHelp((Player) sender);
    		return true;
    	}

		return false;
	}
	
	
}
