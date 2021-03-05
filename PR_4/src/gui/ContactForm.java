package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Contact;

import interfaces.Form;

public class ContactForm extends JFrame{
    
    private final Contact contact = new Contact();
    
    public ContactForm(final Form form) {
        this.setTitle("CONTACT FORM");
        this.setBounds(750,350,700,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        ActionListener backToMenu = (ActionEvent event) -> form.changeContactForm();
        
        ActionListener addContactInfo = (ActionEvent event) -> {
            contact.setId(Integer.parseInt(idField.getText()));
            contact.setFirstName(firstNameField.getText());
            contact.setLastName(lastNameField.getText());
            contact.setAddress(addressField.getText());
            contact.fillingArrayList();
        };
        
        ActionListener displayInfo = (ActionEvent event) -> {
            StringBuilder strBuilder = new StringBuilder();
            
            for(int i = 0; i < contact.getArrayList().size(); i++) {
                strBuilder.append(contact.getArrayList().get(i)).append('\n');
            }
            
            JOptionPane.showMessageDialog(null, strBuilder.toString(), "Contacts Info", JOptionPane.PLAIN_MESSAGE);
        };
        
        ActionListener sortInfo = (ActionEvent event) -> contact.sortingArrayList();
        
        ActionListener writeIntoFile = (ActionEvent event) -> contact.writeFile();
        
        JButton displayInfoButton = new JButton("Display Info");
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 1;
        displayInfoButton.addActionListener(displayInfo);
        panel.add(displayInfoButton, grid);
        
        JButton sortButton = new JButton("Sorting of contacts");
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        sortButton.addActionListener(sortInfo);
        panel.add(sortButton, grid);
        
        
        JButton writeIntoFileButton = new JButton("Save to .txt");
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        writeIntoFileButton.addActionListener(writeIntoFile);
        panel.add(writeIntoFileButton, grid);
        
        JButton backToMenuButton = new JButton("Back to Main Menu");
        grid.gridx = 0;
        grid.gridy = 3;
        grid.gridwidth = 1;
        backToMenuButton.addActionListener(backToMenu);
        panel.add(backToMenuButton, grid);
        
        JButton addInfoButton = new JButton("Add Contact Info");
        grid.gridx = 0;
        grid.gridy = 8;
        grid.gridwidth = 0;
        addInfoButton.addActionListener(addContactInfo);
        panel.add(addInfoButton, grid);
    }
}
