package com.nitrikx.minecraft.bukkit.battlegrounds.team;

import java.util.ArrayList;
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
		this.teams = new ArrayList<TeamStub>();
		
		//Add fake values to test command
		this.teams.add(new TeamStub("test", new ArrayList<String>(), new ArrayList<String>(), "nitrikx", TeamColors.Blue));
		this.teams.add(new TeamStub("test2", new ArrayList<String>(), new ArrayList<String>(), "nitrikx", TeamColors.Blue));
		this.teams.add(new TeamStub("test3", new ArrayList<String>(), new ArrayList<String>(), "nitrikx", TeamColors.Blue));
		
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
	public boolean addPlayerToTeam(String teamName, String player){
		
		boolean added = false;
		
		for(TeamStub team : this.teams){
			if(team.getName().equals(teamName)){
				added = team.addPlayer(player);
			}
		}
		
		return added;
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
	
	public boolean createTeam(String name){
		return this.teams.add(new TeamStub(name));
	}

	public List<TeamStub> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamStub> teams) {
		this.teams = teams;
	}
	
	
}
