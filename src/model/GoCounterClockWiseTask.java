package model;

import telnet.ITelnetProxy;
import telnet.TaskException;

public class GoCounterClockWiseTask extends MotionState {

	
	
	
	public GoCounterClockWiseTask(double diff) {
		this.diff = (double) diff *100.0;
	}


	@Override
	public void run(ITelnetProxy proxy) {
		try {
			if (diff>30)
			{
			    proxy.speed(2, 10);
			}
			else
			{
				proxy.speed(2, 5);
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
