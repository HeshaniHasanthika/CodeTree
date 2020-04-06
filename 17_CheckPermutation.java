/*
 * cci2 - check permutation
 * Given two strings, check if one is permutation of another
 * 
 * hint 1 : describe what is permutation
 * two approaches for different constraints
 * hint 2 : hashtable (with extra space and O(n) time)
 * hint 3 : same elements but in different order substring (Without extra space but O(nlogn) time
 * given order valid ? should second be checked against first. If not so check length of strings and find which to compare against which
 * what is permutation? logically same number of same chars of second string should be present in first. so hashtable ? (or a vector containing count)
 */
package test;

import java.util.Arrays;

public class test {	
	
	// instead of hashmap we can use integer array
	public static boolean isPermutationV1(String s1, String s2)
	{
		int[] charcount = new int[128];
		
		// update count of s1
		for(int i=0; i<s1.length(); i++)
		{
			charcount[s1.charAt(i)]++;
		}
		
		// check in charcount array from s2
		for(int i=0; i<s2.length(); i++)
		{
			if(charcount[s2.charAt(i)] == 0)
				return false;
			else
				charcount[s2.charAt(i)]--;
		}
		return true;
	}
	
	public static boolean isPermutationV2(String s1, String s2)
	{
		// if not of same length then not permutation strings since all chars are not present!
		if(s1.length() != s2.length())
			return false;
		
		s1 = stringsort(s1);
		s2 = stringsort(s2);
		
		if(s1.equals(s2))
			return true;
		else
			return false;		
	}
	
	// utility method .. no string sort default methods in java
	public static String stringsort(String s)
	{
		// can also return String.valueOf(chars) .. which is better? why?
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPermutationV1("abcdde", "edcdba"));
		System.out.println(isPermutationV1("abcdde", "abcddde"));
		System.out.println(isPermutationV1("abcdde", "abccde"));
		
		System.out.println(isPermutationV2("abcdde", "edcdba"));
		System.out.println(isPermutationV2("abcdde", "abcddde"));
		System.out.println(isPermutationV2("abcdde", "abccde"));
	}
}
