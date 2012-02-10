package com.nitrikx.minecraft.bukkit.battlegrounds.commands.construction;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;

/**
 * This class interpret commands /bg construct [1/0] [Player]
 * @author NitriKx
 *
 */
public class ConstructionInterpreter {
	
	public static final String usage = "/bg " + BattlegroundsCommands.Construction + " [player] : Toggle gamemode for a player.";
	
	public static boolean interpret(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//If there are not any arg
    	if(args.length < 1){
    		sender.sendMessage(usage);
    		return true;
    	}
    	else if(sender instanceof Player){
    		
    		//Toggle player status
    		if(args[0].equalsIgnoreCase(BattlegroundsCommands.Construction)){ 
	    		ConstructionModeManager.toggle(sender, args);
	    	}
    		
    	}
    	else{
    		sender.sendMessage(ErrorMessage.ServerCanNotUse);
    	}
		return false;
	}
	
	
}
