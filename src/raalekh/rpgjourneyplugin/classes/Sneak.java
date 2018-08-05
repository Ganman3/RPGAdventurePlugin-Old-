package raalekh.rpgjourneyplugin.classes;

import java.util.UUID;

public class Sneak extends ServerClass {

	public Sneak(UUID playerid, String classname) {
		super(playerid, classname);
		classMap.put(playerid, "Sneak");
	}

}
