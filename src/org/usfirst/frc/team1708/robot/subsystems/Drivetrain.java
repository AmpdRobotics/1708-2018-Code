package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.RobotMap;
import org.usfirst.frc.team1708.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	double Kp = .15;
	RobotDrive robotDrive;

	public Drivetrain() {

		robotDrive = new RobotDrive(RobotMap.driveFrontLeftMotor, RobotMap.driveRearLeftMotor,
				RobotMap.driveFrontRightMotor, RobotMap.driveRearRightMotor);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		// robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		// robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

	}

	public void drive(double move, double turn) {
		robotDrive.arcadeDrive(move, turn);
	}

	public void joystickDrive(Joystick move) {
		// robotDrive.arcadeDrive(move.getY(), move.getZ(), true); //competition
		// bot
		robotDrive.arcadeDrive(move.getY(), -move.getZ(), true); // practice
																	// chassis
	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
