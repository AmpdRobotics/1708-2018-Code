package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
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
		RobotMap.dropClawSolenoid.setName(clawStr, "Drop solenoid");
	}

	private void setRollers(double speed) {
		RobotMap.intakeMotor.set(speed);
		RobotMap.intakeMotorB.set(speed);
	}

	public void intake() {
		double intakeSpeed = 1;
		setRollers(intakeSpeed);
	}

	public void outtake() {
		double outtakeSpeed = -1;
		setRollers(outtakeSpeed);
	}

	public void intakeOff() {
		double intakeOffSpeed = 0;
		setRollers(intakeOffSpeed);
	}

	public void clawUp() {
		RobotMap.dropClawSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void clawDown() {
		RobotMap.dropClawSolenoid.set(DoubleSolenoid.Value.kReverse);
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
