package org.usfirst.frc.team87.robot.subsystems;

import org.usfirst.frc.team87.robot.OI;
import org.usfirst.frc.team87.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {
	public static OI oi;
	static CANTalon winchL;
	static CANTalon winchR;

	public DriveBase() {
		oi = new OI();
		winchL = new CANTalon(RobotMap.WINCHL);
		winchR = new CANTalon(RobotMap.WINCHR);
	}

	public void climb() {
		if ((oi.getWinchSpeed()<-RobotMap.WINCHTHRESHOLD||oi.getWinchSpeed()>RobotMap.WINCHTHRESHOLD)&&oi.getWinchToggle && DriverStation.getInstance().isOperatorControl()) {
			winchL.set(oi.getWinchSpeed());
      winchR.set(-oi.getWinchSpeed());
		} else {
			winchL.set(0);
      winchR.set(0);
		}
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new Drive());
	}
}
