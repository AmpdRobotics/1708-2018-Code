package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToScaleHighLevel extends AbstractGoToLevelCommand {
	

	public GoToScaleHighLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = 6;

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

}