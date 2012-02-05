package com.nitrikx.minecraft.bukkit.battlegrounds.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;

public class PlayerManager {
	
	private static final Logger log = Logger.getLogger("Battleagrounds");
	
	private List<Player> player;
	
	private HashMap<String, Player> playerByName;
	
	private static PlayerManager singleton;
	
	/**
	 * Create a PlayerManager object.
	 */
	private PlayerManager(){
		this.player = new ArrayList<Player>();
		this.playerByName = new HashMap<String, Player>();
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

	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}
	
	
}
