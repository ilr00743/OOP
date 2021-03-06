package domain;

import java.util.Comparator;

public class SorterById implements Comparator<Person>{
    
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getId() - p2.getId();
    }
}