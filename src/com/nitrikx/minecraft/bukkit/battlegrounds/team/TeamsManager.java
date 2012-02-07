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
	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger("Battlegrounds");
	
	public static Battlegrounds plugin = Battlegrounds.plugin;
	
	private static TeamsManager singleton;
	
	private List<TeamStub> teams;
	
	
	private TeamsManager(){
		this.teams = new ArrayList<TeamStub>();
		
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
	public boolean addPlayerToTeam(String playerName, String teamName){
		boolean added = false;
		
		for(TeamStub team : this.teams){
			if(team.getName().equals(teamName)){
				added = team.addPlayer(playerName);
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
	
	/**
	 * Verify if a team exist.
	 * @param name The name of the team.
	 * @return True if team exist. False else.
	 */
	public boolean isTeamExist(String name){
		return !isTeamNameAvailable(name);
	}
	
	/**
	 * Check if a player is admin of a team
	 * @param playerName The name of the player
	 * @param teamName The name of the team
	 * @return True if admin, false else
	 */
	public boolean isAdminOf(String playerName, String teamName){
		boolean isAdmin = false;
		
		for(TeamStub team : this.teams){
			if(team.getName().equals(teamName) && team.hasAdmin(playerName)){
				isAdmin = true;
			}
		}
		
		return isAdmin;
	}
	
	/**
	 * Check is player 1 is admin of player 2 (player can be an admin).
	 * @param playerName1 The name of the player 1
	 * @param playerName2 The name of the player 2
	 * @return True if player1 is an admin of player2. False else.
	 */
	public boolean isAdminOfPlayer(String playerName1, String playerName2){
		boolean isAdmin = false;
		
		for(TeamStub team : this.teams){
			if(team.hasAdmin(playerName1) && team.hasPlayer(playerName2)){
				isAdmin = true;
			}
		}
		
		return isAdmin;
	}
	
	/**
	 * Search for the team of a player.
	 * @param playerName The player name.
	 * @return The team name if found. Empty string else.
	 */
	public String retrievePlayerTeam(String playerName){
		String teamName = "";
		
		for(TeamStub team : this.teams){
			if(team.hasPlayer(playerName)){
				teamName = team.getName();
			}
		}
		
		return teamName;
		
	}
	
	/**
	 * Remove a player from his team.
	 * @param playerName The name of the player.
	 * @param teamName The name of the player team.
	 * @return True if player removed from a team. False else.
	 */
	public boolean removePlayerFromTeam(String playerName){
		boolean isRemoved = false;
		
		for(TeamStub team : this.teams){
			if(team.hasPlayer(playerName)){
				team.removePlayer(playerName);
				isRemoved = true;
			}
		}
		
		return isRemoved;
	}
	
	/**
	 * Create a team.
	 * @param name The name of the team.
	 * @return True if team can be create. Else false.
	 */
	public boolean createTeam(String name){
		return this.teams.add(new TeamStub(name));
	}
	
	/**
	 * Delete a team.
	 * @param name The team name.
	 * @return True if team has been deleted, false else.
	 */
	public boolean deleteTeam(String name){
		boolean isDelete = false;
		
		for(int i = 0 ; i < this.teams.size() ; i++){
			if(teams.get(i).getName().equals(name)){
				this.teams.remove(i);
				isDelete =  true;
			}
		}
		
		return isDelete;
	}

	public List<TeamStub> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamStub> teams) {
		this.teams = teams;
	}
	
	
}
