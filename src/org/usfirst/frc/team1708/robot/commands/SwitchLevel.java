package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchLevel extends Command {
	private double switchHeightLevelFeet = 2;

	public SwitchLevel() {
		requires(Robot.elevatorSub);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevatorSub.setPosition(switchHeightLevelFeet);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		return Robot.elevatorSub.getPositionFeet() == switchHeightLevelFeet;
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
