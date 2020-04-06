/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
Example 1:
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/
class Solution {
    public int climbStairs(int n) {
        //return climbStairsRecV1(n);
        return climbStairsDPV2(n);
    }
    
    public int climbStairsRecV1(int n)
    {
        if(n < 0)
            return 0;
        
        if(n == 0)
            return 1;
        
        return climbStairsRecV1(n-1) + climbStairsRecV1(n-2);
    }
    
    public int climbStairsDPV2(int n)
    {
        if(n == 1 || n == 2)
            return n;
        
        // ignore zero just here to have good readability and avoid some confusions
        int arr[] = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        
        // every step can be in two possible ways (i-1)th ways + (i-2)th ways
        for(int i=3; i<=n; i++)
            arr[i] = arr[i-1] + arr[i-2];
        
        return arr[n];
    }
}