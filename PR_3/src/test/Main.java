package test;

import domain.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Contact contact = new Contact();
        Student student = new Student();
        
        System.out.println("Enter the ID of contact: ");
        contact.setId(scanner.nextInt());
        
        System.out.println("Enter the First Name of contact: ");
        contact.setFirstName(scanner.next());
        
        System.out.println("Enter the Last Name of contact: ");
        contact.setLastName(scanner.next());
        
        System.out.println();
        
        System.out.println("Enter the ID of student: ");
        student.setId(scanner.nextInt());
        
        System.out.println("Enter the First Name of student: ");
        student.setFirstName(scanner.next());
        
        System.out.println("Enter the Last Name of student: ");
        student.setLastName(scanner.next());
        
        System.out.println("=== Contact ===");
        System.out.println(contact);
        System.out.println();
        
        System.out.println("=== Student ===");
        System.out.println(student);
        
        contact.fileWriter();
        student.fileWriter();
    }
}
