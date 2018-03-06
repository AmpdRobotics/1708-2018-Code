package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.RobotMap;
import org.usfirst.frc.team1708.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Drivetrain extends Subsystem {

	double Kp = .05;
	DifferentialDrive robotDrive;

	public Drivetrain() {

		robotDrive = new DifferentialDrive(RobotMap.driveFrontLeftMotor, RobotMap.driveFrontRightMotor);

		RobotMap.leftDriveEncoder.setDistancePerPulse(1);
		RobotMap.rightDriveEncoder.setDistancePerPulse(1);

		setUpLiveWindow();
	}

	private void setUpLiveWindow() {
		String driveStr = "Drive";
		RobotMap.leftDriveEncoder.setName(driveStr, "Left encoder");
		LiveWindow.add(RobotMap.leftDriveEncoder);
		RobotMap.rightDriveEncoder.setName(driveStr, "Right encoder");
		LiveWindow.add(RobotMap.rightDriveEncoder);
		RobotMap.driveShifter.setName(driveStr, "Shifter");
		LiveWindow.add(RobotMap.driveShifter);
		RobotMap.gyro.setName(driveStr, "Gyro");
	}

	public void drive(double move, double turn) {
		robotDrive.arcadeDrive(move, turn, false);
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

	public void resetGyro() {
		RobotMap.gyro.reset();
	}

	public void driveWithGyro(double speed, double angle) {
		double gyroAngle = getGyroAngle();
		System.out.println("auto gyro angle" + gyroAngle + ", Desired Angle: " + angle);

		double angular_speed = (angle - gyroAngle) * Kp;
		double sign = angular_speed < 0 ? -1 : 1;
		angular_speed = Math.max(Math.abs(angular_speed), .04) * sign;
		System.out.println("auto gyro angle" + gyroAngle + ", Desired Angle: " + angle + ", Speed: " + angular_speed);

		if (angle - gyroAngle < 180) {
			angular_speed = -angular_speed;
		}
		drive(speed, angular_speed);

	}

	public double getGyroAngle() {
		return RobotMap.gyro.getAngle();
	}

	public double getEncoderDistance() {
		return RobotMap.leftDriveEncoder.get();
	}

	public void setDriveShifter(boolean isHigh) {
		if (isHigh) {
			RobotMap.driveShifter.set(true);
		} else {
			RobotMap.driveShifter.set(false);
		}

	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
