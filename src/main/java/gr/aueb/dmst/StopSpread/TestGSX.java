package gr.aueb.dmst.StopSpread;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGSX {
	GSX obj;
	
	@Before
	public void setUp() {
		System.out.println("Starting testing of GSX.jaxa");
		obj = new GSX();
	}
	
	@Test
	public void testURLDecides() {
		assertEquals("https://covid19.gov.gr/covid19-live-analytics/",  obj.decideURL(1, 0));
		assertEquals("https://betmasters.gr/koronoios/50170-statistika-stin-ellada-prognostika/",  obj.decideURL(3, 0));
		assertEquals("https://covid19greece.com/geografiko-diamerisma/attiki",  obj.decideURL(2, 1));
		assertEquals("https://covid19greece.com/geografiko-diamerisma/ipeiros",  obj.decideURL(2, 2));
		assertEquals("https://covid19greece.com/geografiko-diamerisma/thessalia",  obj.decideURL(2, 3));
		assertEquals("https://covid19greece.com/geografiko-diamerisma/thraki",  obj.decideURL(2, 4));
		assertEquals("https://covid19greece.com/geografiko-diamerisma/kriti",  obj.decideURL(2, 5));
		assertEquals("https://covid19greece.com/geografiko-diamerisma/makedonia",  obj.decideURL(2, 6));
		assertEquals( "https://covid19greece.com/geografiko-diamerisma/nisia-aigaioy-pelagoys",  obj.decideURL(2, 7));
		assertEquals("https://covid19greece.com/geografiko-diamerisma/nisia-ionioy-pelagoys",  obj.decideURL(2, 8));
		assertEquals("https://covid19greece.com/geografiko-diamerisma/peloponnisos",  obj.decideURL(2, 9));
		assertEquals("https://covid19greece.com/geografiko-diamerisma/sterea-ellada",  obj.decideURL(2, 10));
		assertEquals("exit",  obj.decideURL(2, 11));
		
	}
	
	
	@After
	public void finish() {
		System.out.println("Finished testing of GSX.jaxa");
	}
}
