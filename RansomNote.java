/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; 
otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap();
        for(int i=0; i<magazine.length(); i++)
        {
            char c = magazine.charAt(i);
            map.put(c , map.getOrDefault(c, 0) + 1);
        }
        
        for(int i=0; i<ransomNote.length(); i++)
        {
            char c = ransomNote.charAt(i);
            if(map.getOrDefault(c, 0) != 0)
                map.put(c, map.get(c) - 1);
            else
                return false;
        }
        return true;
    }
}