package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CalibrateElevator extends Command {

	private double percentage = 0;

	public CalibrateElevator() {
		requires(Robot.elevatorSub);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
//		Robot.elevatorSub.setPostionOI(Robot.oi);
//		Robot.elevatorSub.getPosition();
		percentage = Robot.elevatorSub.getSpeedFromJoystick(Robot.oi);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (percentage < 0 && RobotMap.elevatorLowerLimitSwitch.get()) {
			return true;
		} else if (percentage > 0 && RobotMap.elevatorUpperLimitSwitch.get()
				&& RobotMap.elevatorUpperCarriageLimitSwitch.get()) {
			return true;
		} else {
			return false;
		}
		
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevatorSub.stopElevator();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.elevatorSub.stopElevator();
	}
}
