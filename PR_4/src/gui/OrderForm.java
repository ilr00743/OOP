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
    
    private final Order ORDER = new Order();
    
    public OrderForm(final Form form) {
        this.setTitle("ORDER FORM");
        this.setBounds(400, 290, 750, 350);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
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
                
                JOptionPane.showMessageDialog(new JFrame(), strBuilder.toString(), "Reading file", JOptionPane.PLAIN_MESSAGE);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        };
        
        ActionListener sortInfo = (ActionEvent event) -> ORDER.sortingArrayList();
        
        ActionListener writeIntoFile = (ActionEvent event) -> ORDER.writeFile();
        
        ActionListener backToMenu = (ActionEvent event) -> form.changeOrderForm();
        
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
        };
        
        JButton displayInfoButton = new JButton("Display Info");
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        displayInfoButton.addActionListener(displayInfo);
        panel.add(displayInfoButton, grid);
        
        JButton sortButton = new JButton("Sorting of orders");
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        sortButton.addActionListener(sortInfo);
        panel.add(sortButton, grid);

        
        JButton writeIntoFileButton = new JButton("Save to orders.txt");
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
        
        ImageIcon backToMenuIcon = new ImageIcon("D:\\study\\Practic OOP\\Practic-OOP\\PR_4\\src\\icons\\back_to_menu.png");
        JButton backToMenuButton = new JButton(backToMenuIcon);
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 1;
        backToMenuButton.addActionListener(backToMenu);
        panel.add(backToMenuButton, grid);
                
        JButton addInfoButton = new JButton("Add Order Info");
        grid.gridx = 0;
        grid.gridy = 10;
        grid.gridwidth = 0;
        addInfoButton.addActionListener(addContactInfo);
        panel.add(addInfoButton, grid);
    }
}
