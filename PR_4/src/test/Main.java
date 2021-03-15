package test;

import javax.swing.*;

import gui.*;
import interfaces.Form;

public class Main implements Form{

    private final MenuForm MENU_FORM;
    private final ContactForm CONTACT_FORM;
    private final StudentForm STUDENT_FORM;
    private final OrderForm ORDER_FORM;
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
    
    public Main() {
        MENU_FORM = new MenuForm(this);
        CONTACT_FORM = new ContactForm(this);
        STUDENT_FORM = new StudentForm(this);
        ORDER_FORM = new OrderForm(this);
        MENU_FORM.setVisible(true);
    }
    
    @Override
    public void changeContactForm() {
        MENU_FORM.setVisible(!MENU_FORM.isVisible());
        CONTACT_FORM.setVisible(!CONTACT_FORM.isVisible());
    }

    @Override
    public void changeStudentForm() {
        MENU_FORM.setVisible(!MENU_FORM.isVisible());
        STUDENT_FORM.setVisible(!STUDENT_FORM.isVisible());
    }
    
    @Override
    public void changeOrderForm() {
        MENU_FORM.setVisible(!MENU_FORM.isVisible());
        ORDER_FORM.setVisible(!ORDER_FORM.isVisible());
    }
}