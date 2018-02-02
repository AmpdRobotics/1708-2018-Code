package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToScaleMediumLevel extends AbstractGoToLevelCommand {
	

	public GoToScaleMediumLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = 5;

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);}
}
}