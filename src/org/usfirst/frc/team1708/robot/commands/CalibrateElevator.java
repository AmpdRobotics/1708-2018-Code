package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CalibrateElevator extends Command {

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
		System.out.println("Executing");
		Robot.elevatorSub.setPostionOI(Robot.oi);
		Robot.elevatorSub.getPosition();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevatorSub.setVelocity(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.elevatorSub.setVelocity(0);

	}
}
