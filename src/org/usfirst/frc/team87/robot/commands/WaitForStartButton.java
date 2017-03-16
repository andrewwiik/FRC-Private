package org.usfirst.frc.team87.robot.commands;

import org.usfirst.frc.team87.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class WaitForStartButton extends Command {

	
	public boolean isFinished;
	
	public WaitForStartButton() {
		isFinished = false;
		DriverStation.reportWarning("Please press the 'Start' button on the gamepad to continue", false);
	}
	
	protected void execute() {
		if (RobotMap.gamepad.getRawButton(RobotMap.REVERSE)) {
			isFinished = true;
		}
    }
	
	protected boolean isFinished() {
        return isFinished;
    }
	
	protected void interrupted() {
       
    }

}
