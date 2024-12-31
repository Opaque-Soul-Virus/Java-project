package StudentTeacherRecordSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class StudentGUI implements ActionListener {
    private StudentTeacherRecordSystem recordSystem = new StudentTeacherRecordSystem();
    private FileManager fileManager = new FileManager();
    JFrame frame = new JFrame("Student Teacher Record System");
    JLabel studentLabel = new JLabel("Add Student:");
    JLabel userLabel = new JLabel("Name:");
    JTextField nameText = new JTextField(20);
    JLabel idLabel = new JLabel("ID:");
    JTextField idText = new JTextField(20);
    JLabel gradesLabel = new JLabel("Grades (5):");
    JTextField gradesText = new JTextField(20);
    JButton addStudentButton = new JButton("Add Student");
    JButton backButton = new JButton("Back");
    JButton showRecordsButton = new JButton("Show Records");

    public StudentGUI() {
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        studentLabel.setBounds(80, 100, 150, 25);
        frame.add(studentLabel);
        userLabel.setBounds(80, 150, 80, 25);
        frame.add(userLabel);
        nameText.setBounds(145, 150, 165, 25);
        frame.add(nameText);
        idLabel.setBounds(80, 200, 80, 25);
        frame.add(idLabel);
        idText.setBounds(145, 200, 165, 25);
        frame.add(idText);
        gradesLabel.setBounds(80, 250, 80, 25);
        frame.add(gradesLabel);
        gradesText.setBounds(145, 250, 165, 25);
        frame.add(gradesText);
        addStudentButton.setBounds(110, 300, 125, 25);
        frame.add(addStudentButton);
        backButton.setBounds(180, 350, 125, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);
        addStudentButton.addActionListener(this);
        showRecordsButton.setBounds(235, 300, 125, 25);
        frame.add(showRecordsButton);
        showRecordsButton.addActionListener(this);
        frame.setLocation(400,150);
        //frame.getContentPane().setBackground(Color.RED);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addStudentButton){
            try {
                String name = nameText.getText();
                String id = idText.getText();
                double[] grades = Arrays.stream(gradesText.getText().split(",")).mapToDouble(Double::parseDouble).toArray();
                Student student = new Student(name, id, grades);
                recordSystem.addStudent(student);
                JOptionPane.showMessageDialog(null, "Student added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
        if(e.getSource()==showRecordsButton){
            fileManager.loadStudents();
        }
        if(e.getSource()==backButton){
            new StudentTeacherSelectionClass();
            frame.dispose();
        }
    }
}
