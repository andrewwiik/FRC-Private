package org.usfirst.frc.team87.robot.subsystems;

import org.usfirst.frc.team87.robot.Robot;
import org.usfirst.frc.team87.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public RobotDrive firstDiabloDrive;
	public RobotDrive secondDiabloDrive;
	public ADXRS450_Gyro gyro = RobotMap.gyro;
	public AnalogGyro simGyro = RobotMap.simGyro;
	
	public static boolean backwardsButton = false;
	public static boolean backwardsToggle = false;
//	
//	public boolean isTurnOnly = true;

	public DriveTrain() {
		if (Robot.isReal()) {
			firstDiabloDrive = new RobotDrive(RobotMap.driveTrainFirstLeftMotor, RobotMap.driveTrainFirstRightMotor);
			secondDiabloDrive = new RobotDrive(RobotMap.driveTrainSecondLeftMotor, RobotMap.driveTrainSecondRightMotor);
		} else {
			secondDiabloDrive = new RobotDrive(RobotMap.driveTrainFirstLeftMotorSim, RobotMap.driveTrainSecondLeftMotorSim, RobotMap.driveTrainFirstRightMotorSim, RobotMap.driveTrainSecondRightMotorSim);
		}
	}


	public void drive(double outputMagnitude, double curve) {
		if (Robot.isReal()) {
			firstDiabloDrive.drive(outputMagnitude, curve);
			secondDiabloDrive.drive(outputMagnitude, curve);
		} else {
			secondDiabloDrive.drive(outputMagnitude, curve);
		}
	}

	public void tankDrive(double leftValue, double rightValue) {
		if (Robot.isReal()) {
			firstDiabloDrive.tankDrive(-leftValue, -rightValue);
			secondDiabloDrive.tankDrive(-leftValue, -rightValue);
		} else {
			secondDiabloDrive.tankDrive(leftValue, rightValue);
		}
	}
	
	public void arcadeDrive(double moveValue, double rotateValue) {
		if (Robot.isReal()) {
			firstDiabloDrive.arcadeDrive(moveValue, rotateValue);
			secondDiabloDrive.arcadeDrive(moveValue, rotateValue);
		} else {
			secondDiabloDrive.arcadeDrive(moveValue, rotateValue);
		}
	}
	
	public void setDrive(double left, double right) {
		if (Robot.isReal()) {
			RobotMap.driveTrainFirstLeftMotor.set(left);
			RobotMap.driveTrainFirstRightMotor.set(right);
			RobotMap.driveTrainSecondLeftMotor.set(left);
			RobotMap.driveTrainSecondRightMotor.set(right);
		} else {
			RobotMap.driveTrainSecondLeftMotorSim.set(left);
			RobotMap.driveTrainSecondRightMotorSim.set(right);
		}
	}
	
	public void resetEncoders() {
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();
	}
	
	public double getLeftEncoderValue() {
		return RobotMap.leftEncoder.getDistance();
	}
	
	public double getRightEncoderValue() {
		return RobotMap.rightEncoder.getDistance();
	}
	
	public double getEncoderValue() {
		return (RobotMap.rightEncoder.getDistance() + RobotMap.leftEncoder.getDistance())/2;
	}
	
	public void setLeftMotorSpeed(double speed) {
		if (Robot.isReal()) {
			RobotMap.driveTrainFirstLeftMotor.set(speed);
			RobotMap.driveTrainSecondLeftMotor.set(speed);
		} else {
			RobotMap.driveTrainSecondLeftMotorSim.set(speed);
		}
	}
	
	public void setRightMotorSpeed(double speed) {
		if (Robot.isReal()) {
			RobotMap.driveTrainFirstRightMotor.set(speed);
			RobotMap.driveTrainSecondRightMotor.set(speed);
		} else {
			RobotMap.driveTrainSecondRightMotorSim.set(speed);
		}
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
		
//		firstDiabloDrive.setInvertedMotor(MotorType.kFrontLeft, shouldInvert);
//		firstDiabloDrive.setInvertedMotor(MotorType.kFrontRight, shouldInvert);
//		secondDiabloDrive.setInvertedMotor(MotorType.kFrontLeft, shouldInvert);
//		secondDiabloDrive.setInvertedMotor(MotorType.kFrontRight, shouldInvert);
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
	
	public PIDSource getGyroSource() {
		if (Robot.isReal()) {
			if (gyro != null)
				return gyro;
			else {
				gyro = new ADXRS450_Gyro();
				gyro.reset();
				gyro.calibrate();
				return gyro;
			}
		} else {
			if (simGyro != null)
				return simGyro;
			else {
				simGyro = new AnalogGyro(1);
				simGyro.reset();
				simGyro.calibrate();
				return simGyro;
			}
		}
	}
	
	public void backwardsCheck() {
		if (Robot.isReal()) {
			if (backwardsButton && !RobotMap.gamepad.getRawButton(RobotMap.REVERSE)) {
				backwardsButton = false;
			} else if (!backwardsButton && RobotMap.gamepad.getRawButton(RobotMap.REVERSE)) {
				backwardsButton = true;
				backwardsToggle = !backwardsToggle;
			}
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
