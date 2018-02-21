package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToTheSpecifiedAngle extends Command {

	private double angle_deg;

	public TurnToTheSpecifiedAngle(double angle_deg) {
		if (angle_deg < 0){
			this.angle_deg = 360 + angle_deg;
		}
		else
		{
			this.angle_deg = angle_deg;
		}
		
		requires(Robot.drivetrain);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.resetGyro();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.driveWithGyro(0, angle_deg);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.drivetrain.getGyroAngle() % 360 >= angle_deg) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drivetrain.drive(0, 0);
	}
}
