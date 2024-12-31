package StudentTeacherRecordSystem;

import java.util.ArrayList;

public class StudentTeacherRecordSystem {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;

    public StudentTeacherRecordSystem() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        FileManager.saveStudents(students);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        FileManager.saveTeachers(teachers);
    }
}
