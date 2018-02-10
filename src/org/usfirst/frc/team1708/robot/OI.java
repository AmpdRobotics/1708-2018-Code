package org.usfirst.frc.team1708.robot;

import org.usfirst.frc.team1708.robot.commands.CenterOnBlob;
import org.usfirst.frc.team1708.robot.commands.GoToGroundLevel;
import org.usfirst.frc.team1708.robot.commands.GoToScaleHighLevel;
import org.usfirst.frc.team1708.robot.commands.GoToScaleLowLevel;
import org.usfirst.frc.team1708.robot.commands.GoToScaleMediumLevel;
import org.usfirst.frc.team1708.robot.commands.GoToSwitchLevel;
import org.usfirst.frc.team1708.robot.commands.JoystickDrive;
import org.usfirst.frc.team1708.robot.commands.ShiftHighGear;
import org.usfirst.frc.team1708.robot.commands.ShiftLowGear;

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
	public Joystick joystickDrive = new Joystick(0);

	public OI() {
//		Button switchHeight = new JoystickButton(joystickDrive, 2);
//		Button shiftHigh = new JoystickButton(joystickDrive, 3);
		Button ddrForward = new JoystickButton(joystickDrive, 3);
		Button shiftLow = new JoystickButton(joystickDrive, 4);
		Button lowScaleHeight = new JoystickButton(joystickDrive, 5);
		Button mediumScaleHeight = new JoystickButton(joystickDrive, 6);
		Button highScaleHeight = new JoystickButton(joystickDrive, 7);
		Button groundLevelHeight = new JoystickButton(joystickDrive, 8);
		
		Button centerOnBlob = new JoystickButton(joystickDrive, 2);
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
		//switchHeight.whenPressed(new GoToSwitchLevel());
		highScaleHeight.whenPressed(new GoToScaleHighLevel());
		lowScaleHeight.whenPressed(new GoToScaleLowLevel());
		mediumScaleHeight.whenPressed(new GoToScaleMediumLevel());
		groundLevelHeight.whenPressed(new GoToGroundLevel());
		//shiftHigh.whenPressed(new ShiftHighGear());
		shiftLow.whenPressed(new ShiftLowGear());
		ddrForward.whileHeld(new JoystickDrive());
		centerOnBlob.whileHeld(new CenterOnBlob());


	}
}
