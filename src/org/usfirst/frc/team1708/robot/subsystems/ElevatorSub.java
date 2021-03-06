package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.OI;
import org.usfirst.frc.team1708.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */

public class ElevatorSub extends Subsystem {
	private double encoderTicksPerRevolution = 1024;
	private double revolutionsPerFoot = 3.3;
	private double feetToTicks = encoderTicksPerRevolution * revolutionsPerFoot;

	private int timeOutMS = 10;
	private int pidIndex = 0;

	private WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(13);
	private WPI_TalonSRX elevatorMotor2 = new WPI_TalonSRX(14);

	public ElevatorSub() {
		elevatorMotor2.setInverted(true);
		elevatorMotor2.set(ControlMode.Follower, 13);
		elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, timeOutMS, pidIndex);

		elevatorMotor.configNominalOutputForward(0, timeOutMS);
		elevatorMotor.configNominalOutputReverse(0, timeOutMS);
		elevatorMotor.configPeakOutputForward(1, timeOutMS);
		elevatorMotor.configPeakOutputReverse(-1, timeOutMS);

		elevatorMotor.configAllowableClosedloopError(0, pidIndex, timeOutMS);

		elevatorMotor.config_kP(pidIndex, .5, timeOutMS);
		elevatorMotor.config_kI(pidIndex, 0.0, timeOutMS);
		elevatorMotor.config_kD(pidIndex, 0.0, timeOutMS);
		
		resetElevatorEncoder();
		setUpLiveWindow();
	}

	private void setUpLiveWindow() {
		String elevatorStr = "Elevator";
		RobotMap.elevatorLowerLimitSwitch.setName(elevatorStr, "Lower limit switch");
		LiveWindow.add(RobotMap.elevatorLowerLimitSwitch);
		
		RobotMap.elevatorUpperCarriageLimitSwitch.setName(elevatorStr, "Upper carriage limit switch");
		LiveWindow.add(RobotMap.elevatorUpperCarriageLimitSwitch);
		
		RobotMap.elevatorUpperLimitSwitch.setName(elevatorStr, "Upper limit switch");
		LiveWindow.add(RobotMap.elevatorUpperLimitSwitch);
		
		elevatorMotor.setName(elevatorStr, "Motor");
		LiveWindow.add(elevatorMotor);
		
		elevatorMotor2.setName(elevatorStr, "follwer motor");
		LiveWindow.add(elevatorMotor2);
	}

	public void stopElevator() {
		setVelocity(0);
	}

	public void setPosition(double height_ft) {
		double numTicks = feetToTicks * height_ft;
		elevatorMotor.set(ControlMode.Position, numTicks);
	}

	public void setVelocityOI(OI oi) {
		double speed = getSpeedFromJoystick(oi);

		if (Math.abs(oi.mechanisms.getY()) < .1) {
			stopElevator();
		} else {
			elevatorMotor.set(ControlMode.PercentOutput, speed);
		}
	}

	public void setVelocity(double speed_fps) {
		double ticksPerSecond = feetToTicks * speed_fps;
		elevatorMotor.set(ControlMode.Velocity, ticksPerSecond);
	}

	public void resetElevatorEncoder() {
		elevatorMotor.setSelectedSensorPosition(0, pidIndex, timeOutMS);
	}

	public double getPosition() {
		return elevatorMotor.getSelectedSensorPosition(0);
	}

	public double getPositionFeet() {
		return getPosition() / feetToTicks;
	}

	public double getSpeedFromJoystick(OI oi) {
		double slow = 0.5;
		return slow * oi.mechanisms.getY();
	}

	public boolean isGoingDown() {
		if (elevatorMotor.get() < 0) {
			return true;
		} else {
			return false;
		}

	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		//setDefaultCommand(new CalibrateElevator());

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
