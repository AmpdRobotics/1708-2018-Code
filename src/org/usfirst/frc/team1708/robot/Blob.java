package org.usfirst.frc.team1708.robot;
import javax.swing.Icon;

import org.opencv.core.Point;

public class Blob implements Comparable<Blob>{
	private Point center;
	private double size;
	
	public Blob(Point center, double size){
		this.center = center;
		this.size = size;
	}
	
	public Point getCenter(){
		return center;
	}
	
	public double getSize(){
		return size;
	}

	@Override
	public int compareTo(final Blob b) {
		return Double.compare(this.size, b.getSize());
	}
}
