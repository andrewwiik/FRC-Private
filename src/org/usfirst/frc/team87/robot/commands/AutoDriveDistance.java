package org.usfirst.frc.team87.robot.commands;

import org.usfirst.frc.team87.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveDistance extends Command {
	
	private double inches, speed;
	private Timer time = new Timer();

    public AutoDriveDistance(double inches_in, double speed_in) {
    	requires(Robot.driveTrain);
    	this.inches = inches_in;
    	this.speed = speed_in;
    }

    protected void initialize() {
    	Robot.driveTrain.resetEncoders();
    	Robot.driveTrain.tankDrive(speed, speed);
    	Robot.driveTrain.resetGyro();
    	this.time.start();
    }
    
    protected void execute() {
    	Robot.driveTrain.tankDrive(speed, speed);
    }
    
    protected boolean isFinished() {
    	boolean done = false;
    	if (this.time.get() >= 1){
    		this.time.reset();
    	}
    	if (inches >= 0) {
    		done = (Robot.driveTrain.getLeftEncoderValue() > inches);
    	} else {
    		done = (Robot.driveTrain.getLeftEncoderValue() < inches);
    	}
    	return done;
    }

    protected void end() {
    	Robot.driveTrain.tankDrive(0, 0);
    }

    protected void interrupted() {
    	Robot.driveTrain.tankDrive(0, 0);
    }
}