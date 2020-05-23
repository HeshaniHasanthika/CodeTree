/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input:
"tree"
Output:
"eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 3:
Input:
"Aabb"
Output:
"bbAa"
Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
class Solution {
    // On time
    public String frequencySortV1(String s) {
        // obtain the count of all the chars
        // also, can use a char array instead 
        Map<Character, Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        
        // count/frequency vs list of chars map
        // construct this using above map
        Map<Integer, List<Character>> count = new HashMap();
        for(char c : map.keySet())
        {
            int freq = map.get(c);
            // if list for this char is not present, create
            if(!count.containsKey(freq))
                count.put(freq, new LinkedList<Character>());
            
            // add current char to its freq
            count.get(freq).add(c);
        }
        
        // check from highest possible freq and keep appending to result
        StringBuilder sb = new StringBuilder();
        for(int i=s.length(); i>0 ; i--)
        {
            List<Character> curr = count.get(i);
            if(curr == null)
                continue;
            
            // process all chars present i times
            for(char c : curr)
            {
                // add this char i times
                for(int j=0; j<i; j++)
                    sb.append(c);
            }
        }
        return sb.toString();
    }
    
    // nlogn time
    public String frequencySort(String s) {
        // obtain the count of all the chars
        // also, can use a char array instead 
        Map<Character, Integer> map = new HashMap();
        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        
        // put entries of map to priority queue in decreasing order of freq
        PriorityQueue< Map.Entry<Character, Integer> > pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
				
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) 
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}