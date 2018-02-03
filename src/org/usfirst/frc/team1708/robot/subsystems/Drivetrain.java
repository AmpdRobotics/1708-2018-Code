package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.RobotMap;
import org.usfirst.frc.team1708.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {
	double Kp = .15;
	DifferentialDrive robotDrive;

	public Drivetrain() {

		robotDrive = new DifferentialDrive(RobotMap.driveFrontLeftMotor, RobotMap.driveFrontRightMotor);

		RobotMap.leftDriveEncoder.setDistancePerPulse(1);
		RobotMap.rightDriveEncoder.setDistancePerPulse(1);

	}

	public void drive(double move, double turn) {
		robotDrive.arcadeDrive(move, turn);
	}

	public void joystickDrive(Joystick move) {
		// robotDrive.arcadeDrive(move.getY(), move.getZ(), true); //competition
		// bot
		robotDrive.arcadeDrive(move.getY(), -move.getZ(), true); // practice
	}

	public void resetEncoders() {
		RobotMap.leftDriveEncoder.reset();
		RobotMap.rightDriveEncoder.reset();
	}

	public double getEncoderDistance() {
		return RobotMap.leftDriveEncoder.get();
	}

	public void setDriveShifter(boolean isHigh) {
		if (isHigh) {
			RobotMap.driveShifter.set(DoubleSolenoid.Value.kReverse);
		} else {
			RobotMap.driveShifter.set(DoubleSolenoid.Value.kForward);
		}

	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
