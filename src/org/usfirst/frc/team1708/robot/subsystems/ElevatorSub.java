package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.OI;
import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class ElevatorSub extends Subsystem {
	private double feetToTicks = 2;
	private double zeroPosition = 0;
	private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(13);

	public ElevatorSub() {
	}

	public void setPosition(double height_ft) {
		double numTicks = feetToTicks * height_ft + zeroPosition;
		elevatorMotor.set(ControlMode.Position, numTicks);
	}

	public void setPostionOI(OI oi) {

	}

	public void setVelocity(double speed_fps) {
		double ticksPerSecond = feetToTicks * speed_fps;
		elevatorMotor.set(ControlMode.Velocity, ticksPerSecond);
	}

	public void resetElevatorEncoder() {
		zeroPosition = getPosition();
	}

	public double getPosition() {
		return elevatorMotor.getSelectedSensorPosition(0);

	}

	public double getPositionFeet() {
		return getPosition() / feetToTicks;
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
