package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Order;

import interfaces.Form;

import java.io.FileReader;

import java.io.IOException;

public class OrderForm extends JFrame{
    
    private final Order ORDER;
    
    public OrderForm(final Form form) {
        this.ORDER = new Order();
        this.setTitle("ORDER FORM");
        this.setBounds(400, 290, 750, 350);
        this.setResizable(false);
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
        
        JLabel nameLabel = new JLabel("Name of product: ");
        grid.gridx = 2;
        grid.gridy = 1;
        grid.gridwidth = 1;
        nameLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(nameLabel, grid);
        
        JTextField nameField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 1;
        grid.gridwidth = 1;
        panel.add(nameField, grid);
        
        JLabel lastNameLabel = new JLabel("Last Name of courier: ");
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
        
        JLabel dateTimeLabel = new JLabel("Date and Time: ");
        grid.gridx = 2;
        grid.gridy = 3;
        grid.gridwidth = 1;
        dateTimeLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(dateTimeLabel,grid);
        
        JTextField dateTimeField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(dateTimeField, grid);
        
        JLabel typeLabel = new JLabel("Type of order: ");
        grid.gridx = 2;
        grid.gridy = 4;
        grid.gridwidth = 1;
        typeLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(typeLabel,grid);
        
        JTextField typeField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 4;
        grid.gridwidth = 1;
        panel.add(typeField, grid);
        
        ActionListener displayInfo = (ActionEvent event) -> {
            try(FileReader fileReader = new FileReader("orders.txt")) {
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
        
        ActionListener backToMenu = (ActionEvent event) -> form.changeOrderForm();
        
        ActionListener sortById = (ActionEvent event) -> {
            ORDER.sortById();
            ORDER.writeFile();
        };
        
        ActionListener reverseSortById = (ActionEvent event) -> {
            ORDER.reverseSortById();
            ORDER.writeFile();
        };
        
        ActionListener sortByDate = (ActionEvent event) -> {
            ORDER.sortByDate();
            ORDER.writeFile();
        };
        
        ActionListener clearTextFields = (ActionEvent event) -> {
            idField.setText("");
            nameField.setText("");
            lastNameField.setText("");
            dateTimeField.setText("");
            typeField.setText("");
        };
        
        ActionListener addContactInfo = (ActionEvent event) -> {
            ORDER.setId(Integer.parseInt(idField.getText()));
            ORDER.setName(nameField.getText());
            ORDER.setLastName(lastNameField.getText());
            ORDER.setDateTime(dateTimeField.getText());
            ORDER.setType(Byte.parseByte(typeField.getText()));
            ORDER.fillingArrayList();
            ORDER.writeFile();
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
        displayInfoButton.addActionListener(displayInfo);
        displayInfoButton.setBackground(Color.getHSBColor(3, 12, 13));
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
        reverseSortByIdButton.addActionListener(reverseSortById);
        reverseSortByIdButton.setBackground(Color.getHSBColor(3, 12, 13));
        panel.add(reverseSortByIdButton, grid);
        
        JButton sortByDateButton = new JButton("Sorting by Date and Time");
        grid.gridx = 0;
        grid.gridy = 4;
        grid.gridwidth = 1;
        sortByDateButton.addActionListener(sortByDate);
        sortByDateButton.setBackground(Color.getHSBColor(3, 12, 13));
        panel.add(sortByDateButton, grid);
        
        JButton clearTextFieldsButton = new JButton("Clear text fields");
        grid.gridx = 0;
        grid.gridy = 8;
        grid.gridwidth = 1;
        clearTextFieldsButton.setBackground(Color.getHSBColor(3, 12, 13));
        clearTextFieldsButton.addActionListener(clearTextFields);
        panel.add(clearTextFieldsButton, grid);
                
        JButton addInfoButton = new JButton("Add Order Info");
        grid.gridx = 0;
        grid.gridy = 10;
        grid.gridwidth = 0;
        addInfoButton.setBackground(Color.getHSBColor(3, 12, 13));
        addInfoButton.addActionListener(addContactInfo);
        panel.add(addInfoButton, grid);
    }
}