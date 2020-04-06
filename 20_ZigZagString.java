/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
like this: (you may want to display this pattern in a fixed font for better legibility)
P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:
*/
public class Solution {
    public String convert(String A, int B) {
        
        if(B == 1 || B > A.length())
            return A;
            
        String result = "";
        String[] rows = new String[B];
        boolean down = true;
        int ndx = 0;
        
        for(int i=0; i<A.length(); i++)
        {
            char c = A.charAt(i);
            
            if(rows[ndx] != null)
            {
                rows[ndx] += c;
            }else{
                rows[ndx] = String.valueOf(c);
            }
            
            if(down){
                ndx++;
            }else{
                ndx--;
            }
            
            if(ndx == B)
            {
                ndx-=2;
                down = false;
            }else if(ndx == -1){
                ndx+=2;
                down = true;
            }
        }
        
        for(int i=0; i<B; i++)
        {
            result += rows[i];
        }
        return result;
    }
}

// editorial had this approach in cpp
// but is it not possible without extra memory?
public class Solution {
	public String convert(String a, int b) {
	    int numRows=b;
	    String s=a;
	  if (numRows == 1)
		return s;
 
	StringBuilder sb = new StringBuilder();
	// step
	int step = 2 * numRows - 2;
 
	for (int i = 0; i < numRows; i++) {
		//first & last rows
		if (i == 0 || i == numRows - 1) {
			for (int j = i; j < s.length(); j = j + step) {
				sb.append(s.charAt(j));
			}
		//middle rows	
		} else {
			int j = i;
			boolean flag = true;
			int step1 = 2 * (numRows - 1 - i);
			int step2 = step - step1;
 
			while (j < s.length()) {
				sb.append(s.charAt(j));
				if (flag)
					j = j + step1;
				else
					j = j + step2;
				flag = !flag;
			}
		}
	}
 
	return sb.toString();
}

}
