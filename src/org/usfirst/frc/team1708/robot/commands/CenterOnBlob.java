package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Blob;
import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterOnBlob extends Command {

    public CenterOnBlob() {
    	requires(Robot.cameraSub);
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		System.out.println("Centering on blob");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Blob biggestBlob = Robot.cameraSub.getBiggestBlob();
    	double cameraCenter = Robot.cameraSub.getResolution().width / 2;
    	if (biggestBlob == null){
    		System.out.println("Cannot find blob");
    		// Cannot find a blob
    	}
    	else {
    		System.out.println("Found blob at " + biggestBlob.getCenter());
    		double speed = (cameraCenter - biggestBlob.getCenter().x)/(cameraCenter * 2);
    		Robot.drivetrain.drive(0, speed);
    		System.out.println("Setting Speed Vision" + speed);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
