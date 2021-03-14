package gui;

import domain.Contact;

import interfaces.Form;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileReader;
import java.io.IOException;

public class ContactForm extends JFrame{
    
    private final Contact CONTACT;
    
    public ContactForm(final Form form) {
        this.CONTACT = new Contact();
        this.setTitle("CONTACT FORM");
        this.setBounds(400,290,780,330);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.getHSBColor(0.19f, 0.32f, 0.67f));
        this.setContentPane(panel);
        
        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 1;
        grid.weighty = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel idLabel = new JLabel("ID: ");
        grid.gridx = 2;
        grid.gridy = 0;
        grid.gridwidth = 1;
        idLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(idLabel, grid);
        
        JTextField idField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 0;
        grid.gridwidth = 1;
        panel.add(idField, grid);
        
        JLabel firstNameLabel = new JLabel("First Name: ");
        grid.gridx = 2;
        grid.gridy = 1;
        grid.gridwidth = 1;
        firstNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(firstNameLabel, grid);
        
        JTextField firstNameField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 1;
        grid.gridwidth = 1;
        panel.add(firstNameField, grid);
        
        JLabel lastNameLabel = new JLabel("Last Name: ");
        grid.gridx = 2;
        grid.gridy = 2;
        grid.gridwidth = 1;
        lastNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(lastNameLabel, grid);
        
        JTextField lastNameField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 2;
        grid.gridwidth = 1;
        panel.add(lastNameField, grid);
        
        JLabel addressLabel = new JLabel("Address: ");
        grid.gridx = 2;
        grid.gridy = 3;
        grid.gridwidth = 1;
        addressLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(addressLabel,grid);
        
        JTextField addressField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(addressField, grid);
        
        ActionListener displayInfo = (ActionEvent event) -> {
            try(FileReader fileReader = new FileReader("contacts.txt")) {
                StringBuilder strBuilder = new StringBuilder();
                
                while(fileReader.ready()) {
                    strBuilder.append((char)fileReader.read());
                }
                
                JOptionPane.showMessageDialog(null, strBuilder.toString(), "Reading file", JOptionPane.PLAIN_MESSAGE);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        };
        
        ActionListener backToMenu = (ActionEvent event) -> form.changeContactForm();
        
        ActionListener sortById = (ActionEvent event) -> {
            CONTACT.sortById();
            CONTACT.writeFile();
        };
        
        ActionListener reverseSortById = (ActionEvent event) -> {
            CONTACT.reverseSortById();
            CONTACT.writeFile();
        };
        
        ActionListener sortByLastName = (ActionEvent event) -> {
            CONTACT.sortByLastName();
            CONTACT.writeFile();
        };
        
        ActionListener reverseSortByLastName = (ActionEvent event) -> {
            CONTACT.reverseSortByLastName();
            CONTACT.writeFile();
        };
        
        ActionListener clearTextFields = (ActionEvent event) -> {
            idField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            addressField.setText("");
        };
        
        ActionListener addContactInfo = (ActionEvent event) -> {
            CONTACT.setId(Integer.parseInt(idField.getText()));
            CONTACT.setFirstName(firstNameField.getText());
            CONTACT.setLastName(lastNameField.getText());
            CONTACT.setAddress(addressField.getText());
            CONTACT.fillingArrayList();
            CONTACT.writeFile();
        };
        
        ImageIcon backToMenuIcon = new ImageIcon("D:\\study\\Practic OOP\\Practic-OOP\\PR_4\\src\\icons\\back_to_menu.png");
        JButton backToMenuButton = new JButton(backToMenuIcon);
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 1;
        backToMenuButton.setBackground(Color.getHSBColor(3, 12, 13));
        backToMenuButton.addActionListener(backToMenu);
        panel.add(backToMenuButton, grid);
        
        JButton displayInfoButton = new JButton("Display Info");
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        displayInfoButton.setBackground(Color.getHSBColor(3, 12, 13));
        displayInfoButton.addActionListener(displayInfo);
        panel.add(displayInfoButton, grid);
        
        JButton sortByIdButton = new JButton("Sorting by ID");
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        sortByIdButton.setBackground(Color.getHSBColor(3, 12, 13));
        sortByIdButton.addActionListener(sortById);
        panel.add(sortByIdButton, grid);
        
        JButton reverseSortByIdButton = new JButton("Reverse Sorting by ID");
        grid.gridx = 0;
        grid.gridy = 3;
        grid.gridwidth = 1;
        reverseSortByIdButton.setBackground(Color.getHSBColor(3, 12, 13));
        reverseSortByIdButton.addActionListener(reverseSortById);
        panel.add(reverseSortByIdButton, grid);
        
        JButton sortByLastNameButton = new JButton("Sorting by Last Name");
        grid.gridx = 0;
        grid.gridy = 4;
        grid.gridwidth = 1;
        sortByLastNameButton.setBackground(Color.getHSBColor(3, 12, 13));
        sortByLastNameButton.addActionListener(sortByLastName);
        panel.add(sortByLastNameButton, grid);
        
        JButton reverseSortByLastNameButton = new JButton("Reverse Sorting by Last Name");
        grid.gridx = 0;
        grid.gridy = 5;
        grid.gridwidth = 1;
        reverseSortByLastNameButton.setBackground(Color.getHSBColor(3, 12, 13));
        reverseSortByLastNameButton.addActionListener(reverseSortByLastName);
        panel.add(reverseSortByLastNameButton, grid);
        
        JButton clearTextFieldsButton = new JButton("Clear text fields");
        grid.gridx = 0;
        grid.gridy = 8;
        grid.gridwidth = 1;
        clearTextFieldsButton.setBackground(Color.getHSBColor(3, 12, 13));
        clearTextFieldsButton.addActionListener(clearTextFields);
        panel.add(clearTextFieldsButton, grid);
        
        JButton addInfoButton = new JButton("Add Contact Info");
        grid.gridx = 0;
        grid.gridy = 10;
        grid.gridwidth = 0;
        addInfoButton.setBackground(Color.getHSBColor(3, 12, 13));
        addInfoButton.addActionListener(addContactInfo);
        panel.add(addInfoButton, grid);
    }
}
