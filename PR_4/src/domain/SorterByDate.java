package domain;

import java.util.Comparator;

public class SorterByDate implements Comparator<Order>{
    
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getDateTime().compareTo(o2.getDateTime());
    }
}