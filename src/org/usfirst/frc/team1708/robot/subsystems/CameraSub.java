package org.usfirst.frc.team1708.robot.subsystems;

import java.util.Collections;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team1708.robot.Blob;
import org.usfirst.frc.team1708.robot.BlobDetector;
import org.usfirst.frc.team1708.robot.RobotMap;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class CameraSub extends Subsystem {
	private Thread visionThread;
	private BlobDetector detector;
	private UsbCamera camera;

	public CameraSub() {
		detector = new BlobDetector(39,97,205,255,34,255);
		camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(320, 240);
        camera.setFPS(1);
        camera.setExposureManual(1);
        CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 320, 240);
        visionThread = new VisionThread(camera, detector, pipeline -> {
        	Mat mask = pipeline.getMask();
        	Blob biggestBlob = pipeline.getBiggestBlob();
        	if (biggestBlob != null){
        		Imgproc.circle(mask, biggestBlob.getCenter(), 6, new Scalar(120));
        	}
        	outputStream.putFrame(mask);
        	
        });
    	visionThread.start();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Blob getBiggestBlob(){
    	return detector.getBiggestBlob();
    }
    
    public Size getResolution(){
    	return new Size(320, 240);
    }
}

