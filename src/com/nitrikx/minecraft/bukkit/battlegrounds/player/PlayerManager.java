package com.nitrikx.minecraft.bukkit.battlegrounds.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class PlayerManager {
	
	private static final Logger log = Logger.getLogger("Battleagrounds");
	
	private List<PlayerBG> player;
	
	private HashMap<String, PlayerBG> playerByName;
	
	private static PlayerManager singleton;
	
	/**
	 * Create a PlayerManager object.
	 */
	private PlayerManager(){
		this.player = new ArrayList<PlayerBG>();
		this.playerByName = new HashMap<String, PlayerBG>();
		
		this.playerByName.put("Server", new PlayerBG("Server"));
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

	public List<PlayerBG> getPlayer() {
		return player;
	}

	public void setPlayer(List<PlayerBG> player) {
		this.player = player;
	}
	
	
}
