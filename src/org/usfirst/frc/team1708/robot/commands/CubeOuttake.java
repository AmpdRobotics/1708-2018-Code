package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeOuttake extends Command {
	private double speed = -0.37;
	public CubeOuttake() {
		requires(Robot.clawSub);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	public CubeOuttake(double speed) {
		requires(Robot.clawSub);
		this.speed = speed;
	}
	// Called just before this Command runs the first time
	protected void initialize() {
		//Robot.clawSub.closeClaw();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.clawSub.outtake(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;

	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.clawSub.intakeOff();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.clawSub.intakeOff();
	}
}
