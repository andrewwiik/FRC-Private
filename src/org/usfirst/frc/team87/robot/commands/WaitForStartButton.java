package org.usfirst.frc.team87.robot.commands;

import org.usfirst.frc.team87.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class WaitForStartButton extends Command {

	
	public boolean isFinished;
	public static Joystick gameController;
	
	public WaitForStartButton() {
		isFinished = false;
		gameController = new Joystick(RobotMap.GAMEPAD);
		DriverStation.reportWarning("Please press the 'Start' button on the gamepad to continue", false);
	}
	
	protected void execute() {
		if (gameController.getRawButton(RobotMap.REVERSE)) {
			isFinished = true;
		}
    }
	
	protected boolean isFinished() {
        return isFinished;
    }
	
	protected void interrupted() {
       
    }

}
