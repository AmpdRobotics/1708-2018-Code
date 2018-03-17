package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.subsystems.RampsSub;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseRamp extends Command {
private RampsSub subsystem;
    public RaiseRamp(RampsSub subsystem) {
    	requires(subsystem);
    	this.subsystem = subsystem;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	subsystem.raiseRamps();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (subsystem.isUp() == true) {
        	return true;
        }else{
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	subsystem.rampsOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	subsystem.rampsOff();
    }
}
