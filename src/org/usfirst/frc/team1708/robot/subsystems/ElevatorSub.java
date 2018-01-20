package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.OI;
import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class ElevatorSub extends Subsystem {
	double Kp = 1;
	double Ki = 0;
	double Kd = 0;
	private PIDController controller;

	public ElevatorSub() {
		controller = new PIDController(Kp, Ki, Kd, RobotMap.elevatorEncoder, RobotMap.elevatorMotor);
	}

	public void setPosition(double height_ft) {
		setPIDControllerState(true);
	}

	public void setPostionOI(OI oi) {

	}

	public void setVelocity(double speed) {
		setPIDControllerState(false);
		RobotMap.elevatorMotor.set(speed);
	}

	public void setPIDControllerState(boolean enabled) {
		if (enabled) {
			controller.enable();
		} else {
			controller.disable();
		}
	}
	
	public void resetElevatorEncoder() {
		RobotMap.elevatorEncoder.reset();
	}
	
	
	public double getPosition() {
		return RobotMap.elevatorEncoder.getDistance();
	}

	public void zeroElevator() {

	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
