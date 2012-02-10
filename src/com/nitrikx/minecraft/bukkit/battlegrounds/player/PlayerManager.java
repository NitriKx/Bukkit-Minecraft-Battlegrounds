package com.nitrikx.minecraft.bukkit.battlegrounds.player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PlayerManager {
	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger("Battlegrounds");
	
	private List<String> players;
	
	private List<String> isConstructor;
	
	private static PlayerManager singleton;
	
	/**
	 * Create a PlayerManager object.
	 */
	private PlayerManager(){
		this.players = new ArrayList<String>();
		this.isConstructor = new ArrayList<String>();
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
	
	public List<String> getPlayerInfos(String playerName){
		
		
		return null;
	}
	
	/**
	 * Set a player as constructor.
	 * @param playerName The name of the player
	 * @return True if player is now a constructor, False else.
	 */
	public boolean toggleConstructor(String playerName){
		
		//If already constructor, remove him
		if(this.isConstructor.contains(playerName.toLowerCase())){
			this.isConstructor.remove(playerName.toLowerCase());
			return false;
		}
		else{
			this.isConstructor.add(playerName.toLowerCase());
			return true;
		}
		
	}

	public List<String> getPlayer() {
		return players;
	}

	public void setPlayer(List<String> player) {
		this.players = player;
	}

	public void setIsConstructor(List<String> isConstructor) {
		this.isConstructor = isConstructor;
	}
	
	
}
