package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Order;

import interfaces.IForm;

public class OrderForm extends JFrame{
    
    private final Order order = new Order();
    
    public OrderForm(final IForm form) {
        this.setTitle("ORDER FORM");
        this.setBounds(750, 350, 700, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        this.setContentPane(panel);
        
        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 1;
        grid.weighty = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel idLabel = new JLabel("ID");
        grid.gridx = 4;
        grid.gridy = 0;
        grid.gridwidth = 1;
        panel.add(idLabel, grid);
        
        JTextField idField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 0;
        grid.gridwidth = 1;
        panel.add(idField, grid);
        
        JLabel firstNameLabel = new JLabel("First Name");
        grid.gridx = 4;
        grid.gridy = 1;
        grid.gridwidth = 1;
        panel.add(firstNameLabel, grid);
        
        JTextField firstNameField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 0;
        grid.gridwidth = 1;
        panel.add(firstNameField, grid);
        
        JLabel lastNameLabel = new JLabel("Last Name");
        grid.gridx = 4;
        grid.gridy = 2;
        grid.gridwidth = 1;
        panel.add(lastNameLabel, grid);
        
        JTextField lastNameField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 0;
        grid.gridwidth = 1;
        panel.add(lastNameField, grid);
        
        JLabel dayTimeLabel = new JLabel("Day and Time");
        grid.gridx = 4;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(dayTimeLabel,grid);
        
        JTextField dayTimeField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(dayTimeField, grid);
        
        JLabel typeLabel = new JLabel("Type of order");
        grid.gridx = 4;
        grid.gridy = 4;
        grid.gridwidth = 1;
        panel.add(typeLabel,grid);
        
        JTextField typeField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 4;
        grid.gridwidth = 1;
        panel.add(typeField, grid);
        
        ActionListener backToMenu = (ActionEvent event) -> form.changeOrderForm();
        
        ActionListener addContactInfo = (ActionEvent event) -> {
            order.setId(Integer.parseInt(idField.getText()));
            order.setFirstName(firstNameField.getText());
            order.setLastName(lastNameField.getText());
            order.fillingArrayList();
        };
        
        ActionListener displayInfo = (ActionEvent event) -> {
            StringBuilder strBuilder = new StringBuilder();
            
            for(int i = 0; i < order.getArrayList().size(); i++) {
                strBuilder.append(order.getArrayList().get(i)).append('\n');
            }
            
            JOptionPane.showMessageDialog(null, strBuilder.toString(), "Orders Info", JOptionPane.PLAIN_MESSAGE);
        };
        
        ActionListener sortInfo = (ActionEvent event) -> order.sortingArrayList();
        
        ActionListener writeIntoFile = (ActionEvent event) -> order.writeFile();
        
        JButton addInfoButton = new JButton("Add Order Info");
        grid.gridx = 4;
        grid.gridy = 2;
        grid.gridwidth = 4;
        addInfoButton.addActionListener(addContactInfo);
        panel.add(addInfoButton, grid);
        
        JButton sortButton = new JButton("Sorting of orders");
        grid.gridx = 1;
        grid.gridy = 0;
        grid.gridwidth = 1;
        sortButton.addActionListener(sortInfo);
        panel.add(sortButton, grid);
        
        JButton displayInfoButton = new JButton("Display Info");
        grid.gridx = 2;
        grid.gridy = 0;
        grid.gridwidth = 1;
        displayInfoButton.addActionListener(displayInfo);
        panel.add(displayInfoButton, grid);
        
        JButton writeIntoFileButton = new JButton("Save to .txt");
        grid.gridx = 1;
        grid.gridy = 1;
        grid.gridwidth = 1;
        writeIntoFileButton.addActionListener(writeIntoFile);
        panel.add(writeIntoFileButton, grid);
        
        JButton backToMenuButton = new JButton("Back to Main Menu");
        grid.gridx = 2;
        grid.gridy = 1;
        grid.gridwidth = 1;
        backToMenuButton.addActionListener(backToMenu);
        panel.add(backToMenuButton, grid);
    }
}
