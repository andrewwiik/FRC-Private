package org.usfirst.frc.team87.robot.commands;

import org.usfirst.frc.team87.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class WaitForGearRemoval extends Command {

	
	public double ultraTotal;
	public double ultraTimes;
	public boolean isFinished;
	
	public WaitForGearRemoval() {
		ultraTotal = 0;
		ultraTimes = 0;
		isFinished = false;
	}
	
	protected void execute() {
		double ultraValue = RobotMap.ultrasonic.getRangeInches();
		
		if(ultraValue>5*(ultraTotal/ultraTimes)){
			isFinished = true;
		}
		
		ultraTotal += ultraValue;
		ultraTimes += 1;
    }
	
	protected boolean isFinished() {
        return isFinished;
    }
	
	protected void interrupted() {
       
    }

}
