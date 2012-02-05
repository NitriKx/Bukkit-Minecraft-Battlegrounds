package com.nitrikx.minecraft.bukkit.battlegrounds.config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BackupManager {
	
	
//	//Create the configuration file
//    if (teamsConfigFile == null) {
//    	teamsConfigFile = new File(plugin.getDataFolder(), TeamsManager.fileName);
//    }
//    teamsConfig = YamlConfiguration.loadConfiguration(teamsConfigFile);
//    
//    //If file is not generated
//    if(teamsConfig.getString("Battlegrounds.version") == null){
//    	generateConfigFile();
//    }
    	
	
	public static final String fileName = "player.yml";
	private FileConfiguration teamsConfig = null;
	private File teamsConfigFile = null;
	
	/**
	 * 
	 */
	private void generateConfigFile(){
		this.teamsConfig.set("Teams", null);
		this.saveCustomConfig();
	}
	
	/**
	 * 
	 */
	public void saveCustomConfig() {
	    if (teamsConfig == null || teamsConfigFile == null) {
	    return;
	    }
	    try {
	    	teamsConfig.save(teamsConfigFile);
	    } catch (IOException ex) {
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + teamsConfigFile, ex);
	    }
	}
}
