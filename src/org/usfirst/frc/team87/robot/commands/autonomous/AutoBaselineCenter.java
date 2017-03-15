//package org.usfirst.frc.team87.robot.commands.autonomous;
//
//import org.usfirst.frc.team87.robot.RobotMap;
//import org.usfirst.frc.team87.robot.commands.AutoDriveDistance;
//import org.usfirst.frc.team87.robot.commands.AutoTurn;
//
//import edu.wpi.first.wpilibj.command.CommandGroup;
//
//public class AutoBaselineCenter extends CommandGroup {
//
//    public AutoBaselineCenter(boolean goRight) {
//
//    	/* P.E.B wanted there to be autonomous mode where the robot just crosses
//    	 * the baseline, so this is exactly that. This CommandGroup is for if the
//    	 * robot is in the center starting position. The robot first needs to
//    	 * advance forward so it can turn.
//    	 */
//    	
//    	addSequential(new AutoDriveDistance(20.0, RobotMap.AUTO_MOVE_SPEED));
//    	
//    	
//    	/* Now the robot needs to turn so it doesn't hit the airship when trying 
//    	 * to cross the baseline.
//    	 */
//    	
//    	if (goRight) {
//    		addSequential(new AutoTurn(40.0, RobotMap.TURN_MED_SPEED));
//    	} else {
//    		addSequential(new AutoTurn(-40.0, RobotMap.TURN_MED_SPEED));
//    	}
//    	
//    	// Now the robot needs to actually cross the baseline
//    	addSequential(new AutoDriveDistance(180.0, RobotMap.AUTO_MOVE_SPEED));
//    }
//}