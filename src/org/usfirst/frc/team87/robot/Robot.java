package org.usfirst.frc.team87.robot;

import org.usfirst.frc.team87.robot.subsystems.DriveTrain;
import org.usfirst.frc.team87.robot.subsystems.Intake;
import org.usfirst.frc.team87.robot.subsystems.Output;
import org.usfirst.frc.team87.robot.subsystems.Winch;
import org.usfirst.frc.team87.robot.testing.TestingCommandGroup;
import org.usfirst.frc.team87.robot.commands.teleop.Teleop;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	public static OI oi;
	public static AutonomousSelection autonomousSelection;
	public CommandGroup autonomousCommand;
	public TestingCommandGroup testCommand = new TestingCommandGroup();
	

	////////////////
	// SUBSYSTEMS //
	////////////////
	public static DriveTrain driveTrain;
	public static Winch winch;

	public static Output output;
	public static Intake intake;

	//////////////
	// COMMANDS //
	//////////////
	Command TeleDrive;

	@Override
	public void robotInit() {
		RobotMap.init();
		oi = new OI();
		driveTrain = new DriveTrain();
		winch = new Winch();
		autonomousSelection = new AutonomousSelection();
		autonomousSelection.setupSelections();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
//		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		driveTrain.resetGyro();
		driveTrain.resetEncoders();

		driveTrain.invertMotors(true);
		// Get the autonomous command group that should be run
		autonomousCommand = autonomousSelection.getCommandGroupForSelection();
		
		// make sure the returned value is not null
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}
	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		driveTrain.invertMotors(false);
		driveTrain.resetGyro();
		new Teleop().start();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

	}

	/**
	 * This is the initialization for testing. Any test startup commands should go here.
	 */
	@Override
	public void testInit() {
		driveTrain.invertMotors(true);
		testCommand.start();
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}
}
