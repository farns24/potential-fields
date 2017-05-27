package test;

import static org.junit.Assert.*;
import model.GoClockWiseTask;
import model.GoCounterClockWiseTask;
import model.MotionState;
import model.MyUtils;

import org.junit.Test;

public class TestUtils {

	@Test
	public void test1stTo4th() {
		MotionState order = MyUtils.getDirection(1.24323187564975, 4.969712695355779);
		assertTrue(order instanceof GoClockWiseTask);
	}
	
	@Test
	public void test4thTo1st() {
		MotionState order = MyUtils.getDirection(4.969712695355779,1.24323187564975);
		assertTrue(order instanceof GoCounterClockWiseTask);
	}
	
	@Test
	public void test1stTo2nd() {
		MotionState order = MyUtils.getDirection(1.24323187564975, 2.6);
		assertTrue(order instanceof GoCounterClockWiseTask);
	}
	
	@Test
	public void test2ndTo1st() {
		MotionState order = MyUtils.getDirection(2.6,1.24323187564975);
		assertTrue(order instanceof GoClockWiseTask);
	}
	
	@Test
	public void test3rdTo2nd() {
		MotionState order = MyUtils.getDirection(3.9, 2.6);
		assertTrue(order instanceof GoClockWiseTask);
	}
	
	@Test
	public void test2ndTo3rd() {
		MotionState order = MyUtils.getDirection(2.6, 3.9);
		assertTrue(order instanceof GoCounterClockWiseTask);
	}
	
	@Test
	public void test3rdTo4th() {
		MotionState order = MyUtils.getDirection(3.9, 4.96);
		assertTrue(order instanceof GoCounterClockWiseTask);
	}
	
	@Test
	public void test4thTo3rd() {
		MotionState order = MyUtils.getDirection(4.96, 3.9);
		assertTrue(order instanceof GoClockWiseTask);
	}
	
	

}
