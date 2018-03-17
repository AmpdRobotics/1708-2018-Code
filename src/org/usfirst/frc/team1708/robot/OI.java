package org.usfirst.frc.team1708.robot;

import org.usfirst.frc.team1708.robot.commands.CenterOnBlob;
import org.usfirst.frc.team1708.robot.commands.CloseClaw;
import org.usfirst.frc.team1708.robot.commands.CubeOuttake;
import org.usfirst.frc.team1708.robot.commands.DropCube;
import org.usfirst.frc.team1708.robot.commands.GoToScaleHighLevel;
import org.usfirst.frc.team1708.robot.commands.GoToScaleLowLevel;
import org.usfirst.frc.team1708.robot.commands.GoToScaleMediumLevel;
import org.usfirst.frc.team1708.robot.commands.GoToSwitchLevel;
import org.usfirst.frc.team1708.robot.commands.IntakeAndClose;
import org.usfirst.frc.team1708.robot.commands.IntakeCube;
import org.usfirst.frc.team1708.robot.commands.ManualIntake;
import org.usfirst.frc.team1708.robot.commands.OpenCloseClaw;
import org.usfirst.frc.team1708.robot.commands.RaiseRamp;
import org.usfirst.frc.team1708.robot.commands.RampRelease;
import org.usfirst.frc.team1708.robot.commands.ShiftHighGear;
import org.usfirst.frc.team1708.robot.commands.ShiftLowGear;
import org.usfirst.frc.team1708.robot.commands.ZeroElevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	public static final int CONTROLLER_A_BUTTON = 2;
	public static final int CONTROLLER_B_BUTTON = 3;
	public static final int CONTROLLER_X_BUTTON = 1;
	public static final int CONTROLLER_Y_BUTTON = 4;
	public static final int CONTROLLER_START_BUTTON = 10;
	public static final int CONTROLLER_BACK_BUTTON = 9;
	public static final int CONTROLLER_LEFT_BUMPER = 5;
	public static final int CONTROLLER_RIGHT_BUMPER = 6;

	public Joystick joystickDrive = new Joystick(0);
	public Joystick mechanisms = new Joystick(1);

	public OI() {
		Button shiftHigh = new JoystickButton(joystickDrive, CONTROLLER_B_BUTTON);
		Button shiftLow = new JoystickButton(joystickDrive, CONTROLLER_Y_BUTTON);
		Button dropRamp = new JoystickButton(joystickDrive, CONTROLLER_START_BUTTON);
		Button raiseRight = new JoystickButton(joystickDrive, CONTROLLER_RIGHT_BUMPER);
		Button raiseLeft = new JoystickButton(joystickDrive, CONTROLLER_LEFT_BUMPER);

		Button centerOnBlob = new JoystickButton(joystickDrive, 2);

		Button lowScaleHeight = new JoystickButton(mechanisms, 1);
		Button mediumScaleHeight = new JoystickButton(mechanisms, 2);
		Button highScaleHeight = new JoystickButton(mechanisms, 3);
		Button intakeManual = new JoystickButton(mechanisms, 4);
		Button switchHeight = new JoystickButton(mechanisms, 5);
		Button zeroElevator = new JoystickButton(mechanisms, 6);

		Button cubeIntake = new JoystickButton(mechanisms, 7);
		Button cubeOuttake = new JoystickButton(mechanisms, 8);
		Button openClaw = new JoystickButton(mechanisms, 9);
		Button closeClaw = new JoystickButton(mechanisms, 10);

		// just to test command
		Button openThenCloseClaw = new JoystickButton(joystickDrive, CONTROLLER_A_BUTTON);

		//// TRIGGERING COMMANDS WITH BUTTONS
		// Once you have a button, it's trivial to bind it to a button in one of
		// three ways:

		// Start the command when the button is pressed and let it run the
		// command
		// until it is finished as determined by it's isFinished method.
		// button.whenPressed(new ExampleCommand());

		// Run the command while the button is being held down and interrupt it
		// once
		// the button is released.
		// button.whileHeld(new ExampleCommand());

		// Start the command when the button is released and let it run the
		// command
		// until it is finished as determined by it's isFinished method.
		// button.whenReleased(new ExampleCommand());
		switchHeight.whenPressed(new GoToSwitchLevel());
		highScaleHeight.whenPressed(new GoToScaleHighLevel());
		lowScaleHeight.whenPressed(new GoToScaleLowLevel());
		mediumScaleHeight.whenPressed(new GoToScaleMediumLevel());
		// groundLevelHeight.whenPressed(new GoToGroundLevel());
		zeroElevator.whenPressed(new ZeroElevator());

		shiftHigh.whenPressed(new ShiftHighGear());
		shiftLow.whenPressed(new ShiftLowGear());
		dropRamp.whenPressed(new RampRelease());
		raiseRight.whenPressed(new RaiseRamp(Robot.rightRampsSub));
		raiseLeft.whenPressed(new RaiseRamp(Robot.leftRampsSub));
		centerOnBlob.whileHeld(new CenterOnBlob());
		cubeOuttake.whileHeld(new CubeOuttake());
		cubeIntake.whenPressed(new IntakeAndClose());
		openClaw.whenPressed(new DropCube());
		closeClaw.whenPressed(new CloseClaw());
		intakeManual.whileHeld(new ManualIntake());

		openThenCloseClaw.whenPressed(new OpenCloseClaw());

	}
}
