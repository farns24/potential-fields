import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
        String goalID = "3";
    	ITelnetProxy proxy = new TelnetProxy();
    	try {
			proxy.connectToBot();
			LocationScape map = proxy.where();
    
			//initialize potential fields
			ArrayList<PotentialField> fields = new ArrayList<PotentialField>();
			int height = 160;
			int width = 160;
			RobotLocation goal = map.get(goalID);	//Goal location
			AttractionField aF = new AttractionField(goal.getCenter(), height, width);
			fields.add(aF);
			//aF.printArrows();
			for (String key :map.keySet())
			{
				RobotLocation loc = map.get(key);
				
				if (key.equals("robot") || key.equals(goalID))
				{
					continue;	//Ignore robot and goal markers
				}
				RepulsionField rF = new RepulsionField(loc.getCenter(), height, width);	//Add obstacles
				rF.printArrows();
				fields.add(rF);
			}
			
			CompositeField field = new CompositeField(height, width, fields);
			
	    	while(true){
	    		//  get robot position
	    		try {
					RobotLocation rob = proxy.whereRobot();
					if (rob==null||rob.getCenter()==null)
					{
						continue;
					}
					
					//  get potential field vector at robot's position
					int[] vect = rob.getPFVector(field);
					
					//Stop if at goal
					if (MyUtils.madeIt(vect))
					{
						proxy.speed(0, 0);
						break;
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
}
