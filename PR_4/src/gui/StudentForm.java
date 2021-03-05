package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Student;

import interfaces.Form;

public class StudentForm extends JFrame{
    
    private final Student student = new Student();
    
    public StudentForm(final Form form) {
        this.setTitle("STUDENT FORM");
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
        grid.gridy = 1;
        grid.gridwidth = 1;
        panel.add(firstNameField, grid);
        
        JLabel lastNameLabel = new JLabel("Last Name");
        grid.gridx = 4;
        grid.gridy = 2;
        grid.gridwidth = 1;
        panel.add(lastNameLabel, grid);
        
        JTextField lastNameField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 2;
        grid.gridwidth = 1;
        panel.add(lastNameField, grid);
        
        JLabel groupLabel = new JLabel("Group");
        grid.gridx = 4;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(groupLabel,grid);
        
        JTextField groupField = new JTextField();
        grid.gridx = 5;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(groupField, grid);
        
        JLabel departmentLabel = new JLabel("Department");
        grid.gridx = 6;
        grid.gridy = 0;
        grid.gridwidth = 1;
        panel.add(departmentLabel,grid);
        
        JTextField departmentField = new JTextField();
        grid.gridx = 7;
        grid.gridy = 0;
        grid.gridwidth = 1;
        panel.add(departmentField, grid);
        
        JLabel disciplineLabel = new JLabel("Discipline");
        grid.gridx = 6;
        grid.gridy = 1;
        grid.gridwidth = 1;
        panel.add(disciplineLabel,grid);
        
        JTextField disciplineField = new JTextField();
        grid.gridx = 7;
        grid.gridy = 1;
        grid.gridwidth = 1;
        panel.add(disciplineField, grid);
        
        JLabel markLabel = new JLabel("Mark");
        grid.gridx = 6;
        grid.gridy = 2;
        grid.gridwidth = 1;
        panel.add(markLabel,grid);
        
        JTextField markField = new JTextField();
        grid.gridx = 7;
        grid.gridy = 2;
        grid.gridwidth = 1;
        panel.add(markField, grid);
        
        JLabel teacherLabel = new JLabel("Name of teacher");
        grid.gridx = 6;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(teacherLabel,grid);
        
        JTextField teacherField = new JTextField();
        grid.gridx = 7;
        grid.gridy = 3;
        grid.gridwidth = 1;
        panel.add(teacherField, grid);
        
        ActionListener backToMenu = (ActionEvent event) -> form.changeStudentForm();
        
        ActionListener addContactInfo = (ActionEvent event) -> {
            student.setId(Integer.parseInt(idField.getText()));
            student.setFirstName(firstNameField.getText());
            student.setLastName(lastNameField.getText());
            student.setGroup(Integer.parseInt(idField.getText()));
            student.setDepartment(departmentField.getText());
            student.setDiscipline(disciplineField.getText());
            student.setMark(Byte.parseByte(markField.getText()));
            student.setNameTeacher(teacherField.getText());
            student.fillingArrayList();
        };
        
        ActionListener displayInfo = (ActionEvent event) -> {
            StringBuilder strBuilder = new StringBuilder();
            
            for(int i = 0; i < student.getArrayList().size(); i++) {
                strBuilder.append(student.getArrayList().get(i)).append('\n');
            }
            
            JOptionPane.showMessageDialog(null, strBuilder.toString(), "Students Info", JOptionPane.PLAIN_MESSAGE);
        };
        
        ActionListener sortInfo = (ActionEvent event) -> student.sortingArrayList();
        
        ActionListener writeIntoFile = (ActionEvent event) -> student.writeFile();
        
        JButton addInfoButton = new JButton("Add Student Info");
        grid.gridx = 4;
        grid.gridy = 5;
        grid.gridwidth = 4;
        addInfoButton.addActionListener(addContactInfo);
        panel.add(addInfoButton, grid);
        
        JButton sortButton = new JButton("Sorting of students");
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
