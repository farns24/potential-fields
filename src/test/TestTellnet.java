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
	
	@Test
	public void testSpinner(){
proxy = new TelnetProxy();
		
		try {
			proxy.connectToBot();
			proxy.speed(1, -1);
			proxy.speed(2, -2);
			proxy.speed(3, -3);
			proxy.speed(4, -4);
			proxy.speed(5, -5);
			proxy.speed(6, -6);
			proxy.speed(7, -7);
			proxy.speed(8, -8);
			proxy.speed(9, -9);
			proxy.speed(10, -10);
			proxy.speed(1, -1);
			proxy.speed(2, -2);
			proxy.speed(3, -3);
			proxy.speed(4, -4);
			proxy.speed(5, -5);
			proxy.speed(6, -6);
			proxy.speed(7, -7);
			proxy.speed(8, -8);
			proxy.speed(9, -9);
			proxy.speed(10, -10);
			proxy.speed(1, -1);
			proxy.speed(2, -2);
			proxy.speed(3, -3);
			proxy.speed(4, -4);
			proxy.speed(5, -5);
			proxy.speed(6, -6);
			proxy.speed(7, -7);
			proxy.speed(8, -8);
			proxy.speed(9, -9);
			proxy.speed(10, -10);
			proxy.speed(1, -1);
			proxy.speed(2, -2);
			proxy.speed(3, -3);
			proxy.speed(4, -4);
			proxy.speed(5, -5);
			proxy.speed(6, -6);
			proxy.speed(7, -7);
			proxy.speed(8, -8);
			proxy.speed(9, -9);
			proxy.speed(10, -10);
			proxy.speed(1, -1);
			proxy.speed(2, -2);
			proxy.speed(3, -3);
			proxy.speed(4, -4);
			proxy.speed(5, -5);
			proxy.speed(6, -6);
			proxy.speed(7, -7);
			proxy.speed(8, -8);
			proxy.speed(9, -9);
			proxy.speed(0, 0);
		} catch (TaskException e) {
			
			e.printStackTrace();
			fail("Failed to connect");
		}
	}

}
