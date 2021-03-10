package test;

import javax.swing.*;

import gui.*;
import interfaces.Form;

public class Main implements Form{

    private MenuForm menuForm;
    private ContactForm contactForm;
    private StudentForm studentForm;
    private OrderForm orderForm;
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
    
    public Main() {
        menuForm = new MenuForm(this);
        contactForm = new ContactForm(this);
        studentForm = new StudentForm(this);
        orderForm = new OrderForm(this);
        menuForm.setVisible(true);
    }
    
    @Override
    public void changeContactForm() {
        menuForm.setVisible(!menuForm.isVisible());
        contactForm.setVisible(!contactForm.isVisible());
    }

    @Override
    public void changeStudentForm() {
        menuForm.setVisible(!menuForm.isVisible());
        studentForm.setVisible(!studentForm.isVisible());
    }
    
    @Override
    public void changeOrderForm() {
        menuForm.setVisible(!menuForm.isVisible());
        orderForm.setVisible(!orderForm.isVisible());
    }
}
