/*
A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. 
Bookings contain an arrival date and a departure date. 
He wants to find out whether there are enough rooms in the hotel to satisfy the demand. 
Write a program that solves this problem in time O(N log N).

Input : 
        Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K : 1
Return : False / 0 
At day = 5, there are 2 guests in the hotel. But I have only one room. 
*/

// partial output.. will go out of heap for large inputs and not NlogN
// have slots for each day .. when people arrive inc and when they leave dec.. check at any time more people are present than rooms
// no need for two for loops to add elements to list !
// editorial also has same approach
public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        // should contain current bookings on that day
        int bookings[] = new int[Math.max(Collections.max(arrive), Collections.max(depart))+1];
        
        // update the array with arrivals and bookings 
        for(int i=0; i<arrive.size(); i++)
        {
            bookings[arrive.get(i)]++;
        }
        
        for(int i=0; i<depart.size(); i++)
        {
            bookings[depart.get(i)]--;
        }
        
        int currentOccupy = 0;    
        for(int i=0; i<bookings.length; i++)
        {
            currentOccupy += bookings[i];
            if(currentOccupy > K)
                return false;
        }
        return true;
    }
}

public class Solution {
    class Entry{
        boolean arrivalOrDepart;
        int day;
        
        Entry(boolean type, int day)
        {
            this.arrivalOrDepart = type;
            this.day = day;
        }
    }

    // here we store only arrival/departure entries in the arraylist along with required data
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        // contains all the entries of arrival and departures
        ArrayList<Entry> entries = new ArrayList<Entry>();
    
        // update the array with arrivals and bookings 
        for(int i=0; i<arrive.size(); i++)
        {
            entries.add(new Entry(true, arrive.get(i)));
        }
        
        for(int i=0; i<depart.size(); i++)
        {
            entries.add(new Entry(false, depart.get(i)));
        }
        
        Collections.sort(entries, new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                return o1.day - o2.day;
            }
        });
        
        int currentOccupy = 0; 
        for(int i=0; i<entries.size(); i++)
        {
            Entry entry = entries.get(i);
            if(entry.arrivalOrDepart)
            {
                currentOccupy += 1;
            }else{
                currentOccupy -= 1;
            }
            
            // process entire day before returning false
            // many people may come on same day but also leave on same day
            if(currentOccupy > K && ((i+1)<entries.size() && entries.get(i+1).day != entry.day))
                return false;
        }
        return true;
    }
}