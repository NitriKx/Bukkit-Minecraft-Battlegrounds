package com.nitrikx.minecraft.bukkit.battlegrounds.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;
import com.nitrikx.minecraft.bukkit.battlegrounds.commands.plugin.Help;
import com.nitrikx.minecraft.bukkit.battlegrounds.commands.plugin.Version;
import com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.ListTeams;

public class InterpretCommand {
	
	public static boolean interpret(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		
		//If there are not any arg
    	if(args.length == 0){
    		Help.sendHelp((Player) sender);
    		return true;
    	}
    	else{
			//
    		//PLUGIN COMMANDS
    		//
    		
	    	if(args[0].equalsIgnoreCase(BattlegroundsCommands.Version)){
	    		Version.sendVersion((Player) sender, Battlegrounds.plugin);
	    		return true;
	    	}
	    	else if(args[0].equalsIgnoreCase(BattlegroundsCommands.Help)){
	    		Help.sendHelp((Player) sender);
	    		return true;
	    	}
	    	
	    	
	    	//
	    	//TEAMS COMMANDS
	    	//

	    	else if(args[0].equalsIgnoreCase(BattlegroundsCommands.ListTeams)){ 
	    		ListTeams.listAllTeams((Player) sender);
	    		return true;
	    	}
	    	
	    	
    	}
		//If this has happened the function will break and return true. if this hasn't happened the a value of false will be returned.
		return false;
	}
	
	
}
