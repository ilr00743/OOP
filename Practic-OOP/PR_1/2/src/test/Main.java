package test;

import domain.Order;
public class Main {

    public static void main(String[] args) {
        Order order = new Order(3, "Nokia 3310", "Іванов Іван Іванович", "12.12.2012 15:33:12", 1);

        System.out.println(order);
    }
    
}
