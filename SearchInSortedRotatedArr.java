/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

// trick here is at every instant of binary search, one part of array is sorted and other is not
// check if it is in sorted, using max/min prop,, if not present recurse in unsorted !
// there are many questions similar like find min in rotated sorted etc. everything based on same trick
class Solution {
    public int search(int[] nums, int target) {
        return searchrec(nums, target, 0, nums.length-1);
    }
    
    public int searchrec(int[] nums, int target, int left, int right)
    {
        if(left > right)
            return -1;
        
        int mid = (left + right)/2;
        if(nums[mid] == target)
            return mid;
        
        // right half is sorted?
        if(nums[right] > nums[mid])
        {
            // so check if it is in right half
            if(mid< nums.length-1 && target >= nums[mid+1] && target <= nums[right])
            {
                return searchrec(nums, target, mid+1, right);
            }else{
                // if not there then left half 
                return searchrec(nums, target, left, mid-1);
            }
        }else{
            // otherwise left half is sorted
            // check if it is in left half
            if(mid > 0 && target >= nums[left] && target <= nums[mid-1])
            {
                return searchrec(nums, target, left, mid-1);
            }else{
                // otherwise it is in right half
                return searchrec(nums, target, mid+1, right);
            }
        }
        //return -1;
    }
}



class Solution {

  static int shiftedArrSearch(int[] shiftArr, int num) {
    int left = 0;
    int right = shiftArr.length -1;
    
    while(left <= right)
    {
      int mid = left + (right-left)/2;
      
      if(shiftArr[mid] == num)
        return mid;
          
      if(shiftArr[mid] >= shiftArr[left]){
        // left subarray is sorted
        if(num >= shiftArr[left] && num < shiftArr[mid]){
          // num is present in left arr
          right = mid-1;
        }else{
          left = mid+1;
        }
      }else{
        // right subarray is sorted
        if(num > shiftArr[mid] && num <= shiftArr[right]){
          left = mid+1;
        }else{
          right = mid-1;
        }
      }
    }
    
    return -1;
  }