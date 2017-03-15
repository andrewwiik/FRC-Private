package org.usfirst.frc.team87.robot.commands.autonomous;

import org.usfirst.frc.team87.robot.RobotMap;
import org.usfirst.frc.team87.robot.commands.AutoDriveDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBaseline extends CommandGroup {

    public AutoBaseline() {

    	/* P.E.B wanted there to be autonomous mode where the robot just crosses
    	 * the baseline, so this is exactly that. This CommandGroup is for if the
    	 * robot is in the left or right starting position. The robot will go 10
    	 * feet forward.
    	 */
    	
    	addSequential(new AutoDriveDistance(180, RobotMap.AUTO_MOVE_FAST_SPEED));
    	
    }
}