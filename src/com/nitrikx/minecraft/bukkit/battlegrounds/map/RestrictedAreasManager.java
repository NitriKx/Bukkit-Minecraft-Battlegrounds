package com.nitrikx.minecraft.bukkit.battlegrounds.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Manage the restricted areas
 * @author NitriKx
 *
 */
public class RestrictedAreasManager {
	
	private List<Double> separatorPoint;
	
	private RestrictedAreasManager singleton;
	
	private RestrictedAreasManager(){
		this.setSeparatorPoint(new ArrayList<Double>());
	}
	
	public RestrictedAreasManager getInstance(){
		if(singleton == null){
			singleton = new RestrictedAreasManager();
		}
		
		return singleton;
	}

	public List<Double> getSeparatorPoint() {
		return separatorPoint;
	}

	public void setSeparatorPoint(List<Double> separatorPoint) {
		this.separatorPoint = separatorPoint;
	}
	
	
	
	
}
