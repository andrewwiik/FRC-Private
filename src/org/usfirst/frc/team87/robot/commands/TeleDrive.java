package org.usfirst.frc.team87.robot.commands;

import org.usfirst.frc.team87.robot.Robot;
import org.usfirst.frc.team87.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class TeleDrive extends Command {

	public TeleDrive() {
		requires(Robot.driveTrain);
	}

	protected void execute() {
		Robot.driveTrain.backwardsCheck();
		double leftSpeed = Robot.driveTrain.getLeftSpeed();
		double rightSpeed = Robot.driveTrain.getRightSpeed();
		if (Robot.driveTrain.getSlowDown()) {
			leftSpeed *= RobotMap.SLOWDOWNSPEED;
			rightSpeed *= RobotMap.SLOWDOWNSPEED;
		}
		if (Robot.driveTrain.getBackwards()) {
			Robot.driveTrain.tankDrive(-rightSpeed, -leftSpeed);
		} else {
			Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
		}
	}

	protected boolean isFinished() {
		return !DriverStation.getInstance().isOperatorControl();
	}

	protected void end() {
		Robot.driveTrain.tankDrive(0, 0);
	}

	protected void interrupted() {
		Robot.driveTrain.tankDrive(0, 0);
	}
}
