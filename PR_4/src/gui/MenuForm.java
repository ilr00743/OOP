package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.Form;

public class MenuForm extends JFrame{

    private final Form form;
    
    public MenuForm(final Form form) {
        this.form = form;
        this.setTitle("MAIN MENU");
        this.setBounds(600,300,350,250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.getHSBColor(0.19f, 0.32f, 0.67f));
        this.setContentPane(panel);
        
        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 0;
        grid.weighty = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.ipady = 10;
        grid.ipadx = 10;
        
        ActionListener contactFormAction = (ActionEvent event) -> {            
            form.changeContactForm();
            JOptionPane.showMessageDialog(null, 
                    "Для того, щоб додати дані про контакт, введіть його дані і натисніть кнопку Add Contact Info", "Instruction", 
                    JOptionPane.INFORMATION_MESSAGE);
        };
        
        ActionListener studentFormAction = (ActionEvent event) -> {
            form.changeStudentForm();
            JOptionPane.showMessageDialog(null, 
                    "Для того, щоб додати дані про студента, введіть його дані і натисніть кнопку Add Student Info", "Instruction", 
                    JOptionPane.INFORMATION_MESSAGE);
        };
        
        ActionListener orderFormAction = (ActionEvent event) -> {
            form.changeOrderForm();
            JOptionPane.showMessageDialog(null, 
                    "Для того, щоб додати дані про замовлення, введіть його дані і натисніть кнопку Add Order Info", "Instruction", 
                    JOptionPane.INFORMATION_MESSAGE);
        };
        
        JButton contactFormButton = new JButton("Contact Form");
        grid.gridx = 0;
        grid.gridy = 0;
        contactFormButton.setBackground(Color.getHSBColor(3, 12, 13));
        contactFormButton.addActionListener(contactFormAction);
        panel.add(contactFormButton, grid);
        
        JButton studentFormButton = new JButton("Student Form");
        grid.gridx = 0;
        grid.gridy = 1;
        studentFormButton.setBackground(Color.getHSBColor(3, 12, 13));
        studentFormButton.addActionListener(studentFormAction);
        panel.add(studentFormButton, grid);
        
        JButton orderFormButton = new JButton("Order Form");
        grid.gridx = 0;
        grid.gridy = 2;
        orderFormButton.setBackground(Color.getHSBColor(3, 12, 13));
        orderFormButton.addActionListener(orderFormAction);
        panel.add(orderFormButton, grid);
    }              
}
