package com.nitrikx.minecraft.bukkit.battlegrounds.team;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;


/**
 * The color of teams.
 * @author NitriKx
 *
 */
public class TeamColors implements ConfigurationSerializable{
		public static final String Blue = "Bleu";
		public static final String Red = "Red";
		public static final String Yellow = "Yellow";
		public static final String Green = "Green";
		public static final String Gold = "Gold";
		public static final String Silver = "Silver";
		public static final String None = "None";

		@Override
		public Map<String, Object> serialize() {
			Map<String, Object> map = new HashMap<String, Object>();
			
			/*map.put("Blue", TeamColors.Blue);
			map.put("Red", TeamColors.Red);
			map.put("Yellow", TeamColors.Yellow);
			map.put("Green", TeamColors.Green);
			map.put("Gold", TeamColors.Gold);
			map.put("Silver", TeamColors.Silver);
			map.put("None", TeamColors.None);*/
			
			return map;
		}
		
		
}
