
package org.usfirst.frc.team1708.robot;

import org.usfirst.frc.team1708.robot.commands.AutoDriveToLine;
import org.usfirst.frc.team1708.robot.commands.AutoScoreSwitch;
import org.usfirst.frc.team1708.robot.commands.AutoScoreSwitch.FieldPosition;
import org.usfirst.frc.team1708.robot.commands.CenterOnBlob;
import org.usfirst.frc.team1708.robot.commands.GoToScaleHighLevel;
import org.usfirst.frc.team1708.robot.commands.GoToScaleLowLevel;
import org.usfirst.frc.team1708.robot.commands.GoToScaleMediumLevel;
import org.usfirst.frc.team1708.robot.commands.GoToSwitchLevel;
import org.usfirst.frc.team1708.robot.commands.TurnToTheSpecifiedAngle;
import org.usfirst.frc.team1708.robot.commands.ZeroElevator;
import org.usfirst.frc.team1708.robot.subsystems.CameraSub;
import org.usfirst.frc.team1708.robot.subsystems.ClawSub;
import org.usfirst.frc.team1708.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1708.robot.subsystems.ElevatorSub;
import org.usfirst.frc.team1708.robot.subsystems.RampsSub;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Drivetrain drivetrain = new Drivetrain();
	public static ElevatorSub elevatorSub = new ElevatorSub();
	public static ClawSub clawSub = new ClawSub();
	public static RampsSub rampsSub = new RampsSub();
	public static CameraSub cameraSub = new CameraSub();
	public static boolean isEndGame = false;

	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> autonomousChooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		oi = new OI();

		setUpSmartDashboardAutonomous();
		setUpSmartDashboardSubsystems();
		setUpSmartDashboardCommands();

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = autonomousChooser.getSelected();
		Scheduler.getInstance().add(new ZeroElevator());

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		Scheduler.getInstance().add(new ZeroElevator());

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}

	private void setUpSmartDashboardAutonomous() {
		autonomousChooser.addDefault("Drive to line", new AutoDriveToLine());
		autonomousChooser.addObject("Left Switch Auto", new AutoScoreSwitch(FieldPosition.left));
		autonomousChooser.addObject("Center Switch Auto", new AutoScoreSwitch(FieldPosition.center));
		autonomousChooser.addObject("Right Switch Auto", new AutoScoreSwitch(FieldPosition.right));

		SmartDashboard.putData("Autonomous", autonomousChooser);

	}

	private void setUpSmartDashboardSubsystems() {
		SmartDashboard.putData(drivetrain);
		SmartDashboard.putData(clawSub);
		SmartDashboard.putData(elevatorSub);
		SmartDashboard.putData(rampsSub);
		SmartDashboard.putData(cameraSub);
	}

	private void setUpSmartDashboardCommands() {
		SmartDashboard.putData(Scheduler.getInstance());

		SmartDashboard.putData("Turn Right", new TurnToTheSpecifiedAngle(90));
		SmartDashboard.putData("Turn Left", new TurnToTheSpecifiedAngle(-90));
		SmartDashboard.putData("Elevator Switch", new GoToSwitchLevel());
		SmartDashboard.putData("Elevator Low", new GoToScaleLowLevel());
		SmartDashboard.putData("Elevator Med", new GoToScaleMediumLevel());
		SmartDashboard.putData("Elevator High", new GoToScaleHighLevel());
		SmartDashboard.putData("Elevator Ground", new ZeroElevator());
		SmartDashboard.putData("Center on Blob", new CenterOnBlob());

		SmartDashboard.putData(new ZeroElevator());
	}
}
