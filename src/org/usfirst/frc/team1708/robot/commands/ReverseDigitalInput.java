package org.usfirst.frc.team1708.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;

public class ReverseDigitalInput extends DigitalInput{

	public ReverseDigitalInput(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}
	
	public boolean get() {
		return ! super.get();
	}

}
