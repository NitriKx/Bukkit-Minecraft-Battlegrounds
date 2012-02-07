package com.nitrikx.minecraft.bukkit.battlegrounds;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.InterpretCommand;
import com.nitrikx.minecraft.bukkit.battlegrounds.config.TeamConfig;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamStub;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class Battlegrounds extends JavaPlugin{
	
	public static Battlegrounds plugin;
	
	public static TeamConfig teamConfig;
	
	public Logger log = Logger.getLogger("Battlegrounds");
	
	/**
	 * 
	 */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onEnable(){
		
		Battlegrounds.plugin = this;
		
		//register object for deserialization
		ConfigurationSerialization.registerClass(TeamStub.class);
		
		//Load teams
		log.info("Loading teams...");
		teamConfig = new TeamConfig();
		
		TeamsManager.getInstance().setTeams(teamConfig.getTeams());
		
		log.info(this.getDescription().getName() + " is loaded.");
	}
	
	/**
	 * 
	 */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onDisable(){
		
		log.info("Saving teams...");
		teamConfig.saveTeams(TeamsManager.getInstance().getTeams());
		
		log.info("Saving configurations files...");
		teamConfig.saveTeamConfig();
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	return InterpretCommand.interpret(sender, cmd, commandLabel, args);
    }

}
