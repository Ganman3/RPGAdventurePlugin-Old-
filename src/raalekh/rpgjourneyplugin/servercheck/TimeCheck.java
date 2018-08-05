package raalekh.rpgjourneyplugin.servercheck;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
//import org.bukkit.GameMode;
//import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import raalekh.rpgjourneyplugin.RPGAdventurePlugin;

public class TimeCheck extends BukkitRunnable {
	//---------------------------------------------------------------------
	//Time units to be converted into
	private int day;
	//Return and update in-game day
			public int getDay() {
				return day;
			}
			public void setDay(int day) {
				this.day = day;
			}
	private int week;
	//Return and update in-game week
			public int getWeek() {
				return week;
			}
			public void setWeek(int week) {
				this.week = week;
			}
	private int month;
	//Return and update in-game month
			public int getMonth() {
				return month;
			}
			public void setMonth(int month) {
				this.month = month;
			}
	private int year;
			//Return and update in-game year
					public int getYear() {
						return year;
					}
					public void setYear(int year) {
						this.year = year;
					}
	//Create instance of server plugin to reference
	private RPGAdventurePlugin rpg;
			public RPGAdventurePlugin getRPGAdventurePlugin(RPGAdventurePlugin rpg) {
				return rpg;
			}
			public RPGAdventurePlugin getRpg() {
				return rpg;
			}
			public void setRpg(RPGAdventurePlugin rpg) {
				this.rpg = rpg;
			}
	//Constructor to update time
	public TimeCheck(RPGAdventurePlugin rpg) {
		this.setRpg(rpg);
	}

	
	public List<UUID> checkPlayers = new ArrayList<UUID> ();
	
	@Override
	public void run() {
		//##Count increments to reflect player targeted; only targets one player
		/*int count = 0;
		if(count < 1) {
			//Iterate over and target one online player; check if player's in adventure mode, and double-check count is less than one, and check that they're in adventure world
		for(Player player:Bukkit.getOnlinePlayers()) if(player.getGameMode() == (GameMode.ADVENTURE) && count <1 && player.getWorld().getName().equals("Raalekh2")) {
			if(player.getGameMode() == (GameMode.ADVENTURE)) {
				//Stops player check- ensures only one person is targeted at a time
				count++;
				String world = player.getWorld().getName();
				//if(world.equals("Raalekh2")) { I don't think this check is necessary. */
					
						long time = Bukkit.getWorld("Raalekh2").getTime();
						
						long timeinzero = time % 100;
						//String timeString = String.valueOf(time);
						
						if(timeinzero == 0) {
							//Bukkit.getConsoleSender().sendMessage(timeString);
							if(time == 0) {
								day++;
								//System.out.println(day);
								if(day>9) {
									day = 0;
									week++;
								}
								if(week>4) {
									week=0;
									setMonth(getMonth() + 1);
								}
								if(month>10) {
									month=0;
									setYear(getYear() + 1);
								}
								
							}
						}
					}
				
	}

