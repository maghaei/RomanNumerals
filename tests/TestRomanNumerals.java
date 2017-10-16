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
	
	@Test 
	public void test_Not_Valid_Subtraction()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "CMXVLIIX";
		
		//Assert
		assertFalse(r.hasValidSubtraction(n));
	}
	
	@Test 
	public void test_Valid_Subtraction()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "MCMXLI";
		
		//Assert
		assertTrue(r.hasValidSubtraction(n));
	}
	
	@Test 
	public void test_Two_Subtraction_Per_Numeral()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "CMXLIIX";
		
		//Assert
		assertFalse(r.hasOnlyOneSubtraction(n));
	}
	
	@Test 
	public void test_One_Subtraction_Per_Numeral()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "CDXLV";
		
		//Assert
		assertTrue(r.hasOnlyOneSubtraction(n));
	}
	
	@Test 
	public void test_VLD_Can_Not_Be_Subtracted()
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "LCDM";
		
		//Assert
		assertTrue(r.isVLDSubtracted(n));
	}
	
	@Test 
	public void test_Convert_Roman_To_Arabic() throws RomanNumeralsException
	{
		//Arrange
		RomanNumerals r = new RomanNumerals();
		
		//Act
		String n = "MCMXIII";
		
		//Assert
		assertEquals(1913, r.convertRomanToArabic(n));
	}
}
