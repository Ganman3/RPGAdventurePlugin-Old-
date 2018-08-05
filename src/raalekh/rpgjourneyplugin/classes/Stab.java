package raalekh.rpgjourneyplugin.classes;

import java.util.UUID;

public class Stab extends ServerClass {

	public Stab(UUID playerid, String classname) {
		super(playerid, classname);
		classMap.put(playerid,"Stab");
	}
	
}
