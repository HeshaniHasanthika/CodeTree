/*
Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
All inputs will be in lowercase.
The order of your output does not matter.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList();
        HashMap<String, List<String>> map = new HashMap();
        
        for(int i=0; i<strs.length; i++)
        {
            //String sorted = String.valueOf((Arrays.sort((strs[i]).toCharArray())));
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            //String currs = curr.toString();
            String currs = String.valueOf(curr);
            
            if(map.containsKey(currs))
            {
                List<String> vals = map.get(currs);
                vals.add(strs[i]);
                map.put(currs, vals);
            }else{
                List<String> vals = new LinkedList();
                vals.add(strs[i]);
                map.put(currs, vals);
            }
        }
        
        for (Map.Entry<String,List<String>> entry : map.entrySet()) 
        {
            List<String> currVal = entry.getValue();
            result.add(currVal);
        }
        
        // for (String key : map.keySet()) 
        // {
        //         result.add(map.get(key));
        // }
        return result;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList();
        HashMap<String, List<String>> map = new HashMap();
        
        for(int i=0; i<strs.length; i++)
        {   
            String key = getKeyFromStringValue(strs[i]);
            
            if(map.containsKey(key))
            {
                List<String> vals = map.get(key);
                vals.add(strs[i]);
                map.put(key, vals);
            }else{
                List<String> vals = new LinkedList();
                vals.add(strs[i]);
                map.put(key, vals);
            }
        }
        
        for (Map.Entry<String,List<String>> entry : map.entrySet()) 
        {
            List<String> currVal = entry.getValue();
            result.add(currVal);
        }
        
        // for (String key : map.keySet()) 
        // {
        //         result.add(map.get(key));
        // }
        return result;
    }
    
    public static String getKeyFromStringValue(String s)
    {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        
        for(int i=0; i<s.length(); i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        
        for(int i=0; i<freq.length; i++)
        {
            sb.append(String.valueOf(freq[i]));
        }
        
        return sb.toString();
    }
}
