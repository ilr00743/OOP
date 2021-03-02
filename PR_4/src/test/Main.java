package test;

import domain.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        
        Contact contact_1 = new Contact(3, "Vasya", "Ivanov", "Sheva St.");
        Contact contact_2 = new Contact(1, "Petya", "Petrov", "Pushkin St.");
        Contact contact_3 = new Contact(2, "Dima", "Dimonov", "Some St.");
        
        Order order_1 = new Order();
        Order order_2 = new Order();
        Order order_3 = new Order();
        
        ArrayList<Contact> contacts = new ArrayList<>();
        
        contacts.add(contact_1);
        contacts.add(contact_2);
        contacts.add(contact_3);
        
        ArrayList<Order> orders = new ArrayList<>();
        
        orders.add(order_1);
        orders.add(order_2);
        orders.add(order_3);
        
        contacts.sort(Comparator.comparing(Contact::getId));
        
        contacts.forEach(System.out::println);
        
        for(Contact contact : contacts) {
            contact.fileWriter("contacts.txt");
        }
        
        for(Order order : orders) {
            order.fileWriter("orders.txt");
        }
    }
}
