package org.usfirst.frc.team87.robot.commands.teleop;

import org.usfirst.frc.team87.robot.commands.TeleDrive;
import org.usfirst.frc.team87.robot.commands.TeleMechanical;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Teleop extends CommandGroup {
	public Teleop() {
		addParallel(new TeleMechanical());
		addParallel(new TeleDrive());
	}
}
