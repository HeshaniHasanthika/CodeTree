/*
53. Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
class Solution {
    // kadanes algorithm
    public int maxSubArray(int[] nums) {
        int max_all = 0;
        int max_subarray = 0;
        
        for(int i=0; i<nums.length; i++)
        {
            // either include and make a max subarray or exclude and use only this elem
            max_subarray = math.Max(max_subarray+nums[i], nums[i]);
            // either this subarray or previous max
            max_all = math.Max(max_all, max_subarray);
        }
        return max_all;
    }
}