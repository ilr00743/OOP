package domain;

public class Student extends Person{

    private int group;
    private String department;
    private String discipline;
    private byte mark;
    private String nameTeacher;

    public Student(int id, String firstName, String lastName, int group, String department, String discipline, byte mark, String nameTeacher) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.department = department;
        this.discipline = discipline;
        this.mark = mark;
        this.nameTeacher = nameTeacher;
    }
    
    public Student() {
        this(4, "Ivan", "Ivanov", 35, "Some department", "Some discipline", (byte)5, "Ivanova");
    }
    
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        if(id >= 0) {
            super.setId(id);
        }
        else {
            System.out.println("ID не може бути менше нуля!!!");
        }
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

    @Override
    public String toString() {
        return super.toString() + "\nGroup: " + group + "\nDepartment: " + department + "\nDiscipline: " + discipline + "\nMark: " + mark + "\nNameTeacher: " + nameTeacher;
    }
    
}
