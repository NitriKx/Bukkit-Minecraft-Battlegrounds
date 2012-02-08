package com.nitrikx.minecraft.bukkit.battlegrounds;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.InterpretCommand;
import com.nitrikx.minecraft.bukkit.battlegrounds.config.TeamConfig;
import com.nitrikx.minecraft.bukkit.battlegrounds.player.PlayerDamageListener;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamStub;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class Battlegrounds extends JavaPlugin{
	
	public static Battlegrounds plugin;
	
	public static String logSuffix;
	
	public static TeamConfig teamConfig;
	
	public Logger log = Logger.getLogger("Battlegrounds");
	
	/**
	 * 
	 */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onEnable(){
		
		Battlegrounds.plugin = this;
		Battlegrounds.logSuffix = "[" + Battlegrounds.plugin.getDescription().getName() + "] ";
		
		//Register object for deserialization
		ConfigurationSerialization.registerClass(TeamStub.class);
		
		//Load teams
		log.info(Battlegrounds.logSuffix + "Loading teams...");
		teamConfig = new TeamConfig();
		
		TeamsManager.getInstance().setTeams(teamConfig.getTeams());
		
		this.registerListener();
		this.setServerPVP();
		
		log.info(Battlegrounds.logSuffix + Battlegrounds.plugin.getDescription().getName() + "is now loaded.");
	}
	
	/**
	 * 
	 */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onDisable(){
		
		log.info(Battlegrounds.logSuffix + "Saving teams...");
		teamConfig.saveTeams(TeamsManager.getInstance().getTeams());
		
		log.info(Battlegrounds.logSuffix + "Saving configurations files...");
		teamConfig.saveTeamConfig();
		
		log.info(Battlegrounds.logSuffix + Battlegrounds.plugin.getDescription().getName() + " is now unloaded.");
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	return InterpretCommand.interpret(sender, cmd, commandLabel, args);
    }
    
    /**
     * Register Listeners
     */
    private void registerListener(){
    	Battlegrounds.plugin.getServer().getPluginManager().registerEvents(new PlayerDamageListener(), plugin);
    }
    
    /**
     * Activate pvp on server
     * @return True if a pvp has been activated is a world.
     */
    private boolean setServerPVP(){
    	List<World> worlds = Battlegrounds.plugin.getServer().getWorlds();
    	
    	boolean pvpActivate = false;
    	
    	for(World world : worlds){
    		if(world.getPVP()){
    			world.setPVP(true);
    			pvpActivate = true;
    			log.info(Battlegrounds.logSuffix + String.format("Activate PVP in world : %s", world.getName()));
    		}
    	}
    	
    	return pvpActivate;
    }

}
