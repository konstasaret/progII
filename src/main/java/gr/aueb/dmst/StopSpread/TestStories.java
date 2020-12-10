package gr.aueb.dmst.StopSpread;

import gr.aueb.dmst.StopSpread.Stories;
import org.junit.Test;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Assert;

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
}
