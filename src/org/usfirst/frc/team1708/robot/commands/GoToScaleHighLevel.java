package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.RobotMap;

/**
 *
 */
public class GoToScaleHighLevel extends AbstractGoToLevelCommand {

	public GoToScaleHighLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = SCALE_HIGH_HEIGHT_FEET;

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

}