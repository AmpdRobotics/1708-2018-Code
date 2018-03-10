package org.usfirst.frc.team1708.robot;

import org.usfirst.frc.team1708.robot.commands.ReverseDigitalInput;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// blob detector parameter for vision
	public static final int MIN_HUE = 39;
	public static final int MAX_HUE = 97;
	public static final int MIN_SAT = 205;
	public static final int MAX_SAT = 255;
	public static final int MIN_VALUE = 34;
	public static final int MAX_VALUE = 255;

	public static final int ENCODER_TICKS_PER_REVOLUTION = 128;

	// ANALOG

	// DIO
	public static final int upperElevatorLimitSwitch = 0;
	public static final int lowerElevatorLimitSwitch = 1;
	public static final int upperElevatorCarriageLimitSwitch = 3;

	public static final int cubeSensorPort = 2;
	public static final int rightDriveEncoderChannelB = 9;
	public static final int rightDriveEncoderChannelA = 8;
	public static final int leftDriveEncoderChannelB = 7;
	public static final int leftDriveEncoderChannelA = 6;

	// Solenoids
	public static final int rampSolenoidPort = 0;
	public static final int driveShifterSolenoid = 4;
	public static final int clawSolenoid = 3;

	// PWM
	public static SpeedController driveFrontLeftMotor = new Spark(0);
	public static SpeedController driveFrontRightMotor = new Spark(1);

	public static SpeedController intakeMotor = new VictorSP(2);
	public static SpeedController intakeMotorB = new VictorSP(3);

	public static Solenoid driveShifter = new Solenoid(driveShifterSolenoid);
	public static Solenoid clawIntakeSolenoid = new Solenoid(clawSolenoid);
	public static Solenoid rampSolenoid = new Solenoid(rampSolenoidPort);

	public static Encoder leftDriveEncoder = new Encoder(leftDriveEncoderChannelA, leftDriveEncoderChannelB);
	public static Encoder rightDriveEncoder = new Encoder(rightDriveEncoderChannelA, rightDriveEncoderChannelB);
	public static AHRS gyro = new AHRS(SPI.Port.kMXP);
	public static ReverseDigitalInput elevatorLowerLimitSwitch = new ReverseDigitalInput(lowerElevatorLimitSwitch);
	public static ReverseDigitalInput elevatorUpperLimitSwitch = new ReverseDigitalInput(upperElevatorLimitSwitch);
	public static ReverseDigitalInput elevatorUpperCarriageLimitSwitch = new ReverseDigitalInput(
			upperElevatorCarriageLimitSwitch);

	public static ReverseDigitalInput cubeSensor = new ReverseDigitalInput(cubeSensorPort);

	public static final int cam0 = 0;
	// TODO: add camera

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
