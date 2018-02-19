package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.OI;
import org.usfirst.frc.team1708.robot.RobotMap;
import org.usfirst.frc.team1708.robot.commands.CalibrateElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class ElevatorSub extends Subsystem {
	private double encoderTicksPerRevolution = 1024;
	private double revolutionsPerFoot = 10;
	private double feetToTicks = encoderTicksPerRevolution * revolutionsPerFoot;

	private double zeroPosition = 0;
	private int timeOutMS = 10;
	private int pidIndex = 0;
	
	private WPI_TalonSRX  elevatorMotor = new WPI_TalonSRX (13);

	public ElevatorSub() {
		elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, timeOutMS, pidIndex);
		
		elevatorMotor.configNominalOutputForward(0, timeOutMS);
		elevatorMotor.configNominalOutputReverse(0, timeOutMS);
		elevatorMotor.configPeakOutputForward(1, timeOutMS);
		elevatorMotor.configPeakOutputReverse(-1, timeOutMS);
	
		elevatorMotor.configAllowableClosedloopError(0, pidIndex, timeOutMS);

		elevatorMotor.config_kP(pidIndex, 0.1, timeOutMS);
		elevatorMotor.config_kI(pidIndex, 0.0, timeOutMS);
		elevatorMotor.config_kD(pidIndex, 0.0, timeOutMS);
	}

	public void setPosition(double height_ft) {
		double numTicks = feetToTicks * height_ft + zeroPosition;
		
		elevatorMotor.set(ControlMode.Position, numTicks);
		System.out.println("Setting position ticks to: " + numTicks + ", Zero: " + zeroPosition);
	}

	public void setPostionOI(OI oi) {
		double slow = 0.7;
		elevatorMotor.set(ControlMode.PercentOutput, slow* oi.mechanisms.getY());
	}

	public void setVelocity(double speed_fps) {
		double ticksPerSecond = feetToTicks * speed_fps;
		elevatorMotor.set(ControlMode.Velocity, ticksPerSecond);
	}

	public void resetElevatorEncoder() {
		zeroPosition = getPosition();
		System.out.println("Setting Zero:" +zeroPosition );
	}

	public double getPosition() {
		System.out.println("Sensor position at: " + elevatorMotor.getSelectedSensorPosition(0));
		return elevatorMotor.getSelectedSensorPosition(0);
		
	}

	public double getPositionFeet() {
		return getPosition() / feetToTicks;
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		setDefaultCommand(new CalibrateElevator());
		
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
