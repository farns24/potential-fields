package model;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

import telnet.ITelnetProxy;

public abstract class MotionState {

	protected int angularVelocity = 8;
	protected double diff;
	public void myWait(long delay) {
StopWatch sw = new StopWatch();
		
		sw.start();
		
//		System.out.println("Delay :" + String.valueOf(delay));
		while(sw.getTime(TimeUnit.MILLISECONDS)<delay);
		sw.reset();
	}
	public void myWait()
	{
		long delay = (long) Math.abs(diff*angularVelocity);
		myWait(delay);
	}
	public abstract void run(ITelnetProxy proxy);
}
