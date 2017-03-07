package org.usfirst.frc.team87.robot;

import org.usfirst.frc.team87.robot.commands.Climb;
import org.usfirst.frc.team87.robot.subsystems.DriveBase;
import org.usfirst.frc.team87.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	public static OI oi;
	public static AutonomousSelector autoselector;

	////////////////
	// SUBSYSTEMS //
	////////////////
	public static DriveBase drivebase;
	public static Winch winch;

	@Override
	public void robotInit() {
		oi = new OI();
		drivebase = new DriveBase();
		winch = new Winch();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		autoselector.autoSelectorLogic();
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
