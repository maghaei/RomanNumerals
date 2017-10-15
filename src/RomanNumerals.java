
public class RomanNumerals implements checkForRepetition{
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
			case 'I': if (array[i+1] != 'V' && array[i+1] != 'X') subtractionState = false;
				break;
			case 'X': if (array[i+1] != 'L' && array[i+1] != 'C') subtractionState = false;
				break;
			case 'C': if (array[i+1] != 'D' && array[i+1] != 'M') subtractionState = false;
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
}
