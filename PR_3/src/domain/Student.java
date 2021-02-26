package domain;

public class Student extends Contact{

    private int group;
    private String department;
    private String discipline;
    private int mark;
    private String nameTeacher;

    public Student(int id_student, String fam, String name, String address,int group, String department, String discipline, int mark, String nameTeacher) {
        super(id_student, fam, name, address);
        this.group = group;
        this.department = department;
        this.discipline = discipline;
        this.mark = mark;
        this.nameTeacher = nameTeacher;
    }

    public int getId_student() {
        return id;
    }

    public void setId_student(int id_student) {
        if (id_student >= 0) {
            this.id = id_student;
        }
        else {
            System.out.println("Id не може бути менше нуля!");
        }
    }

    public String getFam() {
        return lastName;
    }

    public void setFam(String fam) {
        this.lastName = fam;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
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
        return "Id_student: " + id + "\nFam: " + lastName + "\nName: " + firstName + "\nGroup: " + group + "\nDepartment: " + department + "\nDiscipline: " + discipline + "\nMark: " + mark + "\nName of teacher: " + nameTeacher;
    }
    
    
}
