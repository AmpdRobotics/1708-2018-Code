package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AbstractGoToLevelCommand extends Command {
	
	public final double GROUND_HEIGHT_FEET = 0;
	public final double SWITCH_HEIGHT_FEET = 2;
	public final double SCALE_LOW_HEIGHT_FEET = 4;
	public final double SCALE_MED_HEIGHT_FEET = 5;
	public final double SCALE_HIGH_HEIGHT_FEET = 6;

	protected double setHeightLevelFeet = 0;
	private double elevatorTolerance = 0.042; // half an inch

	private boolean stoppedFromLimitSwitch = false;
	public AbstractGoToLevelCommand() {
		requires(Robot.elevatorSub);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("starting switch level command");
		stoppedFromLimitSwitch = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevatorSub.setPosition(setHeightLevelFeet);

	}

	// Make this retuSrn true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println("Current: " + Robot.elevatorSub.getPositionFeet() + ", Desired: " + setHeightLevelFeet);
		
		if (Math.abs(Robot.elevatorSub.getPositionFeet() - setHeightLevelFeet) <= elevatorTolerance) {
			System.out.println("reached desired position. current position: " + Robot.elevatorSub.getPositionFeet()
					+ " desired position" + setHeightLevelFeet);
			return true;
		} 
		else if (!Robot.elevatorSub.isGoingDown() && RobotMap.elevatorUpperLimitSwitch.get()
				&& RobotMap.elevatorUpperCarriageLimitSwitch.get())
		{
			System.out.println("hit a upper button");
			stoppedFromLimitSwitch = true;
			return true;
		}
		else if(Robot.elevatorSub.isGoingDown() && RobotMap.elevatorLowerLimitSwitch.get()) {
			System.out.println("hit lower button");
			stoppedFromLimitSwitch = true;
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		if(stoppedFromLimitSwitch)
		{
			Robot.elevatorSub.stopElevator();
		}
			
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

	}
}