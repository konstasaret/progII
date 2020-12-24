package gr.aueb.dmst.StopSpread;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class TestInputs {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void isNumWithinBounds() throws IOException {
		// Inputs check = new Inputs();
		assertEquals(5, Inputs.rangeInt(1, 10));
	}

	@Test
	public void testIntWithinBounds() throws IOException {
		// Inputs input = new Inputs();

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number");
		int lowNum = sc.nextInt();
		int uppNum = sc.nextInt();
		assertEquals(5, Inputs.rangeInt(lowNum, uppNum));
		sc.close();
	}

	/*
	 * public String mes = "yes";
	 * 
	 * @Test(expected = ArithmeticException.class) public void testExceptions() {
	 * System.out.println("JUnit message prints:" + mes);
	 * 
	 * }
	 */
}
