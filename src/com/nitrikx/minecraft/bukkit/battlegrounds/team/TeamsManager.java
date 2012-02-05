package com.nitrikx.minecraft.bukkit.battlegrounds.team;

import java.util.List;
import java.util.logging.Logger;

import com.nitrikx.minecraft.bukkit.battlegrounds.Battlegrounds;

/**
 * 
 * @author NitriKx
 *
 */
public class TeamsManager {
	
	private static final Logger log = Logger.getLogger("Battlegrounds");
	
	public static Battlegrounds plugin = Battlegrounds.plugin;
	
	private static TeamsManager singleton;
	
	private List<TeamStub> teams;
	
	
	private TeamsManager(){
		

	}
	
	/**
	 * Get an the instance of the TeamManager
	 * @return
	 */
	public static TeamsManager getInstance() {
        if (singleton == null) { // Premier appel
            singleton = new TeamsManager();
        }
        return singleton;
    }
	
	/**
	 * Add a player to the in-passed parameter team.
	 * @param teamName The name of the team.
	 * @param player The player to add.
	 */
	public void addPlayerToTeam(String teamName, String player){
		
		for(TeamStub team : this.teams){
			if(team.getName().equals(teamName)){
				
				team.addPlayer(player); 
				
			}
		}
		
	}
	
	/**
	 * Verify if a team name is available. 
	 * @param name The wanted team name.
	 * @return True if available, else false.
	 */
	public boolean isTeamNameAvailable(String name){
		
		boolean isAvailable = true;
		
		for(TeamStub team : this.teams){
			if(team.getName().equals(name)){
				isAvailable = false;
			}
			
		}
		
		return isAvailable;
		
	}

	public List<TeamStub> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamStub> teams) {
		this.teams = teams;
	}
	
	
}
