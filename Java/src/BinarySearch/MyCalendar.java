package BinarySearch;

import java.util.TreeMap;

//729. My Calendar I
public class MyCalendar {
    TreeMap<Integer, Integer> booked;

    MyCalendar(){
        booked = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floor = booked.floorKey(start);
        Integer ceiling = booked.ceilingKey(start);
        if ((floor == null || booked.get(floor) <= start)
                && (ceiling == null || end <= ceiling)) {
            booked.put(start,end);
            return true;
        }
        return false;
    }

}

//731. My Calendar II
