package domain;

import java.util.Comparator;

public class SorterByMark implements Comparator<Student> {
    
    @Override
    public int compare(Student s1, Student s2) {
        return Byte.compare(s1.getMark(), s2.getMark());
    }
}
