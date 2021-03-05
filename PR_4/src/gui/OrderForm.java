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
        
        JLabel dayTimeLabel = new JLabel("Day and Time");
        grid.gridx = 2;
        grid.gridy = 3;
        grid.gridwidth = 1;
        dayTimeLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(dayTimeLabel,grid);
        
        JTextField dayTimeField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(dayTimeField, grid);
        
        JLabel typeLabel = new JLabel("Type of order");
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
        
        ActionListener addContactInfo = (ActionEvent event) -> {
            ORDER.setId(Integer.parseInt(idField.getText()));
            ORDER.setFirstName(firstNameField.getText());
            ORDER.setLastName(lastNameField.getText());
            ORDER.fillingArrayList();
        };
        
        JButton displayInfoButton = new JButton("Display Info");
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 1;
        displayInfoButton.addActionListener(displayInfo);
        panel.add(displayInfoButton, grid);
        
        JButton sortButton = new JButton("Sorting of orders");
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        sortButton.addActionListener(sortInfo);
        panel.add(sortButton, grid);

        
        JButton writeIntoFileButton = new JButton("Save to orders.txt");
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        writeIntoFileButton.addActionListener(writeIntoFile);
        panel.add(writeIntoFileButton, grid);
        
        JButton backToMenuButton = new JButton("Back to Main Menu");
        grid.gridx = 0;
        grid.gridy = 4;
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
