package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoScoreSwitch extends CommandGroup {
	public enum FieldPosition {
		left, center, right
	};

	private double robotToSwitchDistance = 8.3; // 11.5 feet to switch - 38" robot length
	private double oppositeSideDistance = 6; // feet
	private double centerTimeoutSeconds = 2;

	private double timeoutMultiplier = 1.0 / 2.67; // 2.67 fps with a little
													// overestimation
	private double turnTimeoutSeconds = 2;

	private double centerToSwitchDistance = robotToSwitchDistance * .5;
	private double centerToSideDistance = oppositeSideDistance * .5;

	public AutoScoreSwitch(FieldPosition robot_position) {
		FieldPosition switch_position = getSwitchPosition();
		addSequential(new CloseClaw());
		addSequential(new ShiftHighGear());
		// Drive to the halfway point between the wall and the switch
		addSequential(new DriveForDistance(centerToSwitchDistance), centerToSwitchDistance * timeoutMultiplier);

		// If we are on the same side as the switch, drive half
		if (switch_position != robot_position) {
			// Turn to face the direction of the switch

			double turn_angle = (switch_position == FieldPosition.left) ? -90 : 90;
			addSequential(new TurnToTheSpecifiedAngle(turn_angle), turnTimeoutSeconds);

			// Drive to the switch side of the field
			if (robot_position == FieldPosition.center) {
				addSequential(new DriveForDistance(centerToSideDistance), centerToSideDistance * timeoutMultiplier);
			} else {
				addSequential(new DriveForDistance(oppositeSideDistance), oppositeSideDistance * timeoutMultiplier);
			}
		
			// Turn to face the switch
			addSequential(new TurnToTheSpecifiedAngle(-turn_angle), turnTimeoutSeconds);
		}

		// Center on the switch
		addSequential(new CenterOnBlob(), centerTimeoutSeconds);

		addSequential(new GoToSwitchLevel(), 1); // remove timeout once bearings
													// are fixed

		// Drive the rest of the way to the switch
		addSequential(new DriveForDistance(centerToSwitchDistance), centerToSwitchDistance * timeoutMultiplier);

		// Drop the cube
		addSequential(new DropCube());
		addSequential(new CubeOuttake(.2), 1);
		addSequential(new WaitCommand(), 1);
		addSequential(new DriveForDistance(-1), 1*timeoutMultiplier);
	}

	public FieldPosition getSwitchPosition() {
		String gameSpecificMessage = DriverStation.getInstance().getGameSpecificMessage();
		if (gameSpecificMessage.length() == 0) {
			return FieldPosition.left;
		}
		char closestSwitch = gameSpecificMessage.charAt(0);
		if (closestSwitch == 'L')
			return FieldPosition.left;
		else
			return FieldPosition.right;
	}
}
