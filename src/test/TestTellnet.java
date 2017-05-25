package test;

import static org.junit.Assert.*;
import model.LocationScape;
import model.RobotLocation;

import org.junit.Test;

import telnet.ITelnetProxy;
import telnet.TaskException;
import telnet.TelnetProxy;

public class TestTellnet {

	private ITelnetProxy proxy;
	@Test
	public void testConnect() {
		proxy = new TelnetProxy();
		
		try {
			proxy.connectToBot();
			proxy.speed(-3, 3);
			LocationScape location = proxy.where();
			
			assertTrue(location.containsKey("robot"));
			
			RobotLocation roboLocat = proxy.whereRobot();
			roboLocat.getCorners();
		} catch (TaskException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Failed to connect");
		}
	}

}
