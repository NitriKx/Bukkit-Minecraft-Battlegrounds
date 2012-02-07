package com.nitrikx.minecraft.bukkit.battlegrounds.commands;

/**
 * Hierarchical list of all Battlegrounds commands.
 * @author NitriKx
 *
 */
public class BattlegroundsCommands {
	
	public static final String suffix = "bg";
	
	public static final String Version = "version";
	
	public static final String Help = "help";
	
	public class Team{
		public static final String suffix = "team";
		
		public static final String List = "list";
		
		public static final String Help = "help";
		
		public static final String Create = "create";
		
		public static final String Delete = "delete";
		
		public class Player{
			public static final String suffix = "player";
			
			public static final String Add = "add"; 
			
			public static final String Remove = "remove"; 
		}
		
		
	}
}

