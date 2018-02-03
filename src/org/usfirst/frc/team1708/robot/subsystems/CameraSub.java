package org.usfirst.frc.team1708.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CameraSub extends Subsystem {
	public CameraSub() {
        new Thread(new Runnable() {
			@Override
			public void run() {
			    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			    camera.setResolution(640, 480);
			    
			    CvSink cvSink = CameraServer.getInstance().getVideo();
			    CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
			    
			    Mat source = new Mat();
			    Mat output = new Mat();
			    System.out.println("Before grabbing image");
			    while(!Thread.interrupted()) {
			    	System.out.println("grabbing image");
			        cvSink.grabFrame(source);
			        Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
			        outputStream.putFrame(output);
			    }
			    System.out.println("after grabbing image");
			}
		}).start();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

