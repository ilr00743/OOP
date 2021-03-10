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
    
    private final Student STUDENT = new Student();
    
    public StudentForm(final Form form) {
        this.setTitle("STUDENT FORM");
        this.setBounds(380, 290, 760, 350);
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
        
        ActionListener sortInfo = (ActionEvent event) -> STUDENT.sortArrayList();
        
        ActionListener writeIntoFile = (ActionEvent event) -> STUDENT.writeFile();
        
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
        };
        
        ImageIcon backToMenuIcon = new ImageIcon("D:\\study\\Practic OOP\\Practic-OOP\\PR_4\\src\\icons\\back_to_menu.png");
        JButton backToMenuButton = new JButton(backToMenuIcon);
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
        panel.add(displayInfoButton, grid);
        
        JButton sortButton = new JButton("Sorting of students");
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        sortButton.addActionListener(sortInfo);
        panel.add(sortButton, grid);
        
        JButton writeIntoFileButton = new JButton("Save to students.txt");
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
        
        JButton addInfoButton = new JButton("Add Student Info");
        grid.gridx = 0;
        grid.gridy = 8;
        grid.gridwidth = 0;
        addInfoButton.addActionListener(addContactInfo);
        panel.add(addInfoButton, grid);
    }
}
