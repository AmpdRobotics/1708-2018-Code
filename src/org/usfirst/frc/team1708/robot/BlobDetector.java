package org.usfirst.frc.team1708.robot;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;

import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;

public class BlobDetector {
// declares variables for HSV thresholds
	private int minHue;
	private int maxHue;
	private int minSat;
	private int maxSat;
	private int minValue;
	private int maxValue;
// constructor for blob detector
	public BlobDetector(int minHue, int maxHue, int minSat, int maxSat, int minValue, int maxValue) {
		this.minHue = minHue;
		this.maxHue = maxHue;
		this.minSat = minSat;
		this.maxSat = maxSat;
		this.minValue = minValue;
		this.maxValue = maxValue;

	}
//Detects blobs in image within given thresholds
	public ArrayList<Point> detect(Mat image) {
		Mat hsvMat = new Mat();
		//convert image to HSV
		Imgproc.cvtColor(image, hsvMat, Imgproc.COLOR_RGB2HSV);
		Mat mask = new Mat();
		//Outputs a mask, thresholds the input to the given ranges
		Core.inRange(hsvMat, new Scalar(this.minHue, this.minSat, this.minValue),
				new Scalar(this.maxHue, this.maxSat, this.maxValue), mask);
		ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		//finds the contours and the mask for image
		Imgproc.findContours(mask, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
		ArrayList<Point> points = new ArrayList<Point>();
		// finds the x and y points of the contours and finds centers of the contours
		for (int i = 0; i < contours.size(); i++) {
			Moments m = Imgproc.moments(contours.get(i), true);
			double x = m.get_m10() / m.get_m00();
			double y = m.get_m01() / m.get_m00();
			points.add(new Point(x, y));

		}
		return points;

	}

}
