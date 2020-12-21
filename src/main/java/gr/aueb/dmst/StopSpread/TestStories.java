package gr.aueb.dmst.StopSpread;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestStories {
	private ArrayList<Integer> list;
	@Before
	public void setUp() {
		list = new ArrayList<Integer>();
	}
	@Test
	public void testStories() {
		Assert.assertEquals("failure - wrong size", list.size(), 0);
	}
	@Test
	public void testConditionOne() {
		
	}
}
