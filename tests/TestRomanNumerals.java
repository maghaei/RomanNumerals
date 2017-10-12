import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	@Test 
	public void test_IXCM_More_Than_Three_Repetitions()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//
		
		//Act
		String n = "MLCCCCIV";
		
		//Assert
		assertFalse(r.checkForIXCMRepetition(n));
	}
	
	@Test 
	public void test_IXCM_Three_Repetitions()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "MCMLXXXIV";
		
		//Assert
		assertTrue(r.checkForIXCMRepetition(n));
	}
	
	@Test 
	public void test_VLD_Repeated()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "MXVVIXC";
		
		//Assert
		assertTrue(r.isVLDRepeated(n));
	}
	
	@Test 
	public void test_VLD_Not_Repeated()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "VXILCD";
		
		//Assert
		assertFalse(r.isVLDRepeated(n));
	}
}
