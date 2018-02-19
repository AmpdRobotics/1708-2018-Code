package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoScoreSwitch extends CommandGroup {
	public enum FieldPosition {
		left, center, right
	};

	private double robotToSwitchDistance = 3;
	private double centerToSwitchDistance = robotToSwitchDistance * .5;
	private double oppositeSideDistance = 4;
	private double centerToSideDistance = oppositeSideDistance * .5;

	public AutoScoreSwitch(FieldPosition switch_position, FieldPosition robot_position) {
		if (switch_position == robot_position) {
			addSequential(new DriveForDistance(robotToSwitchDistance));
		} else if (robot_position == FieldPosition.center) {
			addSequential(new DriveForDistance(centerToSwitchDistance));
			// drive straight
			if (switch_position == FieldPosition.left) {
				addSequential(new TurnToTheSpecifiedAngle(90));
			} else if (switch_position == FieldPosition.right) {
				addSequential(new TurnToTheSpecifiedAngle(-90));

			}
			addSequential(new DriveForDistance(centerToSideDistance));
			addSequential(new TurnToTheSpecifiedAngle(0));
			addSequential(new DriveForDistance(centerToSwitchDistance));
		} else {
			// drive straightaddSequential(new DriveForDistance(1.5));
			// drive straight
			if (switch_position == FieldPosition.left) {
				addSequential(new TurnToTheSpecifiedAngle(90));

			} else if (switch_position == FieldPosition.right) {
				addSequential(new TurnToTheSpecifiedAngle(-90));
			}
			addSequential(new DriveForDistance(oppositeSideDistance));
			addSequential(new TurnToTheSpecifiedAngle(0));
			addSequential(new DriveForDistance(centerToSwitchDistance));
		}
		addSequential(new CenterOnBlob());
		addSequential(new CubeDrop());
	}
}
