package W1_CollegeScheduler;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private Teacher teacher;
    private int maximumStudents;
    private List<Student> students;

    public Group() {
        this.students = new ArrayList<>();
    }

    public Group(String name, Teacher teacher, int maximumStudents) {
        this.name = name;
        this.teacher = teacher;
        this.maximumStudents = maximumStudents;
        this.students = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.name + ": teacher " + this.teacher + "; max " + this.maximumStudents + " students " + this.students;
    }

    public String getName() {
        return this.name;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public int getMaximumStudents() {
        return this.maximumStudents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setMaximumStudents(int maximumStudents) {
        this.maximumStudents = maximumStudents;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeTeacher() {
        this.teacher = null;
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

}
