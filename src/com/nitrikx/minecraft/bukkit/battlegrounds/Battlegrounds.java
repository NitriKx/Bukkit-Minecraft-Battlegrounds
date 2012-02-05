package com.nitrikx.minecraft.bukkit.battlegrounds;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.InterpretCommand;

public class Battlegrounds extends JavaPlugin{
	
	public static Battlegrounds plugin;
	
	public Logger log = Logger.getLogger("Battlegrounds");
	
	/**
	 * 
	 */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onEnable(){
		
		Battlegrounds.plugin = this;
		
	}
	
	/**
	 * 
	 */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onDisable(){
		
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	return InterpretCommand.interpret(sender, cmd, commandLabel, args);
    }

}
