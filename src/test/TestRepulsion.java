package test;

import static org.junit.Assert.*;
import model.potentialFields.RepulsionField;

import org.junit.Test;

public class TestRepulsion {

	@Test
	public void test() {
		RepulsionField rf = new RepulsionField(new int[]{15,15}, 30, 30);
		rf.printArrows();
	}

}
