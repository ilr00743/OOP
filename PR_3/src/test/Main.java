package test;

import domain.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Contact contact = new Contact();
        
        System.out.println("Enter the First Name: ");
        contact.setFirstName(scanner.nextLine());
        
        System.out.println("Enter the Last Name: ");
        contact.setLastName(scanner.nextLine());
        
        System.out.println("Enter the ID: ");
        contact.setId(scanner.nextInt());
        
        System.out.println();
        
        System.out.println(contact);
        
        contact.fileWriter();
    }
}
