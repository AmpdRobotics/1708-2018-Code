package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForDistance extends Command {
	private int encoderTicksPerRevolution = 128;

	private double revolutionsPerFoot = 1.57;
	private double feetToTicks = encoderTicksPerRevolution * revolutionsPerFoot;
	private double distance_ticks;
	
	private double desired_angle = 0.0;

	public DriveForDistance(double distance_ft) {
		distance_ticks = distance_ft * feetToTicks;
		
		desired_angle = Robot.drivetrain.getGyroAngle();
		requires(Robot.drivetrain);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.resetEncoders();
		Robot.drivetrain.resetGyro();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.driveWithGyro(.75, desired_angle);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.drivetrain.getEncoderDistance() >= distance_ticks) {
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
