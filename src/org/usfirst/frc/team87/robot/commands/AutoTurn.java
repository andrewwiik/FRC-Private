package org.usfirst.frc.team87.robot.commands;

import org.usfirst.frc.team87.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {

	private double angle;
	private double speed;
	private double threshold = 3;
	
    public AutoTurn(double angle_in, double speed_in) {
    	this.angle = angle_in;
    	this.speed = speed_in;
    }

    protected void initialize() {
    	Robot.driveTrain.resetGyro();
    }

    protected void execute() {
    	if (angle > 0){
    		// If we are turning Right
    		Robot.driveTrain.tankDrive(this.speed, -this.speed);
    	} else {
    		// If we are turning Left
    		Robot.driveTrain.tankDrive(-this.speed, this.speed);
    	}
    }

    protected boolean isFinished() {
    	double offset = Math.abs(this.angle - Robot.driveTrain.getGyro());
        return (offset < threshold);
    }

    protected void end() {
    	Robot.driveTrain.tankDrive(0, 0);
    }

    protected void interrupted() {
    	Robot.driveTrain.tankDrive(0, 0);
    }
}