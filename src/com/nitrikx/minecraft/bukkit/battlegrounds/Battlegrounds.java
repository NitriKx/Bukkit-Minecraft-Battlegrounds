package com.nitrikx.minecraft.bukkit.battlegrounds;

import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

public class Battlegrounds extends JavaPlugin{
	
	public static Battlegrounds plugin;
	public Logger log = Logger.getLogger("Minecraft");
	public ServerChatPlayerListener playerListener = new ServerChatPlayerListener(this);
	
	/**
	 * 
	 */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onEnable(){
		
		//If configuration file is not generated
		if(plugin.getConfig().get("Battlegrounds.version") == null){
			this.generateConfigFile();
		}
		
		
		this.getServer().getPluginManager().registerEvents(this.playerListener, this);
		log.info(this.getDescription().getName() + " is loaded.");
	}
	
	/**
	 * 
	 */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onDisable(){
		//Save plugin config
		plugin.saveConfig();
		
		//Log
		this.log.info(this.getDescription().getName() + " is now disable.");
	}
	
	
	private void generateConfigFile(){
		String path = "Battlegrounds";
		
		plugin.getConfig().set(path + ".version", "Alpha");
		plugin.getConfig().set(path + ".teams.playerPerTeam", "5");
		
		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
	}
		
}
