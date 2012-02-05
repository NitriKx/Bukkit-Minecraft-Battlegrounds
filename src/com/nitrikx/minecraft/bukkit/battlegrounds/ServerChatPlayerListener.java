package com.nitrikx.minecraft.bukkit.battlegrounds;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ServerChatPlayerListener implements Listener{
	public static Battlegrounds plugin;
	
	
	
	public ServerChatPlayerListener(Battlegrounds instance){
		plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerChatEvent(PlayerChatEvent chat){
		Player p = chat.getPlayer();
		String message = chat.getMessage().toLowerCase();
		
		if(message.contains("hi") && message.contains("server")){
			p.sendMessage(ChatColor.RED + "[SERVER] " + ChatColor.WHITE + "Hello " + p.getName());
			
		}
		
	}
}
