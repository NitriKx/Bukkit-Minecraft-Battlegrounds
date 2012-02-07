package com.nitrikx.minecraft.bukkit.battlegrounds.commands;

/**
 * Hierarchical list of all BG commands.
 * @author NitriKx
 *
 */
public class BattlegroundsCommands {
	
	public static final String suffix = "bg";
	
	public static final String ListTeams = "listteams";
	
	public static final String Version = "version";
	
	public static final String Help = "help";
	
	public class Team{
		public static final String suffix = "team";
		
		public static final String List = "list";
		
		public static final String Help = "help";
		
		public static final String Create = "create";
		
		public static final String Delete = "delete";
		
		public static final String AddPlayer = "addplayer"; 
		
		public static final String RemovePlayer = "removeplayer"; 
	}
}

