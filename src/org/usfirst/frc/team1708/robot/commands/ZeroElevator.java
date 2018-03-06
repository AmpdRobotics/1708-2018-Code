package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroElevator extends Command {

	public ZeroElevator() {
		requires(Robot.elevatorSub);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevatorSub.setVelocity(-.1);
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return RobotMap.elevatorLowerLimitSwitch.get();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevatorSub.stopElevator();
		Robot.elevatorSub.resetElevatorEncoder();
		Robot.elevatorSub.setPosition(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.elevatorSub.stopElevator();
	}
}
