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
		if (switch_position == robot_position) {
			addSequential(new DriveForDistance(robotToSwitchDistance));
		} 
		else{
			addSequential(new DriveForDistance(centerToSwitchDistance));
			if (switch_position == FieldPosition.left) {
				addSequential(new TurnToTheSpecifiedAngle(90));
			} else if (switch_position == FieldPosition.right) {
				addSequential(new TurnToTheSpecifiedAngle(-90));
			}
			
			if (robot_position == FieldPosition.center) {
				addSequential(new DriveForDistance(centerToSideDistance));
			}
			else {
				addSequential(new DriveForDistance(oppositeSideDistance));
			}
			addSequential(new TurnToTheSpecifiedAngle(0));
			addSequential(new DriveForDistance(centerToSwitchDistance));
		}
		addSequential(new CenterOnBlob(), centerTimeoutSeconds);
		addSequential(new CubeDrop());
	}
}
