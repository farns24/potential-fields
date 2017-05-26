import java.util.ArrayList;
import java.util.Timer;

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
public class Lab2 {
    public static void main(String[] args) {
        //Main
        //
    	
    	ITelnetProxy proxy = new TelnetProxy();
    	try {
			proxy.connectToBot();
			LocationScape map = proxy.where();
		
			RobotLocation bot = map.get("robot");
    
			//intialize potential fields
			RobotLocation goal = map.get("3");
    	
			ArrayList<PotentialField> fields = new ArrayList<PotentialField>();
			int height = 160;
			int width = 160;
			AttractionField aF = new AttractionField(goal.getCenter(), height, width);
			fields.add(aF);
			
			for (String key :map.keySet())
			{
				RobotLocation loc = map.get(key);
				
				if (key.equals("robot"))
				{
					continue;
				}
				RepulsionField rF = new RepulsionField(loc.getCenter(), height, width);
				fields.add(rF);
			}
			
			CompositeField field = new CompositeField(height, width, fields);
		
	        //while (true)
	    	while(true){
	        //  get robot position
	    		RobotLocation rob = proxy.whereRobot();
	    		 if (rob==null||rob.getCenter()==null)
	    		 {
	    			 continue;
	    		 }
	        //  get potential field vector at robot's position
	    		int[] vect = rob.getPFVector(field);
	    		
	    		if (MyUtils.madeIt(vect))
	    		{
	    			proxy.speed(0, 0);
	    			break;
	    		}
	    		
	    		double robTheta = rob.getOrientation();
	    		double goalTheta = rob.getGoalTheta(vect);
	    		
	    		MotionState command = MyUtils.getOrders(robTheta,goalTheta);

	    		command.run(proxy);


	        //  set robots orientation and speed determined from vector
	        //  if robots speed is 0 and not at goal
	        //      get random field vector at robot's position
	        //      set robots orientation and speed determined from vector
	    	}
    	} catch (TaskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //end
    }
}
