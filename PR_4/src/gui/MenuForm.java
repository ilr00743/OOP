package gui;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.IForm;

public class MenuForm extends JFrame{

    private final IForm form;
    
    public MenuForm(final IForm form) {
        this.form = form;
        this.setTitle("MAIN MENU");
        this.setBounds(750,350,350,250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        this.setContentPane(panel);
        
        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 0;
        grid.weighty = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        
        ActionListener contactFormAction = (ActionEvent event) -> form.changeContactForm();
        
        ActionListener studentFormAction = (ActionEvent event) -> form.changeStudentForm();
        
        ActionListener orderFormAction = (ActionEvent event) -> form.changeOrderForm();
        
        ActionListener fileReaderAction = (ActionEvent event) -> {
            try(FileReader fileReader = new FileReader("file.txt")) {
                StringBuilder strBuilder = new StringBuilder();
                
                while(fileReader.ready()) {
                    strBuilder.append((char)fileReader.read());
                }
                
                JOptionPane.showMessageDialog(new JFrame(), strBuilder.toString(), "Reading file", JOptionPane.PLAIN_MESSAGE);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        };
        
        JButton contactFormButton = new JButton("Contact");
        grid.gridx = 0;
        grid.gridy = 0;
        contactFormButton.addActionListener(contactFormAction);
        panel.add(contactFormButton, grid);
        
        JButton studentFormButton = new JButton("Student");
        grid.gridx = 0;
        grid.gridy = 1;
        studentFormButton.addActionListener(studentFormAction);
        panel.add(studentFormButton, grid);
        
        JButton orderFormButton = new JButton("Order");
        grid.gridx = 0;
        grid.gridy = 2;
        orderFormButton.addActionListener(orderFormAction);
        panel.add(orderFormButton, grid);
        
        JButton fileReadButton = new JButton("Read the file");
        grid.gridx = 0;
        grid.gridy = 3;
        fileReadButton.addActionListener(fileReaderAction);
        panel.add(fileReadButton, grid);
    }              
}
