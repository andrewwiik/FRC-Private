package org.usfirst.frc.team87.robot.subsystems;

import org.usfirst.frc.team87.robot.RobotMap;

//import com.ctre.CANTalon;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {
//	static CANTalon winchL;
//	static CANTalon winchR;

	public Winch() {
//		winchL = new CANTalon(RobotMap.WINCHL);
//		winchR = new CANTalon(RobotMap.WINCHR);
	}

	public void climb(double speed) {
//		if ((speed < -RobotMap.WINCHTHRESHOLD || speed > RobotMap.WINCHTHRESHOLD) && DriverStation.getInstance().isOperatorControl()) {
//			winchL.set(speed);
//			winchR.set(-speed);
//		} else {
//			winchL.set(0);
//			winchR.set(0);
//		}
	}
	
	public double getSpeed() {
		return RobotMap.joystick.getRawAxis(RobotMap.WINCH);
	}

	public void initDefaultCommand() {
	}
}
