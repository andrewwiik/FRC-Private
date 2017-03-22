package org.usfirst.frc.team87.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team87.robot.commands.autonomous.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AutonomousSelection {
	
	public NetworkTable dashboard;
	
	public AutonomousSelection() {
	}
	
	public void setupSelections() {
		if (dashboard == null) {
			dashboard = NetworkTable.getTable("SmartDashboard");
		}
		String[] choices = new String[] {"Left Gear Peg (backup after)", 
										 "Center Gear Peg (backup after)",
										 "Right Gear Peg (backup after)", 
										 "Left Gear Peg (don't backup)", 
										 "Center Gear Peg (don't backup)", 
										 "Right Gear Peg (don't backup)", 
										 "Cross Baseline"};
		
		dashboard.putStringArray("Auto List",choices);
	}
	
	public CommandGroup getCommandGroupForSelection() {
		
		// You can set the default here
		String selection = SmartDashboard.getString("Auto Selector", "Center Gear Peg (backup after)").toLowerCase();
		if (selection.contains("gear")) {
			if (selection.contains("left")) {
				return new AutoLeftGear(selection.contains("backup after"));
			} else if (selection.contains("right")) {
				return new AutoRightGear(selection.contains("backup after"));
			} else {
				return new AutoCenterGear(selection.contains("backup after"));
			}
		} else {
			return new AutoBaseline();
		}
	}
}
