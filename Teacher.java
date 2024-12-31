package StudentTeacherRecordSystem;

import java.util.Arrays;

public class Teacher extends Individual{
    private String[] courses = new String[5];

    //constructor
    public Teacher(String name, String id, String[] courses) {
        super(name, id);
        this.courses = courses;
    }

    public String[] getCourses() {
        return courses;
    }

    @Override
    public String getDetails(){
        return "Teacher Name : "+name+", Teacher ID : "+id+", Courses : "+ Arrays.toString(courses);
    }
}
