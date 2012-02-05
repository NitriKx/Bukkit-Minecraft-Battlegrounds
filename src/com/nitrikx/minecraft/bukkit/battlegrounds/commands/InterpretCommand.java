package com.nitrikx.minecraft.bukkit.battlegrounds.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.plugin.Help;
import com.nitrikx.minecraft.bukkit.battlegrounds.commands.plugin.PluginInterpreter;
import com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams.TeamsInterpreter;

public class InterpretCommand {
	
	public static boolean interpret(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		
		//If there are not any arg
    	if(args.length == 0){
    		Help.sendHelp((Player) sender);
    		return true;
    	}
    	else{
    		
    		//
	    	//TEAMS COMMANDS
	    	//

	    	if(args[0].equalsIgnoreCase(BattlegroundsCommands.Team.suffix)){ 
	    		return TeamsInterpreter.interpret(sender, cmd, commandLabel, args);
	    	}
    		
    		
			//
    		//PLUGIN COMMANDS
    		//
    		
	    	else{
	    		return PluginInterpreter.interpret(sender, cmd, commandLabel, args);
	    	}
	    		
    	}
	}
	
	
}
