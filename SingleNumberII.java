/*
137. Single Number II
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
*/

// constant space - so we can use a 32 bit array to keep count of all bit occurances
// this space is constant for length of input, if we use hashmap to count then its space becomes O(n)
// use mod operations to eliminate repeated bits
class Solution {
    public int singleNumber(int[] nums) {
        int[] bitcount = new int[32];
        int result = 0;
        for(int i=0; i<nums.length; i++)
        {
            for(int k=0; k<32; k++)
            {
                if(((nums[i] >> k) & 1) == 1)
                {
                    bitcount[k]++;
                    bitcount[k] %= 3;
                }
            }
        }
        //System.out.println(Arrays.toString(bitcount));
        for(int i=0; i<32; i++)
        {
            result |= (bitcount[i]<<i);
        }
        return result;
    }
}