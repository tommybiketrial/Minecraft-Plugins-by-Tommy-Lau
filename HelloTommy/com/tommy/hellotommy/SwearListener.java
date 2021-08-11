package com.tommy.hellotommy;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SwearListener implements Listener {
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        Player p = event.getPlayer();
        
        
        if(event.getMessage().contains("fuck")) {
        	p.sendMessage(p.getName() + " don't fucking swear please.");
        	
        	TNTPrimed tnt = (TNTPrimed)p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
			tnt.setFuseTicks(0);
			
			//DEBUG 
			p.sendMessage("Still hear me?");
        	
        }else if(event.getMessage().contains("cunt")) {
        	p.sendMessage(p.getName() + " don't swear u cunt.");
			
			TNTPrimed tnt = (TNTPrimed)p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
			tnt.setFuseTicks(0);
        	
        }
        
    }
}
