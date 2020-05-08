/*
121. Best Time to Buy and Sell Stock
Easy
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.

Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int result = 0;
        
        // calculated from left to right
        int runningMin[] = new int[len];
        // calculated from right to left
        int runningMax[] = new int[len];
        
        for(int i=0; i<prices.length; i++)
        {
            if(i==0)
                runningMin[i] = prices[i];
            else
                runningMin[i] = Math.min(runningMin[i-1], prices[i]);
            
            if(i==0)
                runningMax[len-1-i] = prices[len-1-i];
            else
                runningMax[len-1-i] = Math.max(runningMax[len-i], prices[len-1-i]);
        }
        
        for(int i=0; i<len; i++)
            result = Math.max(result, runningMax[i]-runningMin[i]);
        
        return result;
    }
}