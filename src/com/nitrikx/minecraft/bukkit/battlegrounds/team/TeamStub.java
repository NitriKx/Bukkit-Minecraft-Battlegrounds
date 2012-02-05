package com.nitrikx.minecraft.bukkit.battlegrounds.team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.nitrikx.minecraft.bukkit.battlegrounds.config.ConfigBG;

/**
 * This class is a team stub. Each instance represent a team of the battleground.
 * @author NitriKx
 *
 */
public class TeamStub {
	
	private static Logger log = Logger.getLogger("Battlegrounds");
	
	private String name;
	
	private List<String> members;
	
	private List<String> admins;
	
	private Date creationDate;
	
	private String creator;
	
	private TeamColors color;
	
	/**
	 * Create a team.
	 * @param name The name of the team.
	 * @param members A list of String, which is the list of members (including admins)
	 * @param admins A list of Player BG, which is the list of admins
	 * @param creationDate The creation date of the team
	 * @param creator The name of the player which create the team
	 * @param color The color of the team
	 */
	public TeamStub(String name, List<String> members, List<String> admins, Date creationDate, String creator, TeamColors color) {
		this.name = name;
		this.members = members;
		this.admins = admins;
		this.creationDate = creationDate;
		this.creator = creator;
		this.color = color;
	}
	
	/**
	 * Create a team at the current time.
	 * @param name The name of the team.
	 * @param members A list of Player BG, which is the list of members (including admins)
	 * @param admins A list of Player BG, which is the list of admins
	 * @param creator The name of the player which create the team
	 * @param color The color of the team
	 */
	public TeamStub(String name, List<String> members, List<String> admins, String creator, TeamColors color) {
		this.name = name;
		this.members = members;
		this.admins = admins;
		this.creationDate = new Date();
		this.creator = creator;
		this.color = color;
	}
	
	/**
	 * Create a team, just based on name
	 * @param name
	 */
	public TeamStub(String name){
		this.name = name;
		this.members = new ArrayList<String>();
		this.admins = new ArrayList<String>();
		this.creationDate = new Date();
		this.color = TeamColors.None;
	}
	
	/**
	 * Create an empty team.
	 */
	public TeamStub() {
		this.name = "";
		this.members = new ArrayList<String>();
		this.admins = new ArrayList<String>();
		this.creationDate = new Date();
		this.creator = "";
		this.color = TeamColors.None;
	}
	
	/**
	 * Add a player to the team
	 * @param player A PlayerBG object, which represent the player to add.
	 * @return True if player can be added
	 * @throws PlayerAlreadyInTeamException 
	 * @throws TeamFullException 
	 */
	public boolean addPlayer(String player){
		
		boolean canBeAdded = false;
		
		for(String playerBG : this.members){
			
			//if player already in team
			if(playerBG.equals(player)){
				canBeAdded = false;
			}
			
		}
		
		//If the player is not ever in the team
		if(canBeAdded && this.members.size() < ConfigBG.maxPlayerPerTeam){
			this.members.add(player);
		}
		
		//If team contains the player
		if(!canBeAdded){
			log.info(String.format("The team [%s] already contains the player [%s].", this.getName(), player));
		}
		
		//If the is full
		if(this.members.size() >= ConfigBG.maxPlayerPerTeam){
			log.info(String.format("The team [%s] is full (max : [%d]).", this.getName(), ConfigBG.maxPlayerPerTeam));
		}
		
		return canBeAdded;
	}
	
	/**
	 * Remove a player from the team.
	 * @param player A PlayerBG object, which represent the player to delete.
	 * @return True if the player is removed, False else.
	 */
	public boolean removePlayer(String player){
		
		boolean isDelete = true;
		
		//If the player is a member of the team
		if(this.members.contains(player)){
			
			//If the player is an admin
			if(admins.contains(player)){
				this.admins.remove(player);
			}
			
			//Remove from the members
			this.members.remove(player);
		}
		else{
			isDelete = false;
		}
		
		return isDelete;
	}
	
	/**
	 * 
	 * @param playerName
	 * @return
	 */
	public boolean setPlayerAdmin(String playerName){
		
		boolean isSetAdmin = true;
		
		if(this.admins.contains(playerName) || !this.members.contains(playerName)){
			isSetAdmin = false;
		}
		
		if(this.admins.contains(playerName)){
			log.info(String.format("[%s] is already an admin of team [%s] !", playerName, this.getName()));
		}
		
		if(!this.members.contains(playerName)){
			log.info(String.format("[%s] is no in the team [%s] !", playerName, this.getName()));
		}
		
		return isSetAdmin;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	public List<String> getAdmins() {
		return admins;
	}

	public void setAdmins(List<String> admins) {
		this.admins = admins;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public TeamColors getColor() {
		return color;
	}

	public void setColor(TeamColors color) {
		this.color = color;
	}
	
	
}
