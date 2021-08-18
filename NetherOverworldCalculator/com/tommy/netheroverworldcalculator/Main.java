package com.tommy.netheroverworldcalculator;

import org.bukkit.plugin.java.JavaPlugin;


//Driver Program
public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getCommand("NetherOverworldCalculator").setExecutor(new OnCommandControl());
	}
	
	
	
	@Override
	public void onDisable() {
		
	}
	
}
