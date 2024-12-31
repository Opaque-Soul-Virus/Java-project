package StudentTeacherRecordSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentTeacherSelectionClass implements ActionListener {
    private JFrame frame = new JFrame("Student or Teacher selection Page : ");
    private JLabel studentLevel = new JLabel("If you want to add student in records click 'Student'.");
    private JLabel teacherLevel = new JLabel("Or,If you want to add teacher in records click 'Teacher'.");
    private JButton student = new JButton("Student");
    private JButton teacher = new JButton("Teacher");

    //constructor
    public StudentTeacherSelectionClass(){
        studentLevel.setBounds(90,90,350,50);
        studentLevel.setForeground(Color.BLACK);
        teacherLevel.setBounds(90,105,350,50);
        teacherLevel.setForeground(Color.BLACK);
        student.setBounds(150,150,150,40);
        student.setFocusable(false);
        student.addActionListener(this);

        teacher.setBounds(150,200,150,40);
        teacher.setFocusable(false);
        teacher.addActionListener(this);

        frame.add(studentLevel);
        frame.add(teacherLevel);
        frame.add(student);
        frame.add(teacher);
        frame.setSize(500,450);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLocation(400,150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==student){
            StudentGUI studentGUI = new StudentGUI();
            frame.dispose();
        } else if (e.getSource()==teacher) {
            TeacherGUI teacherGUI = new TeacherGUI();
            frame.dispose();
        }
    }
}
