package raalekh.rpgjourneyplugin.classes;

import java.util.UUID;

//import java.util.UUID;

public class Wizard extends ServerClass {

	public Wizard(UUID playerid, String classname) {
		super(playerid, classname);
		classMap.put(playerid,"Wizard");
	}


	

	
}
