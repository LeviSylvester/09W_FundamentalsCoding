package W1_CollegeScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class College {
    private List<Student> students;
    private List<Group> groups;
    private List<Teacher> teachers;
    private String name;
    private Scanner scanner;

    public College(String name) {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.name = name;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static void display(String toUser) {
        System.out.println(toUser);
    }

    public void addStudent(Student student) {
        this.students.add(student);
//        display("You've added " + student.getName() + ": " + student.getEmail() + ", stage " + student.getStage() + ", " + student.getGender() + ", age " + student.getAge());
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
//        display("You've added " + teacher.getName() + ": " + "specialty " + teacher.getSpecialty() + ", " + teacher.getGender() + ", " + teacher.getEmail() + ", tel. " + teacher.getPhoneNumber());
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
    }

    public void removeGroup(Group group) {
        this.groups.remove(group);
    }

    public char getOptionFromInput() {
        return this.scanner.next().charAt(0);
    }

    public Student constructStudentFromInput() {
        Student student = new Student();
        display("Enter student's name:");
        student.setName(scanner.next());
        display("Enter student's email:");
        student.setEmail(scanner.next());
        display("Enter student's stage with digit(s):");
        student.setStage(scanner.nextInt());
        display("Enter student's gender:");
        student.setGender(scanner.next().charAt(0));
        display("Enter student's age with digits:");
        student.setAge(scanner.nextInt());
        return student;
    }

    public Teacher constructTeacherFromInput() {
        Teacher teacher = new Teacher();
        display("Enter teacher's name:");
        teacher.setName(scanner.next());
        display("Enter teacher's specialty:");
        teacher.setSpecialty(scanner.next());
        display("Enter teacher's gender:");
        teacher.setGender(scanner.next().charAt(0));
        display("Enter teacher's email:");
        teacher.setEmail(scanner.next());
        display("Enter teacher's phone number:");
        teacher.setPhoneNumber(scanner.next());
        return teacher;
    }

    public Group createEmptyGroupFromInput() {
        Group group = new Group();
        display("Enter group's name:");
        group.setName(scanner.next());
        display("Enter group's maximum number of students with digits:");
        group.setMaximumStudents(scanner.nextInt());
        return group;
    }

    public Group existingGroupFromInput() {
        display("Enter the name of the group you'd like to select:");
        String groupNameFromInput = scanner.next();
        Group existingGroup = new Group();
        for (Group group : this.groups) {
            if (group.getName().equals(groupNameFromInput)) {
                existingGroup = group;
            }
        }
        return existingGroup;
    }

    public Teacher existingTeacherFromInput() {
        display("Enter the name of the teacher you'd like to select:");
        String teacherNameFromInput = scanner.next();
        Teacher existingTeacher = new Teacher();
        for (Teacher teacher : this.teachers) {
            if (teacher.getName().equals(teacherNameFromInput)) {
                existingTeacher = teacher;
            }
        }
        return existingTeacher;
    }

    public Student existingStudentFromInput() {
        display("Enter the name of the student you'd like to select:");
        String studentNameFromInput = scanner.next();
        Student existingStudent = new Student();
        for (Student student : this.students) {
            if (student.getName().equals(studentNameFromInput)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void printTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public void printGroups() {
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    //delete if not used
//    public Student findStudent(String email) {
//        for (Student student : this.students) {
//            if (student.getEmail().equals(email)) {
//                return student;
//            }
//        }
//        return null;
//    }

//    public void removeStudent(String email) {
//        Student student = findStudent(email);
//        {
//            if (student != null) {
//                this.students.remove(student);
//            } else {
//                System.out.println("does not exist");
//            }
//        }

//    }

//    public Student findStudent(String email){
//        if (doesStudentExist(email)){
//            for (Student student: students){
//
//            }
//        }
//    }

//    public boolean isTeacherDuplicate(String email) {
//        boolean isDuplicate = false;
//        for (Teacher teacher : this.teachers) {
//            if (teacher.getEmail().equals(email)) {
//                isDuplicate = true;
//                break;
//            }
//        }
//        return isDuplicate;
//    }

}
