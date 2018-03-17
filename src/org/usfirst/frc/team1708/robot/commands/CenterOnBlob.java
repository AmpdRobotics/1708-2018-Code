package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Blob;
import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterOnBlob extends Command {
	private int error_pixels;
	private static final int ERROR_THRESHOLD_PIXELS = 5;

	private static final double kP = .8;

	public CenterOnBlob() {
		requires(Robot.cameraSub);
		requires(Robot.drivetrain);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.error_pixels = Integer.MAX_VALUE;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("Centering on blob");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Blob biggestBlob = Robot.cameraSub.getBiggestBlob();
		double cameraCenter = Robot.cameraSub.getResolution().width / 2;
		if (biggestBlob == null) {
			System.out.println("Cannot find blob");
			// Cannot find a blob
		} else {
			this.error_pixels = (int) (cameraCenter - biggestBlob.getCenter().x);

			double speed = kP * (this.error_pixels) / cameraCenter;

			if (speed < -.5) {
				speed = -.5;
			} else if (speed > .5) {
				speed = .5;
			}
			System.out.println("At: " + biggestBlob.getCenter() + ", E:" + this.error_pixels + ", S: " + speed);

			Robot.drivetrain.drive(0, speed);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(this.error_pixels) < ERROR_THRESHOLD_PIXELS;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("found blob");
		System.out.println(DriverStation.getInstance().getMatchTime());
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
