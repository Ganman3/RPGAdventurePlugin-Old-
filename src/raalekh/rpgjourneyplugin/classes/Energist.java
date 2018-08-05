package raalekh.rpgjourneyplugin.classes;

import java.util.UUID;

public class Energist extends ServerClass {

	public Energist(UUID playerid, String classname) {
		super(playerid, classname);
		classMap.put(playerid, "Energist");
	}
	
}
