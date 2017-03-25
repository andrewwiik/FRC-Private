package org.usfirst.frc.team87.robot.commands;

import org.usfirst.frc.team87.robot.Robot;
import org.usfirst.frc.team87.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveDistance extends Command {
	
	private PIDController angleController;
	private PIDController driveController;
	
	private double distance, speed;
	
	private boolean shouldStop;

	public AutoDriveDistance(double distance, double speed, boolean shouldStop) {
		this.distance = distance;
		this.speed = speed;
		this.shouldStop =shouldStop;
		
	}

	protected void initialize() {
		
		driveController = new PIDController(0.5, 20, 3, new PIDSource() {
			PIDSourceType m_sourceType = PIDSourceType.kDisplacement;
			
			@Override
			public double pidGet() {
				return Math.abs(Robot.driveTrain.getEncoderValue());
			}

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				m_sourceType = pidSource;
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return m_sourceType;
			}
		}, new PIDOutput() {

			@Override
			public void pidWrite(double d) {
				double left = d;
				double right = d;
				
				left *= 1; // Adjust this if you are drifting (make it lower)
				right *= 1; // Adjust this if you are drifting (make it lower)
				
				// Switch the operators if the robot is going the wrong way.
				Robot.driveTrain.tankDrive(-left, -right);

			}
		});
		
		driveController.setAbsoluteTolerance(2);
		driveController.setSetpoint(distance);
		driveController.setOutputRange(-this.speed, this.speed);
		
		Robot.driveTrain.resetGyro();
		Robot.driveTrain.resetEncoders();
		driveController.enable();
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return Math.abs(Robot.driveTrain.getEncoderValue()) > Math.abs(this.distance);
	}

	protected void end() {
		driveController.disable();
		if (this.shouldStop)
			Robot.driveTrain.tankDrive(0, 0);
	}
	
	protected void interrupted() {
		driveController.disable();
		if (this.shouldStop)
			Robot.driveTrain.tankDrive(0, 0);
	}
}