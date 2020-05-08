/*
String Rotation; Assume you have a method i s S u b s t r i n g which checks if one word is a substring
of another. Given two strings, si and s2, write code to check if s2 is a rotation of si using only one
call to i s S u b s t r i n g [e.g., "water b o t t l e " is a rotation of  ' e r b o t t l e w a t " )

Ah ! I remember seeing similar trick before.. but looking at pattern it is easy to come up and a common trick
"erbottlewat" should be present in two times concatenated "waterbottlewaterbottle"
 */

package test;

public class test {	
	
	public static boolean isRotation(String s1, String s2)
	{
		String twice = s1 + s1;
		// write this yourself.. for now im bored leave it !
		return twice.contains(s2);
	}
	
	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "lewaterbott"));
		System.out.println(isRotation("waterbottle", "leewaterbott"));
	}
}