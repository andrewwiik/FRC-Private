package org.usfirst.frc.team87.robot.commands;

import org.usfirst.frc.team87.robot.OI;
import org.usfirst.frc.team87.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Climb extends Command {
	public static OI oi;
    public Climb() {
    	super("Climb");
    	oi = new OI();
    	requires(Robot.winch);
    }
    
    protected void execute() {
    	Robot.winch.climb(oi.getWinchSpeed());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.winch.climb(0);
    }
}
