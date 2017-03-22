package org.usfirst.frc.team87.robot.testing;

import org.usfirst.frc.team87.robot.RobotMap;
import org.usfirst.frc.team87.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestingCommandGroup extends CommandGroup {
	public TestingCommandGroup() {
		
		/* Wait for start button to be pressed before beginning 
		 * the first test
		 */
		
		addSequential(new WaitForStartButton());
		
		/* Drives the robot 3 feet forward as if it was in
		 * autonomous mode.
		 */
		
		addSequential(new AutoDriveDistance(36, RobotMap.AUTO_MOVE_SPEED, true));
		
		/* Wait for start button to be pressed before beginning 
		 * the backup test
		 */
		
		addSequential(new WaitForStartButton());
		
		/* Test the robot backing up 1 foot as if it was in autonomous 
		 * mode.
		 */
		
		addSequential(new AutoDriveDistance(-12, RobotMap.AUTO_MOVE_SPEED, true));
		
		/* Wait for start button to be pressed before beginning 
		 * the rotate right test
		 */
		
		addSequential(new WaitForStartButton());
		
		/* Rotate the robot 90 degrees to the left as if in autonomous
		 * mode.
		 */
		
		addSequential(new AutoTurn(90, RobotMap.TURN_MED_SPEED));
		
		/* Wait for the start button before doing the rotate right test as
		 * if in autonomous mode.
		 */
		
		addSequential(new WaitForStartButton());
		
		/* Rotate the robot 180 degrees to the right as if in automous
		 * mode.
		 */
		
		addSequential(new AutoTurn(-180, RobotMap.TURN_MED_SPEED));
		
		
	}
}
