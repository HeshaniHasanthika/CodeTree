/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
*/
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int result = 0;
        map.put(0,0);
        
        int runningSum = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == 1)
                runningSum += 1;
            else
                runningSum -= 1;
            
            if(map.containsKey(runningSum))
                result = Math.max(result, i+1-map.get(runningSum));
            else
                map.put(runningSum, i+1);
        }
        return result;
    }
}