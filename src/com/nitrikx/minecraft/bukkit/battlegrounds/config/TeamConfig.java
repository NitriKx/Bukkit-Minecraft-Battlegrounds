package com.nitrikx.minecraft.bukkit.battlegrounds.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamStub;

public class TeamConfig {
	
	private static final Logger log = Logger.getLogger("Battlegrounds");
	
	public static final String fileName = "teams.yml";
	
	public static final String path = "plugins"  + File.separator + Battlegrounds.plugin.getDescription().getName() + File.separator;
	
	private YamlConfiguration teamsConfig = null;
	
	private File teamsConfigFile = null;
	
	private List<TeamStub> teams;
	
	
	public TeamConfig(){
		
		teamsConfigFile = new File(path + fileName);
		
		teamsConfig = YamlConfiguration.loadConfiguration(teamsConfigFile);
		
		if(!teamsConfigFile.exists()){
			log.info(Battlegrounds.logSuffix + "No team configuration file. Creating new one.");
			this.setDefault();
		}
		
		teams = new ArrayList<TeamStub>();
		
		this.setTeams(this.loadTeams());
	}
	
	/**
	 * Add configuration default values.
	 */
	private void setDefault(){
		this.teamsConfig.addDefault("Teams", new ArrayList<TeamStub>());
	}
	
	/**
	 * Set teams in the configuration file.
	 * @param teams A list of TeamStub
	 */
	public boolean saveTeams(List<TeamStub> teams){
		
		boolean isSave = false;
		
		if(teams != null){
			if(teams.size() > 0){
				this.teams = teams;
				isSave = true;
			}
		}
		
		return isSave;
	}

	/**
	 * Get the teams from configuration file
	 * @return A list of TeamStub
	 */
	@SuppressWarnings("unchecked")
	public List<TeamStub> loadTeams(){
		Object teamsObject = this.teamsConfig.get("Teams", new ArrayList<TeamStub>());

		return (List<TeamStub>) teamsObject;
	}
	
	/**
	 * Write the team config file.
	 */
	public boolean saveTeamConfig() {
	    if (teamsConfig == null || teamsConfigFile == null) {
	    	return false;
	    }
	    try {
	    	this.teamsConfig.set("Teams", this.teams);
	    	
	    	//Save the file
	    	teamsConfig.save(teamsConfigFile);
	    	return true;
	    	
	    } catch (IOException ex) {
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, Battlegrounds.logSuffix + "Could not save config to " + teamsConfigFile, ex);
	    }
	    
	    return false;
	}

	public FileConfiguration getTeamsConfig() {
		return teamsConfig;
	}

	public void setTeamsConfig(YamlConfiguration teamsConfig) {
		this.teamsConfig = teamsConfig;
	}

	public File getTeamsConfigFile() {
		return teamsConfigFile;
	}

	public void setTeamsConfigFile(File teamsConfigFile) {
		this.teamsConfigFile = teamsConfigFile;
	}

	public List<TeamStub> getTeams() {
		return teams;
	}

	private void setTeams(List<TeamStub> teams) {
		this.teams = teams;
	}

	public static String getFilename() {
		return fileName;
	}
}
