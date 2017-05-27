package model;

import java.util.TimerTask;

import telnet.ITelnetProxy;
import telnet.TaskException;

public class GoClockWiseTask extends MotionState {

	
	

	public GoClockWiseTask(double diff) {
		this.diff = (double) diff* 100.0;
	}

	@Override
	public void run(ITelnetProxy proxy) {
		try {
			/*
			 * if theta is smaller than pi/4
			 * bring speeds down
			 */
			if (diff>30)
			{
			    proxy.speed(7, 2);
			}
			else
			{
				proxy.speed(5, 2);
			}
			myWait();
			proxy.speed(7,7);
			myWait(1000);
	
		} catch (TaskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	

}
