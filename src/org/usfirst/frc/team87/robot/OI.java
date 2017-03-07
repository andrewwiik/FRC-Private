package org.usfirst.frc.team87.robot;

import org.usfirst.frc.team87.robot.commands.Climb;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	Joystick joystick = new Joystick(RobotMap.JOYSTICK);
	Joystick gamepad = new Joystick(RobotMap.GAMEPAD);

	public OI() {
		// Button reverse = new JoystickButton(gamepad, RobotMap.REVERSE);
		// Button slowDown = new JoystickButton(gamepad, RobotMap.SLOWDOWN);
		Button winchToggle = new JoystickButton(joystick, RobotMap.WINCHTOGGLE);
		// Button intakeForward = new JoystickButton(joystick, RobotMap.INTAKEFORWARD);
		// Button intakeReverse = new JoystickButton(joystick, RobotMap.INTAKEREVERSE);
		// Button output = new JoystickButton(joystick, RobotMap.OUTPUT);

		// slowDown.whileHeld(new slowDrive());
		winchToggle.toggleWhenPressed(new Climb());
		// intakeForward.whileHeld(new intakeForward());
		// intakeReverse.whileHeld(new intakeReverse());
		// output.whenPressed(new output());
	}

	public boolean getSlowDown() {
		return gamepad.getRawButton(RobotMap.SLOWDOWN);
	}

	public double getWinchSpeed() {
		return joystick.getRawAxis(RobotMap.WINCH);
	}

}
