package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ClawSub extends Subsystem {

	public ClawSub() {
		setUpLiveWindow();
	}

	private void setUpLiveWindow() {
		String clawStr = "Claw";
		RobotMap.cubeSensor.setName(clawStr, "Cube sensor");
		LiveWindow.add(RobotMap.cubeSensor);
		RobotMap.clawIntakeSolenoid.setName(clawStr, "Intake solenoid");
		LiveWindow.add(RobotMap.clawIntakeSolenoid);
		((Sendable) RobotMap.intakeMotor).setName(clawStr, "Right intake");
		LiveWindow.add((Sendable) RobotMap.intakeMotor);
		((Sendable) RobotMap.intakeMotorB).setName(clawStr, "Left intake");
		LiveWindow.add((Sendable) RobotMap.intakeMotorB);
	}

	private void setRollers(double speed) {
		RobotMap.intakeMotor.set(speed);
		RobotMap.intakeMotorB.set(speed);
	}

	public void intake() {
		double intakeSpeed = 1;
		setRollers(intakeSpeed);
	}

	public void outtake(double speed) {
		setRollers(speed);
	}

	public void intakeOff() {
		double intakeOffSpeed = 0;
		setRollers(intakeOffSpeed);
	}

	public void openClaw() {
		RobotMap.clawIntakeSolenoid.set(true);
	}

	public void closeClaw() {
		RobotMap.clawIntakeSolenoid.set(false);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
