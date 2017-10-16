
public class RomanNumerals{
	public int convertToInteger(String romanNum) {
		// To be Implemented
		return 0;
	}
	
	public boolean checkForIXCMRepetition(String s)
	{
		boolean repeatState = true;
		int i = 0, x = 0, c = 0,m = 0;
		
		char[] array = s.toCharArray();
		for (int j = 0; j < array.length; j++)
		{
			if (j <= array.length - 4)
			{
				char element = array[j];
				switch(element)
				{
				case 'I': if (isRepeatedThreeTimes(array, 'I', j) && array[j+3] == element) i++;
					break;
				case 'X': if (isRepeatedThreeTimes(array, 'X', j) && array[j+3] == element) x++; 
					break;
				case 'C': if (isRepeatedThreeTimes(array, 'C', j) && array[j+3] == element) c++;
					break;
				case 'M': if (isRepeatedThreeTimes(array, 'M', j) && array[j+3] == element) m++;
					break;
				default: 
					break;
				}
			}
		}
		if (i > 0 || x > 0 || c > 0 || m > 0) repeatState = false;
		return repeatState;
	}
	
	public boolean isRepeatedThreeTimes(char[] array, char ch, int index)
	{
		boolean isRepeatedMoreThanThreeTimes = false;
		if (index <= array.length - 2)
		{
			if (array[index+1] == ch && array[index+2] == ch) isRepeatedMoreThanThreeTimes = true;
		}
		return isRepeatedMoreThanThreeTimes;
	}
	
	public boolean isVLDRepeated(String s)
	{
		boolean isRepeated = false;
		int v = 0, l = 0, d = 0;
		
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++)
		{
			if (i <= array.length - 2)
			{
				char element = array[i];
				switch(element)
				{
				case 'V': if (isRepeated(array, element, i)) v++;
					break;
				case 'L': if (isRepeated(array, element, i)) l++; 
					break;
				case 'D': if (isRepeated(array, element, i)) d++;
					break;
				default: 
					break;
				}
			}
		}
		if (v > 0 || l > 0 || d > 0) isRepeated = true;
		return isRepeated;
	}
	
	public boolean isRepeated(char[] array, char ch, int index)
	{
		boolean state = false;
		if (index <= array.length - 2)
		{
			if (array[index+1] == ch) state = true;
		}
		return state;
	}
	
	public boolean hasValidSubtraction(String s)
	{
		boolean subtractionState = true;
		char[] array = s.toCharArray();
		for(int i = 0; i < array.length - 1; i++)
		{
			char ch = array[i];
			switch(ch)
			{
			case 'I': if (array[i+1] != 'V' && array[i+1] != 'X' && array[i+1] != 'I') subtractionState = false;
				break;
			case 'X': if (array[i+1] != 'L' && array[i+1] != 'C' && array[i+1] != 'I') subtractionState = false;
				break;
			case 'C': if (array[i+1] != 'D' && array[i+1] != 'M' && array[i+1] != 'I') subtractionState = false;
				break;
			default:
				break;
			}
		}
		return subtractionState;
	}
	
	public boolean hasOnlyOneSubtraction(String s)
	{
		boolean subtractionState = true;
		char[] array = s.toCharArray();
		for(int i = 2; i < array.length; i++)
		{
			char ch = array[i];
			char ch1 = array[i-1];
			char ch2 = array[i-2];
			switch(ch)
			{
			case 'V': if (ch1 == 'I' && ch2 == 'I') subtractionState = false;
				break;
			case 'X': if (ch1 == 'I' && ch2 == 'I') subtractionState = false;
				break;
			case 'L': if (ch1 == 'X' && ch2 == 'X') subtractionState = false;
				break;
			case 'C': if (ch1 == 'X' && ch2 == 'X') subtractionState = false;
			break;
			case 'D': if (ch1 == 'C' && ch2 == 'C') subtractionState = false;
			break;
			case 'M': if (ch1 == 'C' && ch2 == 'C') subtractionState = false;
			break;
			default:
				break;
			}
		}
		return subtractionState;
	}
	
	public boolean isVLDSubtracted(String s)
	{
		boolean subtractionState = false;
		char[] array = s.toCharArray();
		for(int i = 0; i < array.length - 1; i++)
		{
			char ch = array[i];
			char ch1 = array[i+1];
			switch(ch)
			{
			case 'V': if (ch1 == 'X' || ch1 == 'L' || ch1 == 'C' || ch1 == 'D' || ch1 == 'M') subtractionState = true;
				break;
			case 'L': if (ch1 == 'C' || ch1 == 'D' || ch1 == 'M') subtractionState = true;
				break;
			case 'D': if (ch1 == 'M') subtractionState = true;
			break;
			default:
				break;
			}
		}
		return subtractionState;
	}
	
	public int convertRomanToArabic(String s) throws RomanNumeralsException
	{
		int number = 0;
		char ch;
		if (!checkForIXCMRepetition(s)) throw new RomanNumeralsException("I-X-C-M wrong repetition!");
		else 
		if (isVLDRepeated(s)) throw new RomanNumeralsException("V-L-D repeated!");
		else 
		if (!hasValidSubtraction(s)) throw new RomanNumeralsException("Inavlid subtraction!");
		else 
		if (!hasOnlyOneSubtraction(s)) throw new RomanNumeralsException("More than one subtraction per numeral!");	
		else 
		if (isVLDSubtracted(s)) throw new RomanNumeralsException("V-L-D subtracted!");
		else 
		{
			int i = 0;
			char[] array = s.toUpperCase().toCharArray();
			while (i < array.length)
			{
					ch = array[i];
					switch (ch)
					{
						case 'M': number += 1000; i++;
							break;
						case 'I':
							if (i+1 < array.length)
							{
								if (array[i+1] == 'V') 
								{
									number += 4;
									i += 2;
								}
								else
								if (array[i+1] == 'X') 
								{
									number += 9;
									i += 2;
								}
								else 
								if (array[i+1] == 'I')
								{
									number++;
									i++;
								}
							}
							else
							{
								number++;
								i++;
							}
							break;
						case 'X':
							if (i+1 < array.length)
							{
								if (array[i+1] == 'L') 
								{
									number += 40;
									i += 2;
								}
								else
								if (array[i+1] == 'C') 
								{
									number += 90;
									i += 2;
								}
								else 
								{
									number += 10;
									i++;
								}	
							}
							else 
							{
								number += 10;
								i++;
							}
							break;
						case 'C':
							if (i+1 < array.length)
							{
								if (array[i+1] == 'D') 
								{
									number += 400;
									i += 2;
								}
								else
								if (array[i+1] == 'M') 
								{
									number += 900;
									i += 2;
								}
								else
								if (array[i+1] == 'C') 
								{
									number += 100;
									i++;
								}
							}
							else 
							{
								number += 100;
								i++;
							}
							break;
						case 'V':
							if (i+1 < array.length)
							{
								if (array[i+1] == 'I') 
								{
									number += 6;
									i += 2;
								}
							}
							else 
							{
								number += 5;
								i++;
							}
							break;
						case 'L': number += 50; i++;
							break;
						case 'D': number += 500; i++;
							break;
					}
			}
		}
		return number;
	}

}
