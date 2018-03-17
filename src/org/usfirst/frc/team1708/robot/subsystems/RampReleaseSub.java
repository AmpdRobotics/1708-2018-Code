package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampReleaseSub extends Subsystem {
	private boolean isEnabled;

	public void DropRamps() {
		isEnabled = false;
	}

	public void enable() {
		isEnabled = true;
	}

	public void deploy() {
		if (isEnabled) {

			RobotMap.rampSolenoid.set(true);
		}
	}

	public boolean areRampsDeployed() {
		if (RobotMap.rampSolenoid.get()) {
			return true;
		} else
			return false;
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
