package test;
import domain.Contact;

public class Main {

    public static void main(String[] args) {
        Contact contact = new Contact(1, "Володимир", "Зеленський", "ул. Пушкина, дом Колотушкина, 45");

        System.out.println(contact);
    }   
}