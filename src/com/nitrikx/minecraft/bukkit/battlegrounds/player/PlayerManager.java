package com.nitrikx.minecraft.bukkit.battlegrounds.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;

public class PlayerManager {
	
	private static final Logger log = Logger.getLogger("Battleagrounds");
	
	private List<String> players;
	
	private static PlayerManager singleton;
	
	/**
	 * Create a PlayerManager object.
	 */
	private PlayerManager(){
		this.players = new ArrayList<String>();
	}
	
	/**
	 * Get the instance of the player manager.
	 * @return The Player Manager.
	 */
	public static PlayerManager getInstance(){
		
		if(singleton == null){
			singleton = new PlayerManager();
		}
		
		return singleton;
	}
	
	public boolean addPlayer(String playerName){
		
		boolean isAdded = false;
		
		//If player not already in the list
		if(!this.players.contains(playerName)){
			this.players.add(playerName);
			isAdded = true;
		}
		
		return isAdded;
	}

	public List<String> getPlayer() {
		return players;
	}

	public void setPlayer(List<String> player) {
		this.players = player;
	}
	
	
}
