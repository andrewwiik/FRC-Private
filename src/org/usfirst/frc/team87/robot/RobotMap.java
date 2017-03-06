package org.usfirst.frc.team87.robot;

public class RobotMap {
	//////////////
	// CONTROLS //
	//////////////
	public static final int JOYSTICK = 5; // Joystick
	public static final int GAMEPAD = 0; // Controller
	public static final int LEFTDRIVECONTROL = 1; // Left Thumbstick Y Axis on Controller
	public static final int RIGHTDRIVECONTROL = 5; // Right Thumbstick Y Axis on Controller
	public static final int REVERSE = 8; // Start Button
	public static final int SLOWDOWN = 6; // Right Bumper on Controller
	public static final int WINCH = 1; // Y Axis on Joystick
	public static final int WINCHTOGGLE = 8; // Top Right of the Button Grid on Joystick
	public static final int INTAKEFORWARD = 1; // Trigger on the Joystick
	public static final int INTAKEREVERSE = 11; // Bottom Left of the Button Grid on Joystick
	public static final int OUTPUT = 5; // Top Left Button on Top Panel of Joystick

	////////////
	// MOTORS //
	////////////
	public static final int DRIVE_L1 = 0; // Spark and CIM
	public static final int DRIVE_L2 = 1; // Spark and CIM
	public static final int DRIVE_R1 = 3; // Spark and CIM
	public static final int DRIVE_R2 = 4; // Spark and CIM
	public static final int FUEL_IN = 2; // VictorSP and Snowblower
	public static final int FUEL_OUT = 2; // Spike and Window Motor
	public static final int WINCHL = 1; // TalonSRX and Van Door
	public static final int WINCHR = 2; // TalonSRX and Van Door

	/////////////////////
	// SENSORS / OTHER //
	/////////////////////
	public static final int ENC_l_1 = 6; // Encoders use 2 cables.
	public static final int ENC_l_2 = 7; // In theory the placement of the ports
	public static final int ENC_r_1 = 8; // does not matter. This may need some
	public static final int ENC_r_2 = 9; // extra troubleshooting.
	public static final int ULTRA_IN = 4; // If ultrasonic outputs infinity,
	public static final int ULTRA_OUT = 5; // switch these two port numbers.
	public static final int LIMITTOP = 1;
	public static final int LIMITBOTTOM = 0;
	public static final double INCH_TO_ENC = 256 / (6 * Math.PI); //Multiply by inches to get the equivalent in encoder value.
}
