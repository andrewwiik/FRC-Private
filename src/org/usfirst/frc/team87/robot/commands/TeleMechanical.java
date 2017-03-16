package org.usfirst.frc.team87.robot.commands;

import org.usfirst.frc.team87.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class TeleMechanical extends Command {

	public JoystickButton winchToggle;
	public JoystickButton intakeForward;
	public JoystickButton intakeReverse;
	
	public TeleMechanical() {
		winchToggle = new JoystickButton(RobotMap.joystick, RobotMap.WINCHTOGGLE);
		intakeForward = new JoystickButton(RobotMap.joystick, RobotMap.INTAKEFORWARD);
		intakeReverse = new JoystickButton(RobotMap.joystick, RobotMap.INTAKEREVERSE);
		
		winchToggle.toggleWhenPressed(new TeleClimb());
		intakeForward.whileHeld(new TeleIntake(1));
		intakeReverse.whileHeld(new TeleIntake(-1));
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !DriverStation.getInstance().isOperatorControl();
	}

}
