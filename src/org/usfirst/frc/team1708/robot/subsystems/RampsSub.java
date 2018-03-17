package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.RobotMap;
import org.usfirst.frc.team1708.robot.commands.ReverseDigitalInput;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampsSub extends Subsystem {
	private SpeedController motor;
	private ReverseDigitalInput limitSwitch;
	private boolean isEnabled;

	public RampsSub(SpeedController motor, ReverseDigitalInput limitSwitch) {
		this.motor = motor;
		this.limitSwitch = limitSwitch;
		this.isEnabled = false;
	}

	public void raiseRamps() {
		if (isEnabled == true) {
			motor.set(1);
		}
	}

	public boolean isUp() {
		if (limitSwitch.get() == true) {
			return true;
		} else {
			return false;
		}
	}

	public void enableRamp() {
		isEnabled = true;
	}

	public void rampsOff() {
		motor.set(0);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
