/*
150
Palindrome String
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/
// editorial has the same approach ..
public class Solution {
    public int isPalindrome(String A) {
        // i can push the whole string to a stack and compare
        // or use two pointers
        // full scan required? since i dont know of special chars and spaces to know mid
        // exit when when start = end? 
        int start = 0;
        int end = A.length()-1;
        while(start<=(A.length()-1) && end>=0)
        {
            if(!isValidAlphaNum(A.charAt(start)))
            {
                start++;
                continue;
            }
            
            if(!isValidAlphaNum(A.charAt(end)))
            {
                end--;
                continue;
            }
            
            if(Character.toLowerCase(A.charAt(start))==(Character.toLowerCase(A.charAt(end))))
            {
                start++;
                end--;
                continue;
            }else{
                return 0;
            }
        }
        return 1;
    }
    
    public boolean isValidAlphaNum(char c)
    {
        if((c >= 'a' && c <= 'z')||(c >= 'A' && c <='Z')||(c >= '0' && c <='9'))
            return true;
        else 
            return false;
    }
}

