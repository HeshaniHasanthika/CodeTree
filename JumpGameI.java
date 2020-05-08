/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Example 1:
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
*/

class Solution {
    public boolean canJumpV1(int[] nums)
    {
        return canJumpRecV1(nums, 0);
    }
    
    public boolean canJumpRecV1(int[] nums, int ndx)
    {
        if(ndx == nums.length-1)
            return true;
        
        for(int i=1; i<=nums[ndx]; i++)
        {
            if((ndx+i) < nums.length && canJumpRecV1(nums, ndx+i))
                return true;
        }
        
        return false;
    }
    
   
    public boolean canJumpV2(int[] nums) {
        // dp array
        boolean possible[] = new boolean[nums.length];
        possible[nums.length-1] = true;
        
        for(int i=nums.length-2; i>=0; i--)
        {
            for(int k=0; k<=nums[i]; k++)
            {
                if(possible[i+k] == true)
                {
                    possible[i] = true;
                    break;
                }
            }
        }
        return possible[0];
    }
    
    public boolean canJump(int[] nums) {
        // greedy approach
        // bottom up .. ie right to left
        // keep updating the good/reachable position(from this we can reach end) while going right
        // and see if it is 0 ..ie if 0 is good 
        
        int lastReachable = nums.length-1;
        for(int i=nums.length-1; i>=0; i--)
        {
            // if i can go greater than reachable, i can go to reachable also
            // since count is all possible steps upto that count
            if(i + nums[i] >= lastReachable){
                lastReachable = i;
            }
        }
        return lastReachable == 0;
    }
}