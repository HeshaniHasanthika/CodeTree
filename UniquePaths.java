/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Note: m and n will be at most 100.
Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
*/
class Solution {
    public int uniquePaths(int m, int n) {
        
        //return uniquePathsRecV1(m, n, m-1, n-1, 0);
        //return uniquePathsRecV2(m-1, n-1);
        //return uniquePathsDPV3(m, n);
        return uniquePathsDPV4(m, n);
    }
    
    public int uniquePathsRecV1(int m, int n, int curr_m, int curr_n, int count)
    {
        if(curr_m == 0 && curr_n == 0)
            return 1;
        
        int down = 0;
        int right = 0;
        
        if(curr_m > 0)
            down = uniquePathsRecV1(m, n, curr_m-1, curr_n, count+1);
        
        if(curr_n > 0)
            right = uniquePathsRecV1(m, n, curr_m, curr_n-1, count+1);
        
        return down+right;
    }
    
    public int uniquePathsRecV2(int m, int n)
    {
        if(m == 0 || n == 0)
            return 1;
        
        return uniquePathsRecV2(m-1, n) + uniquePathsRecV2(m, n-1);
    }
    
    public int uniquePathsDPV3(int m, int n)
    {
        int arr[][] = new int[m][n];
        
        // set first row to 1 since only one path exist (straight right)
        for(int i=0; i<n; i++)
            arr[0][i] = 1;
        
        // set all first col to 1 since only one path exist (straight down)
        for(int i=0; i<m; i++)
            arr[i][0] = 1;
        
        // fill rest of the table with sum of paths by going down and going right
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
    
    // actually we dont need whole table only above row is sufficient to fill current row
    public int uniquePathsDPV4(int m, int n)
    {
        int above[] = new int[n];
        int current[] = new int[n];
        
        // initialize above and current to 1 
        for(int i=0; i<n; i++)
        {
            above[i] = 1;
            current[i] = 1;
        }
        
        // rest of the table iterations just by swapping both these arrays
        // 1st row already calculated, all 1s
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                current[j] = above[j] + current[j-1];
            }
            above = current;
        }
        return current[n-1];
    }
}