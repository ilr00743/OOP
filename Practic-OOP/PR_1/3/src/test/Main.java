package test;

import domain.Student;

public class Main {

    public static void main(String[] args) {
        Student student = new Student(3, "Пупкин", "Вася", 35, "Какая-то кафедра" , "Какая-то дисциплина", 5, "Иванова");
        
        System.out.println(student);
    }
}
