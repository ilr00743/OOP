package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Contact;

import interfaces.Form;
import java.io.FileReader;
import java.io.IOException;

public class ContactForm extends JFrame{
    
    private final Contact CONTACT = new Contact();
    
    public ContactForm(final Form form) {
        this.setTitle("CONTACT FORM");
        this.setBounds(400,290,700,300);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        this.setContentPane(panel);
        
        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 1;
        grid.weighty = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel idLabel = new JLabel("ID");
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
        
        JLabel firstNameLabel = new JLabel("First Name");
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
        
        JLabel lastNameLabel = new JLabel("Last Name");
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
        
        JLabel addressLabel = new JLabel("Address");
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
        
        ActionListener sortInfo = (ActionEvent event) -> CONTACT.sortingArrayList();
        
        ActionListener writeIntoFile = (ActionEvent event) -> CONTACT.writeFile();
        
        ActionListener backToMenu = (ActionEvent event) -> form.changeContactForm();
        
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
        };
        
        JButton displayInfoButton = new JButton("Display Info");
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        displayInfoButton.addActionListener(displayInfo);
        panel.add(displayInfoButton, grid);
        
        JButton sortButton = new JButton("Sorting of contacts");
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        sortButton.addActionListener(sortInfo);
        panel.add(sortButton, grid);
        
        JButton writeIntoFileButton = new JButton("Save to .txt");
        grid.gridx = 0;
        grid.gridy = 3;
        grid.gridwidth = 1;
        writeIntoFileButton.addActionListener(writeIntoFile);
        panel.add(writeIntoFileButton, grid);
        
        JButton clearFieldsButton = new JButton("Clear Text Fields");
        grid.gridx = 0;
        grid.gridy = 4;
        grid.gridwidth = 1;
        clearFieldsButton.addActionListener(clearTextFields);
        panel.add(clearFieldsButton, grid);
        
        JButton addInfoButton = new JButton("Add Contact Info");
        grid.gridx = 0;
        grid.gridy = 8;
        grid.gridwidth = 0;
        addInfoButton.addActionListener(addContactInfo);
        panel.add(addInfoButton, grid);
        
        ImageIcon backToMenuIcon = new ImageIcon("D:\\study\\Practic OOP\\Practic-OOP\\PR_4\\src\\icons\\back_to_menu.png");
        JButton backToMenuButton = new JButton(backToMenuIcon);
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 1;
        backToMenuButton.addActionListener(backToMenu);
        panel.add(backToMenuButton, grid);
        
        
        
        
    }
}
