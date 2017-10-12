import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test //(expected = RomanNumeralsException.class)
	public void test_is_there_more_than_three_repetitions()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//
		
		//Act
		String n = "MCMLXXXXIV";
		
		//Assert
		assertFalse(r.checkForRepetition(n));
	}
	
	@Test //(expected = RomanNumeralsException.class)
	public void test_is_there_three_repetitions()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "MCMLXXXIV";
		
		//Assert
		assertTrue(r.checkForRepetition(n));
	}
}
