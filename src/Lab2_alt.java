import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.net.telnet.TelnetClient;

import telnet.ITelnetProxy;
import telnet.TaskException;
import telnet.TelnetProxy;
import model.Arena;
import model.LocationScape;
import model.MotionState;
import model.MyUtils;
import model.Robot;
import model.RobotLocation;
import model.potentialFields.*;

/**
 * Created by michael on 5/24/17.
 * 
 * Check to see if position in field has changed
 * 
 * Try matching direction of goal to 
 */
public class Lab2_alt {
    public static void main(String[] args) {
    	Lab2_alt l = new Lab2_alt();
    	ITelnetProxy proxy = new TelnetProxy();
    	try {
			proxy.connectToBot();
			LocationScape map = proxy.where();
    
			//intialize potential fields
			RobotLocation goal = map.get("3");
    	
			int height = 160;
			int width = 160;
			PotentialField field = new AttractionField(goal.getCenter(), height, width);
			
			while(true){
	    		//  get robot position
	    		try {
	    			map = proxy.where();
	    			goal = map.get("3");
	    			if (goal == null || goal.getCenter() == null) continue;
	    			
	    			if(field.getClass() == AttractionField.class) {
	    				field = new AttractionField(goal.getCenter(), height, width);
	    			} else {
	    				field = new RepulsionField(goal.getCenter(), height, width);
	    			}
					RobotLocation rob = proxy.whereRobot();
					if (rob==null||rob.getCenter()==null) continue;
					
					//  get potential field vector at robot's position
					int[] vect = rob.getPFVector(field);
					
					//Stop if at goal
					if (MyUtils.madeIt(vect))
					{
						if(field.getClass() == AttractionField.class) {
							field = new RepulsionField(goal.getCenter(), height, width);
						} else {
							field = new AttractionField(goal.getCenter(), height, width);
						}
					}
					
					double robTheta = rob.getOrientation();
					double goalTheta = rob.getGoalTheta(vect);
					
					MotionState command = MyUtils.getOrders(robTheta,goalTheta);
					
					command.run(proxy);
				} catch (Exception e) {
					e.printStackTrace();
				}
	    	}
    	} catch (TaskException e) {
			e.printStackTrace();
		}
        //end
    }
    
    public double calcTheta(double x, double y) {
    	double theta = Math.atan2(y,x);
    	if (theta < 0) theta += (2*Math.PI);
    	return theta;
    }
}
