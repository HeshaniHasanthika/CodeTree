/*
Given a string containing only three types of characters: '(', ')' and '*', write a function to 
check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.

An empty string is also valid.

Example 1:
Input: "()"
Output: True

Example 2:
Input: "(*)"
Output: True

Example 3:
Input: "(*))"
Output: True
*/
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack();
        Stack<Integer> star = new Stack();
        
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                open.push(i);
            }else if(c == '*')
            {
                star.push(i);
            }else{
                if(!open.isEmpty())
                    open.pop();
                else if(!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }
        
        while(!open.isEmpty())
        {
            if(star.isEmpty() || open.peek() > star.peek())
                return false;
            else{
                open.pop();
                star.pop();
            }
        }
        
        return true;
    }
}