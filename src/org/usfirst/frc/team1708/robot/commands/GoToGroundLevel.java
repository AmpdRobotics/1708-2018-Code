package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

/**
 *
 */
public class GoToGroundLevel extends AbstractGoToLevelCommand {

	public GoToGroundLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = 0;

	}
}