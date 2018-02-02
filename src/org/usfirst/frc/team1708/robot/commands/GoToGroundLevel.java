package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToGroundLevel extends AbstractGoToLevelCommand {

	public GoToGroundLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = 0;

	}
}