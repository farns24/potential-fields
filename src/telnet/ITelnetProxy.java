package telnet;

import model.LocationScape;
import model.RobotLocation;

/**
 * Telnet Proxy commands
 * @author wolfa
 *
 */
public interface ITelnetProxy {
	public void connectToBot();
	
	public void speed(double left,double right);
	
	public LocationScape where();
	
	public RobotLocation whereRobot();
	
	public LocationScape whereOthers();
	
	public void shutdown();
}
