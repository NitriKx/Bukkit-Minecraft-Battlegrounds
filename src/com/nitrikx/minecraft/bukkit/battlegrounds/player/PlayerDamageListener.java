package com.nitrikx.minecraft.bukkit.battlegrounds.player;

import java.util.logging.Logger;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;


public class PlayerDamageListener implements Listener {
	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger("Battlegrounds");
	
	@EventHandler
    public void playerDamage(EntityDamageEvent event) {
        
		
		if(event instanceof EntityDamageByEntityEvent){
			
			EntityDamageByEntityEvent eventCast = (EntityDamageByEntityEvent) event;
			
			Entity damager = eventCast.getDamager();
			Entity victim = eventCast.getEntity();
			
			//If damager and victim are Player
			if(damager instanceof Player && victim instanceof Player){
				Player playerDamager = (Player) damager;
				Player playerVictim = (Player) victim;
				
				//If allied cancel the event
				if(TeamsManager.getInstance().isAllied(playerDamager.getName(), playerVictim.getName())){
					event.setCancelled(true);
				}
			}
		}
    }
	
	
	
}
