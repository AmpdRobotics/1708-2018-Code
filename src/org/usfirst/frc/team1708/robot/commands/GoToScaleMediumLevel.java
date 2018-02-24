package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

/**
 *
 */
public class GoToScaleMediumLevel extends AbstractGoToLevelCommand {
	

	public GoToScaleMediumLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = 3;

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);}
}
}