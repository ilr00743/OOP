package domain;

import java.util.Comparator;
/**
 *
 * @author Illia_R
 */
public class SorterById implements Comparator<Person>{
    
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getId(), p2.getId());
    }
}
