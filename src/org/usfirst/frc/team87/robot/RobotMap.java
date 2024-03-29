package org.usfirst.frc.team87.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;

public class RobotMap {
	
	public static final boolean motorsInverted = true;
	
	public static final boolean useDefaultAutoMeasurements = true;
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
	public static final int DRIVE_L1 = 0; // Spark and CIM First Left Motor
	public static final int DRIVE_L2 = 1; // Spark and CIM Second Left Motor
	public static final int DRIVE_R1 = 3; // Spark and CIM First Right Motor
	public static final int DRIVE_R2 = 4; // Spark and CIM Second Right Motor
	public static final int FUEL_IN = 4; // VictorSP and Snowblower
	public static final int FUEL_OUT = 0; // Spike and Window Motor
	public static final int WINCHL = 1; // TalonSRX and Van Door
	public static final int WINCHR = 2; // TalonSRX and Van Door

	/////////////
	// SENSORS //
	/////////////
	public static final int ENC_l_1 = 2; // Encoders use 2 cables.
	public static final int ENC_l_2 = 3; // In theory the placement of the ports
	public static final int ENC_r_1 = 0; // does not matter. This may need some
	public static final int ENC_r_2 = 1; // extra troubleshooting.
	public static final int ULTRA_IN = 4; // If ultrasonic outputs infinity,
	public static final int ULTRA_OUT = 5; // switch these two port numbers.
	public static final int LIMITTOP = 8;
	public static final int LIMITBOTTOM = 9;

	///////////////
	// Variables //
	///////////////
	public static final double WHEELDIAMETER = 6;

	/* It is EXTREMLY IMPORTANT that this value be correct,
	 * currently it is purely math based, which is to say it is
	 * currently set to a 'theoretical' value, variables like friction
	 * and wait need to be accounted in order for this value
	 * to be correct. this value will need to be calibrated
	 * on the field during measuring time. The value should be
	 * how many inches it travels per click I believe.
	 * 
	 * I'm pretty sure the distancePerPulse is this equation:
	 * 
	 * wheelCircumfrence * (1 / clicksPerRevolution)
	 * 
	 * Therefore you need to find out how many clicks it takes to
	 * get one revolution of the wheel. I suggest you consult 
	 * one of your mentors about this as I am not a mechanical
	 * engineer or anything of the sort.
	 */
	
	public static final double INCH_TO_ENC = 256 / (WHEELDIAMETER * Math.PI); //Multiply by inches to get the equivalent in encoder value.
	
	public static final double SLOWDOWNSPEED = 0.75; //Percentage to slow down to when slowDown button is pressed.
	public static final double WINCHTHRESHOLD = 0.05; //Required minimum on axis to enable winch
	public static int startingSide;
	public static int startingPosition;
	public static int endDestination;
	public static int multiAutonomous;

	public static final double AUTO_MOVE_SPEED = 0.6;
	public static final double AUTO_MOVE_MEDIUM_SPEED = 0.52;
	public static final double AUTO_MOVE_SLOW_SPEED = 0.35;
	public static final double AUTO_MOVE_FAST_SPEED = 0.75;
	
	public static final double TURN_SLOW_SPEED = 0.52;
	public static final double TURN_MED_SPEED = 0.54;
	public static final double TURN_FAST_SPEED = 0.56;
	
	public static final double ANGLETOLERANCE = 0.75;
	public static final double DISTANCETOLERANCE = 0.5;
	
	// public static final int ringLight = 0; // Needs to be changed to the correct mapping
	
	public static Spark driveTrainFirstLeftMotor;
    public static Spark driveTrainSecondLeftMotor;
    public static Spark driveTrainFirstRightMotor;
    public static Spark driveTrainSecondRightMotor;
    
    public static Talon driveTrainFirstLeftMotorSim;
    public static Talon driveTrainSecondLeftMotorSim;
    public static Talon driveTrainFirstRightMotorSim;
    public static Talon driveTrainSecondRightMotorSim;

    public static Encoder leftEncoder;
    public static Encoder rightEncoder;
    
    public static Ultrasonic ultrasonic;
    
    public static Joystick joystick;
    public static Joystick gamepad;
    
    public static ADXRS450_Gyro gyro;
	public static AnalogGyro simGyro;
    
    //  public static UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    //	public static UsbCamera gearCamera = new UsbCamera("cam0", 0);

    public static void init() {
    	if (Robot.isReal()) {
	    	driveTrainFirstLeftMotor = new Spark(DRIVE_L1);
	    	((Spark)driveTrainFirstLeftMotor).enableDeadbandElimination(true);
	
	    	driveTrainSecondLeftMotor = new Spark(DRIVE_L2);
	    	((Spark)driveTrainSecondLeftMotor).enableDeadbandElimination(true);
	
	    	driveTrainFirstRightMotor = new Spark(DRIVE_R1);
	    	((Spark)driveTrainFirstRightMotor).enableDeadbandElimination(true);
	
	    	driveTrainSecondRightMotor = new Spark(DRIVE_R2);
	    	((Spark)driveTrainSecondRightMotor).enableDeadbandElimination(true);
	
	    	leftEncoder = new Encoder(ENC_l_1, ENC_l_2, false, Encoder.EncodingType.k4X);
	    	leftEncoder.setDistancePerPulse(INCH_TO_ENC);
	
	    	rightEncoder = new Encoder(ENC_r_1, ENC_r_2, false, Encoder.EncodingType.k4X);
	    	rightEncoder.setDistancePerPulse(INCH_TO_ENC);
	 
	    	ultrasonic =  new Ultrasonic(ULTRA_OUT, ULTRA_IN);
	    	ultrasonic.setAutomaticMode(true);
	    	
	    	joystick = new Joystick(JOYSTICK);
	    	gamepad = new Joystick(GAMEPAD);
	    	
	    	gyro = new ADXRS450_Gyro();
    	} else {
    		driveTrainFirstLeftMotorSim = new Talon(1);
    		driveTrainSecondLeftMotorSim = new Talon(2);
    		driveTrainFirstRightMotorSim = new Talon(3);
    		driveTrainSecondRightMotorSim = new Talon(4);
    		
    		leftEncoder = new Encoder(1, 2);
	    	rightEncoder = new Encoder(3, 4);
	    	
	    	leftEncoder.setDistancePerPulse((4.0 * Math.PI) * (1/360.0));
			rightEncoder.setDistancePerPulse((4.0 * Math.PI) * (1/360.0));
			
			simGyro = new AnalogGyro(1);
    		
    	}


    }
}
