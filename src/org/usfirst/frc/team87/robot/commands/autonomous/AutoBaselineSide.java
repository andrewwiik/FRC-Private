package org.usfirst.frc.team87.robot.commands.autonomous;

import org.usfirst.frc.team87.robot.RobotMap;
import org.usfirst.frc.team87.robot.commands.AutoDriveDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBaselineSide extends CommandGroup {

    public AutoBaselineSide() {

    	// The Robot moves 10 feet forward to cross the baseline
    	addSequential(new AutoDriveDistance(120.0, RobotMap.AUTO_MOVE_FAST_SPEED));
    	
    }
}