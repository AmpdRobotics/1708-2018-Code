package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoScoreSwitch extends CommandGroup {
	public enum FieldPosition {
		left, center, right
	};

	private double robotToSwitchDistance = 3; //feet
	private double oppositeSideDistance = 4; //feet
	private double centerTimeoutSeconds = 2; //feet

	private double centerToSwitchDistance = robotToSwitchDistance * .5;
	private double centerToSideDistance = oppositeSideDistance * .5;

	public AutoScoreSwitch(FieldPosition switch_position, FieldPosition robot_position) {
		// Drive to the halfway point between the wall and the switch
		addSequential(new DriveForDistance(centerToSwitchDistance));

		// If we are on the same side as the switch, drive half
		if (switch_position != robot_position) {			
			// Turn to face the direction of the switch
			if (switch_position == FieldPosition.left) {
				addSequential(new TurnToTheSpecifiedAngle(90));
			} else if (switch_position == FieldPosition.right) {
				addSequential(new TurnToTheSpecifiedAngle(-90));
			}
								
			// Drive to the switch side of the field
			if (robot_position == FieldPosition.center) {
				addSequential(new DriveForDistance(centerToSideDistance));
			}
			else {
				addSequential(new DriveForDistance(oppositeSideDistance));
			}
			
			// Turn to face the switch
			addSequential(new TurnToTheSpecifiedAngle(0));
		}
		
		// Center on the switch
		addSequential(new CenterOnBlob(), centerTimeoutSeconds);
		
		addSequential(new GoToSwitchLevel());
		
		// Drive the rest of the way to the switch
		addSequential(new DriveForDistance(centerToSwitchDistance));
		
		// Drop the cube
		addSequential(new CubeOuttake());
	}
}
