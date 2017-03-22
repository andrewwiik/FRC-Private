package org.usfirst.frc.team87.robot.commands.autonomous;

import org.usfirst.frc.team87.robot.RobotMap;
import org.usfirst.frc.team87.robot.commands.AutoDriveDistance;
import org.usfirst.frc.team87.robot.commands.Wait;
import org.usfirst.frc.team87.robot.commands.WaitForGearRemoval;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCenterGear extends CommandGroup {
	public AutoCenterGear(boolean withBackup) {
		
		// Move the robot 50 inches forward
		addSequential(new AutoDriveDistance(50.0, RobotMap.AUTO_MOVE_SPEED, false)); // Move toward the pin
    	
		// Move the robot 28 inches forward at a slower speed
		addSequential(new AutoDriveDistance(28.0, RobotMap.AUTO_MOVE_MEDIUM_SPEED, false));
    	
		/* Move the robot 8 inches forward at a really slow speed to
		 * ensure smooth gear placement.
		 */
		
		addSequential(new AutoDriveDistance(8.0, RobotMap.AUTO_MOVE_SLOW_SPEED, true)); // Going Really slow and overshooting the distance a bit
    	
		if (withBackup) {
		

	    	/* The robot waits for the ultrasonic sensor to detect that
	    	 * the gear has been removed from its "cereal box" holder
	    	 */
			
	    	addSequential(new WaitForGearRemoval());
	    	
	    	/* Per P.E.B's decision that the robot should wait 3 seconds
	    	 * after it has detected the gear is removed before deciding
	    	 * to move again. This code is assuming that the ultrasonic
	    	 * sensor is functioning properly.
	    	 */
	    	
	    	addSequential(new Wait(3));
	    	
	    	/*
	    	 * We start moving away from the gear holder peg.
	    	 */
	    	
	      	addSequential(new AutoDriveDistance(-35.0, -1 * RobotMap.AUTO_MOVE_SPEED, true)); // Move away from the pin
	    	
	      	/* The robot was going to start moving towards the gear dispenser
	    	 * on the opposite side of the field but it was decided by P.E.B that
	    	 * this action might cause a collision with another robot so it was
	    	 * decided that this plan of action should not take place for the time
	    	 * being.
	    	 */
	      	
	      	// addSequential(new AutoTurn(-60.0,RobotMap.TURN_SLOW_SPEED)); // Turn towards the auto zone line
	    	// addSequential(new AutoDriveDistance(93.0, RobotMap.AUTO_MOVE_SPEED)); // Move far enough to break the plane
		}
	}
}
