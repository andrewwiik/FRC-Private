package org.usfirst.frc.team87.robot.commands.autonomous;

import org.usfirst.frc.team87.robot.RobotMap;
import org.usfirst.frc.team87.robot.commands.AutoDriveDistance;
import org.usfirst.frc.team87.robot.commands.AutoTurn;
import org.usfirst.frc.team87.robot.commands.Wait;
import org.usfirst.frc.team87.robot.commands.WaitForGearRemoval;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRightRedAlliance extends CommandGroup {

    public AutoRightRedAlliance(boolean withBackup) {


    	// Move the robot approx 86 inches forward
    	addSequential(new AutoDriveDistance(86.632, RobotMap.AUTO_MOVE_SPEED));
    	
    	// Turn the robot 60 degrees to the left
    	addSequential(new AutoTurn(-60.0,RobotMap.TURN_SLOW_SPEED));
    	
    	/* Move the robot 36 inches forward at a slower speed to ensure smooth
    	 * gear placement.
    	 */
 
    	addSequential(new AutoDriveDistance(36.0, RobotMap.AUTO_MOVE_SLOW_SPEED));
    	
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
	    	
	    	addSequential(new AutoDriveDistance(-40.0, -1 * RobotMap.AUTO_MOVE_SPEED));
	    	
	    	/* The robot was going to start moving towards the gear dispenser
	    	 * on the opposite side of the field but it was decided by P.E.B that
	    	 * this action might cause a collision with another robot so it was
	    	 * decided that this plan of action should not take place for the time
	    	 * being.
	    	 */
	    	
	    	// addSequential(new AutoTurn(60, RobotMap.TURN_FAST_SPEED));
	    	// addSequential(new AutoDriveDistance(150.0, RobotMap.AUTO_MOVE_SPEED));
    	}
    }
}