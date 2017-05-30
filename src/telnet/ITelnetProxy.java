package telnet;

import model.LocationScape;
import model.RobotLocation;

/**
 * Telnet Proxy commands
 * @author wolfa
 *
 */
public interface ITelnetProxy {
	/**
	 * Connects to the robot
	 * @throws TaskException
	 */
	public void connectToBot() throws TaskException;
	
	/**
	 * Sets the speed of the robot's wheels 
	 * @param left
	 * @param right
	 * @throws TaskException
	 */
	public void speed(int left,int right) throws TaskException ;
	
	/**
	 * Finds the location of all 
	 * @return
	 * @throws TaskException
	 */
	public LocationScape where() throws TaskException;
	
	public RobotLocation whereRobot() throws TaskException;
	
	public LocationScape whereOthers() throws TaskException;
	
	public void shutdown() throws TaskException;
}
