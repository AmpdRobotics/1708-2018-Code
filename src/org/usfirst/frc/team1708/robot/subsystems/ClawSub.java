package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawSub extends Subsystem {

	private void setRollers(double speed){
		RobotMap.intakeMotor.set(speed);
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

	public void open() {
		RobotMap.clawIntakeSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void close() {
		RobotMap.clawIntakeSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public void clawUp() {
		RobotMap.clawSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void clawDown() {
		RobotMap.clawSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
