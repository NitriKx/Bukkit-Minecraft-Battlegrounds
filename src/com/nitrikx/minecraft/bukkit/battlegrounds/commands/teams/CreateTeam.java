package com.nitrikx.minecraft.bukkit.battlegrounds.commands.teams;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.nitrikx.minecraft.bukkit.battlegrounds.commands.BattlegroundsCommands;
import com.nitrikx.minecraft.bukkit.battlegrounds.config.ConfigBG;
import com.nitrikx.minecraft.bukkit.battlegrounds.errors.ErrorMessage;
import com.nitrikx.minecraft.bukkit.battlegrounds.team.TeamsManager;

public class CreateTeam {
	
	public static final String usage = ChatColor.YELLOW + "/" + BattlegroundsCommands.suffix + " " 
			+ BattlegroundsCommands.Team.suffix + " " + BattlegroundsCommands.Team.Create
			+ " <teamname>"; 
	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger("Battlegrounds");
	
	public static void create(CommandSender sender, String [] args){
		
		if(sender.hasPermission("battlegrounds.team.create")){
			//If missing parameters
			if(args.length < 2+1){
				sender.sendMessage(ErrorMessage.MissingParameters);
				sender.sendMessage(ChatColor.YELLOW + usage);
			}
			else if(args.length > 2+1+1){
				sender.sendMessage(ErrorMessage.TooManyParameters);
				sender.sendMessage(ChatColor.YELLOW + usage);
			}
			else{
				String name = args[2];
				
				//If name is too long of too short
				if(name.length() < ConfigBG.minTeamNameLength || name.length() > ConfigBG.maxTeamNameLength){
					sender.sendMessage(ErrorMessage.InvalidNameLength);
				}
				else if(TeamsManager.getInstance().isTeamNameAvailable(name)){
					TeamsManager.getInstance().createTeam(name);
					sender.sendMessage(ChatColor.GREEN + String.format("Team [%s] created.", name));
				}
				else{
					sender.sendMessage(ChatColor.YELLOW + "This team already exist.");
				}
			}
		}
		else{
			sender.sendMessage(ErrorMessage.NotAllowed);
		}
		
		
	}
	
}
