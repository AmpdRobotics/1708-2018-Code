package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

/**
 *
 */
public class GoToScaleHighLevel extends AbstractGoToLevelCommand {
	

	public GoToScaleHighLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = 4;

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	
	protected boolean isFinished()
	{
		boolean hitSwitch = RobotMap.elevatorUpperLimitSwitch.get() && RobotMap.elevatorUpperCarriageLimitSwitch.get();
		return hitSwitch || super.isFinished();
	}

}