package StudentTeacherRecordSystem;

import javax.swing.*;
import java.io.*;
import java.sql.Array;
import java.util.ArrayList;

public class FileManager {
    private static final String STUDENT_FILE = "students.txt";
    private static final String TEACHER_FILE = "teachers.txt";

    public static void saveStudents(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_FILE,true))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getId() + "," +"["+ gradesToString(student.getGrades())+"]");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            String[] records = new String[20];
            int i=0;
            while ((line = reader.readLine()) != null) {
               records[i]=line;
               i++;
            }
            JOptionPane.showMessageDialog(null,records,"Student Records :",JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTeachers(ArrayList<Teacher> teachers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEACHER_FILE))) {
            for (Teacher teacher : teachers) {
                writer.write(teacher.getName() + "," + teacher.getId() + "," +"["+ String.join(",", teacher.getCourses())+"]");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTeachers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TEACHER_FILE))) {
            String line;
            String[] records = new String[20];
            int i=0;
            while ((line = reader.readLine()) != null) {
                records[i]=line;
                i++;
            }
            JOptionPane.showMessageDialog(null,records,"Teacher Records :",JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String gradesToString(double[] grades) {
        StringBuilder sb = new StringBuilder();
        for (double grade : grades) {
            sb.append(grade).append(" ");
        }
        return sb.toString().trim();
    }
}
