
public class RomanNumerals implements checkForRepetition{
	public int convertToInteger(String romanNum) {
		// To be Implemented
		return 0;
	}
	
	public boolean checkForRepetition(String s)
	{
		boolean state = true;
		int i = 0, x = 0, c = 0,m = 0;
		
		char[] array = s.toCharArray();
		for (int j = 0; j < array.length; j++)
		{
			if (j <= array.length - 3)
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
		if (i > 0 || x > 0 || c > 0 || m > 0) state = false;
		return state;
	}
	
	public boolean isRepeatedThreeTimes(char[] array, char ch, int index)
	{
		boolean state = false;
		if (index <= array.length - 2)
		{
			if (array[index+1] == ch && array[index+2] == ch) state = true;
		}
		return state;
	}
}
