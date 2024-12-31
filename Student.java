package StudentTeacherRecordSystem;

import java.util.Arrays;

public class Student extends Individual{
    private double[] grades = new double[5];

    //constructor
    public Student(String name, String id, double[] grades) {
        super(name, id);
        if(grades.length == 5){
            this.grades = grades;
        }else {
            throw new IllegalArgumentException("You must provided exactly 5 grades.");
        }
    }

    public double[] getGrades() {
        return grades;
    }

    @Override
    public String getDetails(){
        return "Student Name : "+name+", Student ID : "+id+", Grades : "+ Arrays.toString(grades);
    }
}