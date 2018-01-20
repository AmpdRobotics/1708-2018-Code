package org.usfirst.frc.team1708.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
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
	// TODO: determine actual values
	public static final int elevatorEncoderChannelA = 0;
	public static final int elevatorEncoderChannelB = 0;
	public static final int leftDriveEncoderChannelA = 0;
	public static final int leftDriveEncoderChannelB = 0;
	public static final int rightDriveEncoderChannelA = 0;
	public static final int rightDriveEncoderChannelB = 0;
	public static final int driveShifterSolenoidForward = 0;
	public static final int driveShifterSolenoidReverse = 0;
	public static final int clawIntakeSolenoidForward = 0;
	public static final int clawIntakeSolenoidReverse = 0;
	public static final int clawSolenoidForward = 0;
	public static final int clawSolenoidReverse = 0;

	public static SpeedController driveFrontLeftMotor = new Spark(0);
	public static SpeedController driveFrontRightMotor = new Spark(1);
	

	public static SpeedController intakeMotor = new VictorSP(2);
	public static SpeedController intakeMotorB = new VictorSP(3);
	public static SpeedController elevatorMotor = new TalonSRX(6);

	public static DoubleSolenoid driveShifter = new DoubleSolenoid(driveShifterSolenoidForward,
			driveShifterSolenoidReverse);
	public static DoubleSolenoid clawIntakeSolenoid = new DoubleSolenoid(clawIntakeSolenoidForward,
			clawIntakeSolenoidReverse);
	public static DoubleSolenoid clawSolenoid = new DoubleSolenoid(clawSolenoidForward, clawSolenoidReverse);
	public static Solenoid elevatorSolenoid = new Solenoid(2);

	public static Encoder elevatorEncoder = new Encoder(elevatorEncoderChannelA, elevatorEncoderChannelB);
	public static Encoder leftDriveEncoder = new Encoder(leftDriveEncoderChannelA, leftDriveEncoderChannelB);
	public static Encoder rightDriveEncoder = new Encoder(rightDriveEncoderChannelA, rightDriveEncoderChannelB);
	public static AnalogGyro gyro = new AnalogGyro(1);
	public static DigitalInput elevatorLimitSwitch = new DigitalInput(0);
	public static DigitalInput cubeSensor = new DigitalInput(1);

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
