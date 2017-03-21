package org.usfirst.frc.team87.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team87.robot.commands.autonomous.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
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
		String selection = SmartDashboard.getString("Auto Selector", "Center Gear Peg (don't backup)").toLowerCase();
		if (selection.contains("gear")) {
			if (selection.contains("left")) {
				if (Alliance.Red.equals(DriverStation.getInstance().getAlliance())) {
					return new AutoLeftRedAlliance(selection.contains("backup after"));
				} else {
					return new AutoLeftBlueAlliance(selection.contains("backup after"));
				}
			} else if (selection.contains("right")) {
				if (Alliance.Red.equals(DriverStation.getInstance().getAlliance())) {
					return new AutoRightRedAlliance(selection.contains("backup after"));
				} else {
					return new AutoRightBlueAlliance(selection.contains("backup after"));
				}
			} else {
				return new CenterGearAuto(selection.contains("backup after"));
			}
		} else {
			return new AutoBaseline();
		}
	}
}
