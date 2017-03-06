package org.usfirst.frc.team87.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	Joystick joystick = new Joystick(RobotMap.JOYSTICK);
	Joystick gamepad = new Joystick(RobotMap.GAMEPAD);

	public OI() {
		Button reverse = new JoystickButton(gamepad, RobotMap.REVERSE);
		Button slowDown = new JoystickButton(gamepad, RobotMap.SLOWDOWN);
		Button winchToggle = new JoystickButton(joystick, RobotMap.WINCHTOGGLE);
		Button intakeForward = new JoystickButton(joystick, RobotMap.INTAKEFORWARD);
		Button intakeReverse = new JoystickButton(joystick, RobotMap.INTAKEREVERSE);
		Button output = new JoystickButton(joystick, RobotMap.OUTPUT);
		// button.whenPressed(new ExampleCommand());
		// button.whileHeld(new ExampleCommand());
		// button.whenReleased(new ExampleCommand());
	}

	public boolean getSlowDown() {
		return gamepad.getRawButton(RobotMap.SLOWDOWN);
	}
}
