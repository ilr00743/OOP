package domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Student extends Person{

    private int group;
    private String department;
    private String discipline;
    private byte mark;
    private String nameTeacher;
    private ArrayList<Student> arrayList;

    public Student(int id, String firstName, String lastName, int group, String department, String discipline, byte mark, String nameTeacher) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.department = department;
        this.discipline = discipline;
        this.mark = mark;
        this.nameTeacher = nameTeacher;
        this.arrayList = new ArrayList<>();
    }
    
    public Student() {
        this(4, "Ivan", "Ivanov", 35, "Some department", "Some discipline", (byte)5, "Petrovna");
    }
    
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }
    
    public void fillingArrayList() {
        Student student = new Student(id, firstName, lastName, group, department, discipline, mark, nameTeacher);
        arrayList.add(student);
    }
    
    public void sortById() {
        Collections.sort(arrayList, new SorterById());
    }
    
    public void reverseSortById() {
        Collections.sort(arrayList, Collections.reverseOrder(new SorterById()));
    }
    
    public void sortByLastName() {
        Collections.sort(arrayList, new SorterByLastName());
    }
    
    public void sortByMark() {
        Collections.sort(arrayList, Collections.reverseOrder(new SorterByMark()));
    }

    @Override
    public String toString() {
        return super.toString() + "\nGroup: " + group + "\nDepartment: " + department + "\nDiscipline: " + discipline + "\nMark: " + mark + "\nNameTeacher: " + nameTeacher + '\n';
    }
    
    public void writeFile() {
        try(FileWriter fileWriter = new FileWriter("students.txt", false)) {
            StringBuilder strBuilder = new StringBuilder();
            
            arrayList.forEach((string) -> {
                strBuilder.append(string).append('\n');
            });
            
            fileWriter.write(String.valueOf(strBuilder));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}