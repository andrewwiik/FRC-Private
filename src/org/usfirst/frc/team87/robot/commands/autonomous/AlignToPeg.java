//package org.usfirst.frc.team87.robot.commands.autonomous;
//
//import org.usfirst.frc.team87.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//public class AlignToPeg extends Command {
//	
//	boolean isFinished;
//	
//	public AlignToPeg(){
//		super("AlignToGear");
//		requires(Robot.driveTrain);
//		isFinished = false;
//	}
//	
//	protected void initialize(){
//		Robot.ringLight.activateLight();
//	//	Robot.drivetrain.isGearCam = true;
//		Robot.driveTrain.isTurnOnly = false;
//		Robot.driveTrain.autonTurnDone = false;
//	}
//	
//	protected void execute(){
//		Robot.drivetrain.setTurnToTarget(true);
//		if(Robot.drivetrain.autonTurnDone){
//			isFinished = true;
//		}
//	}
//	
//	@Override
//	protected boolean isFinished() {
//		return isFinished;
//	}
//
//
//	protected void end(){
//		Robot.drivetrain.setTurnToTarget(false);
//		Robot.ringLight.deactivateLight();
//		Robot.drivetrain.stopPID();
//	}
//}