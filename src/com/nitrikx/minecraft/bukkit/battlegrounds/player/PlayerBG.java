package com.nitrikx.minecraft.bukkit.battlegrounds.player;

public class PlayerBG {
	
	private String name;
	
	private String teamName;
	
	private boolean isTeamAdmin;
	
	/**
	 * Create a player.
	 */
	public PlayerBG(String playerName, String teamName){
		this.name = playerName;
		this.teamName = teamName;
	}
	
	/**
	 * Create a whithout team.
	 * @param playerName The name of the player.
	 */
	public PlayerBG(String playerName){
		this.name = playerName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isTeamAdmin() {
		return isTeamAdmin;
	}

	public void setTeamAdmin(boolean isTeamAdmin) {
		this.isTeamAdmin = isTeamAdmin;
	}
	
	
}
