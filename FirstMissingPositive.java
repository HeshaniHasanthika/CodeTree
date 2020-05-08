/*
Given an unsorted integer array, find the smallest missing positive integer.
Your algorithm should run in O(n) time and uses constant extra space.

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1
*/

class Solution {
    // many easy ways but not with given  constraints.. watch video
    // sort and go checking consecutive nums till missing is found
    // put everything to hashmap, start from 1 and check all elems
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int partition = len;
        
        // swap negative elements and zero to end 
        for(int i=0; i<partition; i++)
        {
            if(nums[i] <= 0)
            {
                partition--;
                int temp = nums[partition];
                nums[partition] = nums[i];
                nums[i] = temp;
                // check again for this newly swapped element
                i--;
            }
        }
        
        //System.out.println(partition);
        //System.out.println(Arrays.toString(nums));
        
        for(int i=0; i< partition; i++)
        {
            int ndx = nums[i] > 0? nums[i]: -nums[i];
            // last case because repeated entries like [1 1] can change neg back to pos
            if(ndx>0 && ndx <= partition && !(nums[ndx-1]<0))
            {
                // 0 indexed and numbers start from 1
                nums[ndx-1] = -nums[ndx-1];
            }
        }
        
        System.out.println(Arrays.toString(nums));
        
        for(int i=0; i<partition; i++)
        {
            if(nums[i] > 0)
                return i+1;
        }
        
        return partition+1;
    }
}