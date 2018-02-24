package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

/**
 *
 */
public class GoToSwitchLevel extends AbstractGoToLevelCommand {
	

	public GoToSwitchLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = 1;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
}
