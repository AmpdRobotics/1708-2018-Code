package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AbstractGoToLevelCommand extends Command {

	protected double setHeightLevelFeet = 0;

	public AbstractGoToLevelCommand() {
		requires(Robot.elevatorSub);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("starting switch level command");		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevatorSub.setPosition(setHeightLevelFeet);
		

	}

	// Make this retuSrn true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.elevatorSub.getPositionFeet() == setHeightLevelFeet;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevatorSub.setVelocity(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		
	}
}