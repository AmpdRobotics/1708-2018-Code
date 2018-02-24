package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

/**
 *
 */
public class GoToGroundLevel extends AbstractGoToLevelCommand {

	public GoToGroundLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = 0;

	}
	
	protected boolean isFinished()
	{
		boolean hitSwitch = RobotMap.elevatorLowerLimitSwitch.get();
		return hitSwitch || super.isFinished();
	}

}