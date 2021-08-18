package com.tommy.netheroverworldcalculator;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


//Driver Program
public class Main extends JavaPlugin implements TabCompleter{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("NetherOverworldCalculator")||label.equalsIgnoreCase("noc")) {
			Player player = (Player)sender;
			
			if(args.length < 2) {
				try {
					if(args[0].equalsIgnoreCase("auto")) {
					    int InputX = (int)player.getLocation().getX();
					    int InputY = (int)player.getLocation().getY();
					    int InputZ = (int)player.getLocation().getZ();
					    
					    if(player.getWorld().getEnvironment().toString() == "NORMAL") {
					    	InputX = InputX / 8;
					    	InputY = InputY / 8;
					    	InputZ = InputZ / 8;
					    	player.sendMessage("Your corresponding coordinate for the Nether is:");
					    	player.sendMessage("X: " + String.valueOf(InputX) + "  Y: " + String.valueOf(InputY) + "  Z: " + String.valueOf(InputZ));
					    	return true;
					    }else if(player.getWorld().getEnvironment().toString() == "NETHER"){
					    	InputX = InputX * 8;
					    	InputY = InputY * 8;
					    	InputZ = InputZ * 8;
					    	player.sendMessage("Your corresponding coordinate for the Overworld is:");
					    	player.sendMessage("X: " + String.valueOf(InputX) + "  Y: " + String.valueOf(InputY) + "  Z: " + String.valueOf(InputZ));
					    	return true;
					    }
					}
				}catch(ArrayIndexOutOfBoundsException f) {
					player.sendMessage(ChatColor.RED + "Don't enter any other things other than the dimension you are currently in, and your X Z coordinates.");
					return false;
				}
					
			}
			//else if (args.length < 2) {
			//	player.sendMessage(ChatColor.RED + "Don't enter any other things other than the dimension you are currently in, and your X Z coordinates.");
			//	return false;
			//}
			
			String Dimension = args[0];
			int InputX;
			int InputZ;
			try {
				InputX = Integer.parseInt(args[1]);
				InputZ = Integer.parseInt(args[2]);
			}catch(NumberFormatException f){
				player.sendMessage(ChatColor.RED + "Don't enter any other things other than the dimension you are currently in, and your X Z coordinates.");
				return false;
			}
			if(Dimension.equalsIgnoreCase("overworld")) {
				InputX = InputX / 8;
				InputZ = InputZ / 8;
			}
			else if(Dimension.equalsIgnoreCase("nether")) {
				InputX = InputX * 8;
				InputZ = InputZ * 8;
			}
			else {
				player.sendMessage(ChatColor.RED + "Don't enter any other things other than the dimension you are currently in, and your X Z coordinates.");
				return false;
			}
			
			String OutputX = String.valueOf(InputX);
			String OutputZ = String.valueOf(InputZ);
			
			player.sendMessage("X: " + OutputX + "  Z: " + OutputZ);
			
			return true;
		}
		return super.onCommand(sender, command, label, args);
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args){
		
		
		
		return null;
	}
	
}
