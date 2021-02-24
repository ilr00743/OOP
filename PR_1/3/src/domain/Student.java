package domain;

public class Student {
    private int id_student;
    private String fam;
    private String name;
    private int group;
    private String department;
    private String discipline;
    private int mark;
    private String nameTeacher;

    public Student(int id_student, String fam, String name, int group, String department, String discipline, int mark, String nameTeacher) {
        this.id_student = id_student;
        this.fam = fam;
        this.name = name;
        this.group = group;
        this.department = department;
        this.discipline = discipline;
        this.mark = mark;
        this.nameTeacher = nameTeacher;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        if (id_student >= 0) {
            this.id_student = id_student;
        }
        else {
            System.out.println("Id не може бути менше нуля!");
        }
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Id_student: " + id_student + "\nFam: " + fam + "\nName: " + name + "\nGroup: " + group + "\nDepartment: " + department + "\nDiscipline: " + discipline + "\nMark: " + mark + "\nName of teacher: " + nameTeacher;
    }
    
    
}
