package com.tommy.loopcheckpoints;

import org.bukkit.plugin.java.JavaPlugin;


//Driver Program
public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("LCP").setExecutor(new OnCommandControl());
		getCommand("LoopCheckPoints").setExecutor(new OnCommandControl());
	}
	
	
	
	@Override
	public void onDisable() {
		
	}
	
}

