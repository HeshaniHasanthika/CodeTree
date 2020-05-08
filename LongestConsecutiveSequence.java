/*
Given an unsorted array of integers, 
find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.
Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        
        // put all the nums .. 
        // helpful for finding if elem we check is start of sequence to avoid repeats
        HashSet<Integer> set = new HashSet();
        for(int i=0; i<nums.length; i++)
            set.add(nums[i]);
        
        for(int i=0; i<nums.length; i++)
        {
            // then this is the starting 
            // check max length that can be formed
            // otherwise i would have already checked earlier for this sequence
            if(!set.contains(nums[i]-1))
            {
                int count = 0;
                for(int elem = nums[i]; set.contains(elem); elem++, count++);
                
                result = Math.max(result, count);
            }
        }
        return result;
    }
}