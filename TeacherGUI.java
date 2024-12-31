package StudentTeacherRecordSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherGUI implements ActionListener {
    private StudentTeacherRecordSystem recordSystem = new StudentTeacherRecordSystem();;
    private FileManager fileManager = new FileManager();
    JFrame frame = new JFrame("Student Teacher Record System");
    JLabel teacherLabel = new JLabel("Add Teacher:");
    JLabel teacherNameLabel = new JLabel("Name:");
    JTextField teacherNameText = new JTextField(20);
    JLabel teacherIdLabel = new JLabel("ID:");
    JTextField teacherIdText = new JTextField(20);
    JLabel coursesLabel = new JLabel("Courses (5):");
    JTextField coursesText = new JTextField(20);
    JButton addTeacherButton = new JButton("Add Teacher");
    JButton showRecordsButton = new JButton("Show Records");
    JButton backButton = new JButton("Back");


    public TeacherGUI() {
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setLayout(null);
        teacherLabel.setBounds(80, 100, 150, 25);
        frame.add(teacherLabel);
        teacherNameLabel.setBounds(80, 150, 80, 25);
        frame.add(teacherNameLabel);
        teacherNameText.setBounds(155, 150, 165, 25);
        frame.add(teacherNameText);
        teacherIdLabel.setBounds(80, 200, 80, 25);
        frame.add(teacherIdLabel);
        teacherIdText.setBounds(155, 200, 165, 25);
        frame.add(teacherIdText);
        coursesLabel.setBounds(80, 250, 80, 25);
        frame.add(coursesLabel);
        coursesText.setBounds(155, 250, 165, 25);
        frame.add(coursesText);
        addTeacherButton.setBounds(100, 300, 115, 25);
        frame.add(addTeacherButton);
        addTeacherButton.addActionListener(this);
        showRecordsButton.setBounds(220, 300, 125, 25);
        frame.add(showRecordsButton);
        showRecordsButton.addActionListener(this);
        backButton.setBounds(150,350,125,30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);
        frame.setLocation(400,150);
       // frame.getContentPane().setBackground(Color.RED);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addTeacherButton){
            try {
                String name = teacherNameText.getText();
                String id = teacherIdText.getText();
                String[] courses = coursesText.getText().split(",");
                if (courses.length != 5) {
                    throw new IllegalArgumentException("Exactly 5 courses must be entered.");
                }
                Teacher teacher = new Teacher(name, id, courses);
                recordSystem.addTeacher(teacher);
                JOptionPane.showMessageDialog(null, "Teacher added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
        if(e.getSource()==showRecordsButton){
            fileManager.loadTeachers();
        }
        if(e.getSource()==backButton){
            new StudentTeacherSelectionClass();
            frame.dispose();
        }
    }
}
