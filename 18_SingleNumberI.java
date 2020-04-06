/*
275
Single Number
Given an array of integers, every element appears twice except for one. Find that single one.
Input : [1 2 2 3 1]
Output : 3
*/
// every number xor with same gives zero .. so only single remains single !
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for(int i=0; i<A.size(); i++)
            result ^= A.get(i);
        
        return result;
    }
}
