package org.usfirst.frc.team87.robot.subsystems;

import org.usfirst.frc.team87.robot.Robot;
import org.usfirst.frc.team87.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public static RobotDrive firstDiabloDrive;
	public static RobotDrive secondDiabloDrive;
	public static ADXRS450_Gyro gyro;
	public static AnalogGyro simGyro;
	
	public static boolean backwardsButton = false;
	public static boolean backwardsToggle = false;
//	
//	public boolean isTurnOnly = true;

	public DriveTrain() {
		if (Robot.isReal()) {
			firstDiabloDrive = new RobotDrive(RobotMap.driveTrainFirstLeftMotor, RobotMap.driveTrainFirstRightMotor);
			secondDiabloDrive = new RobotDrive(RobotMap.driveTrainSecondRightMotor, RobotMap.driveTrainSecondRightMotor);
			gyro = new ADXRS450_Gyro();
		} else {
			firstDiabloDrive = new RobotDrive(RobotMap.driveTrainFirstLeftMotorSim, RobotMap.driveTrainFirstRightMotorSim);
			secondDiabloDrive = new RobotDrive(RobotMap.driveTrainSecondRightMotorSim, RobotMap.driveTrainSecondRightMotorSim);
			simGyro = new AnalogGyro(1);
		}
	}


	public void drive(double outputMagnitude, double curve) {
		firstDiabloDrive.drive(outputMagnitude, curve);
		secondDiabloDrive.drive(outputMagnitude, curve);
	}

	public void tankDrive(double leftValue, double rightValue) {
		firstDiabloDrive.tankDrive(leftValue, rightValue);
		secondDiabloDrive.tankDrive(leftValue, rightValue);
	}
	
	public void arcadeDrive(double moveValue, double rotateValue) {
		firstDiabloDrive.arcadeDrive(moveValue, rotateValue);
		secondDiabloDrive.arcadeDrive(moveValue, rotateValue);
	}
	
	public void resetEncoders() {
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();
	}
	
	public double getLeftEncoderValue() {
		return RobotMap.leftEncoder.get();
	}
	
	public double getRightEncoderValue() {
		return RobotMap.rightEncoder.get();
	}
	
//	public void setSpeed(double right, double left){
//			firstDiabloDrive.arcadeDrive(left, right);
//			secondDiabloDrive.arcadeDrive(left, right);
//		}
		
//	public void addTurn(double right, double left){
//		  setSpeed(right + pidOIRight, left + pidOILeft);
//	  }

	public void initDefaultCommand() {
		// setDefaultCommand(new Drive());
	}
	
	
	/* Invert or uninvert all the motors, used for autonomous when the robot 
	 * is placed backwards
	 * backwards.
	 */
	
	public void invertMotors(boolean shouldInvert) {
		
		firstDiabloDrive.setInvertedMotor(MotorType.kFrontLeft, shouldInvert);
		firstDiabloDrive.setInvertedMotor(MotorType.kFrontRight, shouldInvert);
		secondDiabloDrive.setInvertedMotor(MotorType.kFrontLeft, shouldInvert);
		secondDiabloDrive.setInvertedMotor(MotorType.kFrontRight, shouldInvert);
	}
	
	public void initGyro() {
		if (Robot.isReal()) {
			gyro.calibrate();
		} else {
			simGyro.calibrate();
		}
	}

	public void resetGyro() {
		if (Robot.isReal()) {
			gyro.reset();
		} else {
			simGyro.reset();
		}
	}

	public double getGyro() {
		if (Robot.isReal()) {
			return gyro.getAngle();
		} else {
			return simGyro.getAngle();
		}
	}
	
	public void backwardsCheck() {
		if (backwardsButton && !RobotMap.gamepad.getRawButton(RobotMap.REVERSE)) {
			backwardsButton = false;
		} else if (!backwardsButton && RobotMap.gamepad.getRawButton(RobotMap.REVERSE)) {
			backwardsButton = true;
			backwardsToggle = !backwardsToggle;
		}
	}
	
	public double getLeftSpeed() {
		return RobotMap.gamepad.getRawAxis(RobotMap.LEFTDRIVECONTROL);
	}

	public double getRightSpeed() {
		return RobotMap.gamepad.getRawAxis(RobotMap.RIGHTDRIVECONTROL);
	}
	
	public boolean getBackwards() {
		return backwardsToggle;
	}

	public boolean getSlowDown() {
		return RobotMap.gamepad.getRawButton(RobotMap.SLOWDOWN);
	}
}
