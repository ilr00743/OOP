package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Student;

import interfaces.Form;

import java.io.FileReader;
import java.io.IOException;

public class StudentForm extends JFrame{
    
    private final Student STUDENT;
    
    public StudentForm(final Form form) {
        this.STUDENT = new Student();
        
        this.setTitle("STUDENT FORM");
        this.setBounds(380, 290, 780, 350);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridBagLayout());
        this.setContentPane(panel);
        panel.setBackground(Color.getHSBColor(0.19f, 0.32f, 0.67f));
        
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

        JLabel groupLabel = new JLabel("Group: ");
        grid.gridx = 2;
        grid.gridy = 3;
        grid.gridwidth = 1;
        groupLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(groupLabel,grid);
        
        JTextField groupField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(groupField, grid);
        
        JLabel departmentLabel = new JLabel("Department: ");
        grid.gridx = 2;
        grid.gridy = 4;
        grid.gridwidth = 1;
        departmentLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(departmentLabel,grid);
        
        JTextField departmentField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 4;
        grid.gridwidth = 1;
        panel.add(departmentField, grid);
        
        JLabel disciplineLabel = new JLabel("Discipline: ");
        grid.gridx = 2;
        grid.gridy = 5;
        grid.gridwidth = 1;
        disciplineLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(disciplineLabel,grid);
        
        JTextField disciplineField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 5;
        grid.gridwidth = 1;
        panel.add(disciplineField, grid);
        
        JLabel markLabel = new JLabel("Mark: ");
        grid.gridx = 2;
        grid.gridy = 6;
        grid.gridwidth = 1;
        markLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(markLabel,grid);
        
        JTextField markField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 6;
        grid.gridwidth = 1;
        panel.add(markField, grid);
        
        JLabel teacherLabel = new JLabel("Name of teacher: ");
        grid.gridx = 2;
        grid.gridy = 7;
        grid.gridwidth = 1;
        teacherLabel.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(teacherLabel,grid);
        
        JTextField teacherField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 7;
        grid.gridwidth = 1;
        panel.add(teacherField, grid);
        
        ActionListener displayInfo = (ActionEvent event) -> {
            try(FileReader fileReader = new FileReader("students.txt")) {
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
        
        ActionListener sortById = (ActionEvent event) -> {
            STUDENT.sortById();
            STUDENT.writeFile();
        };
        
        ActionListener reverseSortById = (ActionEvent event) -> {
            STUDENT.reverseSortById();
            STUDENT.writeFile();
        };
        
        ActionListener sortByLastName = (ActionEvent event) -> {
            STUDENT.sortByLastName();
            STUDENT.writeFile();
        };
        
        ActionListener sortByMark = (ActionEvent event) -> {
            STUDENT.sortByMark();
            STUDENT.writeFile();
        };
        
        ActionListener backToMenu = (ActionEvent event) -> form.changeStudentForm();
        
        ActionListener clearTextFields = (ActionEvent event) -> {
            idField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            groupField.setText("");
            departmentField.setText("");
            disciplineField.setText("");
            markField.setText("");
            teacherField.setText("");
        };
        
        ActionListener addContactInfo = (ActionEvent event) -> {
            STUDENT.setId(Integer.parseInt(idField.getText()));
            STUDENT.setFirstName(firstNameField.getText());
            STUDENT.setLastName(lastNameField.getText());
            STUDENT.setGroup(Integer.parseInt(idField.getText()));
            STUDENT.setDepartment(departmentField.getText());
            STUDENT.setDiscipline(disciplineField.getText());
            STUDENT.setMark(Byte.parseByte(markField.getText()));
            STUDENT.setNameTeacher(teacherField.getText());
            STUDENT.fillingArrayList();
            STUDENT.writeFile();
        };
        
        ImageIcon backToMenuIcon = new ImageIcon("D:\\study\\Practic OOP\\Practic-OOP\\PR_4\\src\\icons\\back_to_menu.png");
        JButton backToMenuButton = new JButton(backToMenuIcon);
        backToMenuButton.setBackground(Color.getHSBColor(3, 12, 13));
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 1;
        backToMenuButton.addActionListener(backToMenu);
        panel.add(backToMenuButton, grid);
        
        JButton displayInfoButton = new JButton("Display Info");
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        displayInfoButton.addActionListener(displayInfo);
        displayInfoButton.setBackground(Color.getHSBColor(3, 12, 13));;
        panel.add(displayInfoButton, grid);
        
        JButton sortByIdButton = new JButton("Sorting By ID");
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        sortByIdButton.addActionListener(sortById);
        sortByIdButton.setBackground(Color.getHSBColor(3, 12, 13));
        panel.add(sortByIdButton, grid);
        
        JButton reverseSortByIdButton = new JButton("Reverse Sorting by ID");
        grid.gridx = 0;
        grid.gridy = 3;
        grid.gridwidth = 1;
        reverseSortByIdButton.addActionListener(reverseSortById);
        reverseSortByIdButton.setBackground(Color.getHSBColor(3, 12, 13));
        panel.add(reverseSortByIdButton, grid);
        
        JButton sortByLastNameButton = new JButton("Sorting by Last Name");
        grid.gridx = 0;
        grid.gridy = 4;
        grid.gridwidth = 1;
        sortByLastNameButton.addActionListener(sortByLastName);
        sortByLastNameButton.setBackground(Color.getHSBColor(3, 12, 13));
        panel.add(sortByLastNameButton, grid);
        
        JButton sortByMarkButton = new JButton("Descending Sorting by mark");
        grid.gridx = 0;
        grid.gridy = 5;
        grid.gridwidth = 1;
        sortByMarkButton.addActionListener(sortByMark);
        sortByMarkButton.setBackground(Color.getHSBColor(3, 12, 13));
        panel.add(sortByMarkButton, grid);
        
        JButton clearTextFieldsButton = new JButton("Clear text fields");
        grid.gridx = 0;
        grid.gridy = 8;
        grid.gridwidth = 1;
        clearTextFieldsButton.addActionListener(clearTextFields);
        clearTextFieldsButton.setBackground(Color.getHSBColor(3, 12, 13));
        panel.add(clearTextFieldsButton, grid);
                
        JButton addInfoButton = new JButton("Add Order Info");
        grid.gridx = 0;
        grid.gridy = 10;
        grid.gridwidth = 0;
        addInfoButton.addActionListener(addContactInfo);
        addInfoButton.setBackground(Color.getHSBColor(3, 12, 13));
        panel.add(addInfoButton, grid);
    }
}