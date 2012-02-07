package com.nitrikx.minecraft.bukkit.battlegrounds.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;


public class PlayerDamageListener implements Listener {
	
	@EventHandler
    public void playerDamage(EntityDamageByEntityEvent event) {
        
		Entity damager = event.getDamager();
		Entity victim = event.getEntity();
		
		//If damager and victim are Player
		if(damager instanceof Player && victim instanceof Player){
			
			Player playerDamager = (Player) damager;
			Player playerVictim = (Player) damager;
			
			//If allied cancel the event
			if(TeamsManager.getInstance().isAllied(playerDamager.getName(), playerVictim.getName())){
				event.setCancelled(true);
			}
		}
		
    }
	
	
	
}
