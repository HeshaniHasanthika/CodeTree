/*
 * cci6 - String Compression
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3, If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
package test;

public class test {	
	
	// taken char array since strings are immutable.. creating a new string makes problem little easy so avoid!
	// slow pointer as ndx and a fast pointer to iterate
	public static String stringcompress(String s)
	{
		int count = 0;
		StringBuilder resultsb = new StringBuilder();
		String result = "";
		
		// check whether next element is same
		for(int i=0; i<s.length(); i++)
		{
			count++;
			
			// flush last character data or next char is not same
			if((i == s.length()-1) || (s.charAt(i)!=(s.charAt(i+1))))
			{
				resultsb.append(s.charAt(i));
				resultsb.append(String.valueOf(count));
				count = 0;
			}			
		}
		result = resultsb.toString();
		return s.length() < result.length()? s : result;
	}
	
	// optimization - may result in code repeat and two times loop
	// write the same function to just return the length without stringbuilder
	// at first itself compare the length and only if it reduces then use stringbuilder and construct result
	// for long strings not having repeating chars this helps 
	
	public static void main(String[] args) {
			
		System.out.println(stringcompress("abcde"));
		System.out.println(stringcompress("aaaAAbcdddddddde"));
		System.out.println(stringcompress("aaaAAbcdeeee"));
	}
}
