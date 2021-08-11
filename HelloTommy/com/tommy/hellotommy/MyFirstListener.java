package com.tommy.hellotommy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyFirstListener implements Listener {
	
	//constructor
	public MyFirstListener(Main plugin) {
		
	}
	
	//EventHandler
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage("WELCOME TOMMY!");
	}
	
}
