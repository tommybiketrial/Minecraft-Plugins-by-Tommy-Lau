package com.tommy.loopcheckpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class OnCommandControl implements TabExecutor {

	Player player;
	
	ArrayList<Location> CheckpointLocation;
	boolean Checkpoint[] = new boolean[1000];
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("LoopCheckPoints")||label.equalsIgnoreCase("LCP")) {
			
			player = (Player)sender;
			
			if(args.length < 2) {
				try {
					if(args[0].equalsIgnoreCase("Create")) {
					    createCheckpoint();
						player.sendMessage("Creating Checkpoint...");
						
					}else if(args[0].equalsIgnoreCase("ShowCheckpoints")) {
						
					}
					else {
						player.sendMessage(ChatColor.RED + "Don't enter any other things other than Create|Start|Loop");
						return false;
					}
				}catch(ArrayIndexOutOfBoundsException f) {
					player.sendMessage(ChatColor.RED + "Don't enter any other things other than Create|Start|Loop");
					return false;
				}
			}
			
			
			
			return true;
		}
			
		return false;
		//return super.onCommand(sender, command, label, args);
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args){
		
		if(args.length < 2) {
			//player.sendMessage("DEBUG");
			List<String> Hints = new ArrayList<String>();
			Hints = Arrays.asList("Create","ShowCheckpoints","Start","Loop"); //create calls the createCheckpoint(), Start calls the startRace(), Loop calls loopFunction(int Loops)
			return Hints;
		}else if(args.length >= 2) {
			List<String> Hints = new ArrayList<String>();
			Hints = Arrays.asList("");
			return Hints;
		}
		
		return null;
	}
	
	public void createCheckpoint() {
		Location RecentlyCreatedCheckpointLocation = player.getLocation();
		CheckpointLocation.add(RecentlyCreatedCheckpointLocation);
		player.sendMessage("You just created Checkpoint No." + CheckpointLocation.size());
		player.sendMessage("At location "+RecentlyCreatedCheckpointLocation.toString());
		
		player.getWorld().spawnEntity(player.getLocation(), EntityType.ENDER_CRYSTAL);
		Checkpoint[CheckpointLocation.size()-1] = false;
		
	}
	
	public void activateCheckpoint(int CheckpointNumber) {
		player.sendMessage("You just hit Checkpoint No." + CheckpointNumber);
		
		for(int i = 0; i < CheckpointLocation.size(); i++) {
			Checkpoint[i] = false;
		}
		Checkpoint[CheckpointNumber + 1] = true; //Checks the current Checkpoint, set all Checkpoints false except the next one.
	}
	
	public void checkIfPlayerHitsCheckpoint(Location PlayerLocation){

	   for(int i = 0; i < CheckpointLocation.size() ; i++){
	      if(CheckpointLocation.get(i) == PlayerLocation){
	         if(Checkpoint[i]==true) {
	        	 activateCheckpoint(i);
		         player.sendMessage("Checkpoint No."+i+" Checked!");
	         }else {
	        	 player.sendMessage("Wrong Checkpoint!");
	         }
	      }
	   }

	}
	
}


