package org.usfirst.frc.team1708.robot.commands;

import org.usfirst.frc.team1708.robot.Robot;

/**
 *
 */
public class GoToScaleLowLevel extends AbstractGoToLevelCommand {
	

	public GoToScaleLowLevel() {
		requires(Robot.elevatorSub);
		this.setHeightLevelFeet = 3;
		

}
}