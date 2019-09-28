package W1_CollegeScheduler;

import static W1_CollegeScheduler.College.display;

/*Create an online class scheduler. Basically we will be able to add students and teachers into a
database (memory, array/arrayList), and add a teacher to a class (Group) and enroll students to that class
and remove students from an enrolled class. Each class (Group) should have a different maximum allowed students.
Teacher has name, specialty, email, phone number, gender. Student has name, email, stage, gender, age.
Class Group has a name, teacher, a specified number of maximumStudents and the List of students enrolled.
Class College will represent all groups.
*)in scanner, options to create a new group, new students, and teacher, and enroll a single teacher and
multiple students (until maximum number is achieved) to an already created group [as well as options to remove idem].
**)create a room scheduler, basically each group will held the course in a room.
I want to be able to add groups to a room only when it is available (maximum 4 groups per day).
==> a new class room with number, date and a list of groups; a class school where i'll have a list of rooms.*/

public class Scheduler {

    public static void main(String[] args) {

        //Let's add some data to have something already to test with in the Scheduler!

        Student alina = new Student("Alina", "alina@mail.com", 9, 'f', 14);
        Student erik = new Student("Erik", "erik@ mail.com", 9, 'm', 14);
        Student geli = new Student("Geli", "geli@mail.com", 9, 'm', 14);
        Student georgian = new Student("Georgian", "georgian@mail.com", 10, 'm', 15);
        Student ioana = new Student("Ioana", "ioana@mail.com", 10, 'f', 15);
        Student levi = new Student("Levi", "levi@mail.com", 10, 'm', 15);
        Student mihai = new Student("Mihai", "mihai@mail.com", 11, 'm', 16);
        Student paul = new Student("Paul", "paul@mail.com", 11, 'm', 16);
        Student radu = new Student("Radu", "radu@mail.com", 11, 'm', 16);
        Student timea = new Student("Timea", "timea@mail.com", 12, 'f', 17);
        Student vasile = new Student("Vasile", "vasile@mail.com", 12, 'm', 17);

        Teacher daniel = new Teacher("Daniel", "Fundamentals", "wilhelm@mail.com", "012", 'm');
        Teacher alex = new Teacher("Alex", "FundamCoding", "alex@mail.com", "023", 'm');
        Teacher lucian = new Teacher("Lucian", "Advanced", "lucian@mail.com", "034", 'm');
        Teacher denisa = new Teacher("Denisa", "AdvCoding", "denisa@mail.com", "045", 'f');
        Teacher wilhelm = new Teacher("Wilhelm", "Science", "wilhelm@mail.com", "056", 'm');
        Teacher sorin = new Teacher("Sorin", "Versioning", "wilhelm@mail.com", "067", 'm');
        Teacher catalin = new Teacher("Catalin", "Algorithms", "wilhelm@mail.com", "078", 'm');

        //Leave sdCollege here when you remove test data, 'cause the scheduler has no option to create a new college
        //_________________________________________________
        College sdCollege = new College("SDCollege");
        //_________________________________________________
        sdCollege.addStudent(alina);
        sdCollege.addStudent(erik);
        sdCollege.addStudent(geli);
        sdCollege.addStudent(georgian);
        sdCollege.addStudent(ioana);
        sdCollege.addStudent(levi);
        sdCollege.addStudent(mihai);
        sdCollege.addStudent(paul);
        sdCollege.addStudent(radu);
        sdCollege.addStudent(timea);
        sdCollege.addStudent(vasile);

        sdCollege.addTeacher(daniel);
        sdCollege.addTeacher(alex);
        sdCollege.addTeacher(lucian);
        sdCollege.addTeacher(denisa);
        sdCollege.addTeacher(wilhelm);
        sdCollege.addTeacher(sorin);
        sdCollege.addTeacher(catalin);

        Group stage9 = new Group("Stage9", daniel, 4);
        Group stage10 = new Group("Stage10", alex, 4);
        Group stage11 = new Group("Stage11", lucian, 4);
        Group stage12 = new Group("Stage12", denisa, 3);

        sdCollege.addGroup(stage9);
        sdCollege.addGroup(stage10);
        sdCollege.addGroup(stage11);
        sdCollege.addGroup(stage12);

        stage9.addStudent(alina);
        stage9.addStudent(erik);
        stage9.addStudent(geli);

        stage10.addStudent(georgian);
        stage10.addStudent(ioana);
        stage10.addStudent(levi);

        stage11.addStudent(mihai);
        stage11.addStudent(radu);
        stage11.addStudent(paul);

        stage12.addStudent(timea);
        stage12.addStudent(vasile);

        /*Leave schoolSchedule here with its rooms when you remove the rest,
        because the scheduler holds no option to create new school & rooms yet.
        ___________________________________________________*/
        School schoolSchedule = new School();

        Room roomI = new Room(1, "Turing");
        Room roomII = new Room(2, "Ritchie");
        Room roomIII = new Room(3, "Jobs");
        Room roomIV = new Room(4, "Torvalds");

        schoolSchedule.addRoom(roomI);
        schoolSchedule.addRoom(roomII);
        schoolSchedule.addRoom(roomIII);
        schoolSchedule.addRoom(roomIV);
        //__________________________________________________

        roomI.addGroup(stage9);
        roomI.addGroup(stage10);
        roomI.addGroup(stage11);
        roomI.addGroup(stage12);
        roomII.addGroup(stage9);
        roomII.addGroup(stage10);
        roomII.addGroup(stage11);
        roomII.addGroup(stage12);
        roomIII.addGroup(stage9);
        roomIII.addGroup(stage10);
        roomIII.addGroup(stage11);
        roomIII.addGroup(stage12);
        roomIV.addGroup(stage9);
        roomIV.addGroup(stage10);
        roomIV.addGroup(stage11);
//        roomIV.addGroup(stage12);

        //Here comes the scheduler itself:

        display("Welcome to SDCollege!");

        boolean quit = false;

        while (!quit) {

            display("________________________________________");
            display("a) Add new student | j) Erase student   |");
            display("b) Add new teacher | k) Erase teacher   |");
            display("c) Create group    | l) Erase group     |");
            display("d) Enroll a teacher| m) Withdraw teacher|");
            display("e) Enroll student  | n) Withdraw student|");
            display("f) List students   | o) Schedule class  |");
            display("g) List teachers   | p) Remove class    |");
            display("h) List groups     |                    |");
            display("i) List schedule   | q) Quit            |");
            display("▼ Enter an option from 'a' to 'q' below:");

            switch (sdCollege.getOptionFromInput()) {
                case 'a':
                    sdCollege.addStudent(sdCollege.constructStudentFromInput());
                    break;
                case 'b':
                    sdCollege.addTeacher(sdCollege.constructTeacherFromInput());
                    break;
                case 'c':
                    sdCollege.addGroup(sdCollege.createEmptyGroupFromInput());
                    break;
                case 'd':
                    sdCollege.existingGroupFromInput().setTeacher(sdCollege.existingTeacherFromInput());
                    break;
                case 'e':
                    sdCollege.existingGroupFromInput().addStudent(sdCollege.existingStudentFromInput());
                    break;
                case 'f':
                    sdCollege.printStudents();
                    break;
                case 'g':
                    sdCollege.printTeachers();
                    break;
                case 'h':
                    sdCollege.printGroups();
                    break;
                case 'i':
                    schoolSchedule.printRooms();
                    break;
                case 'j':
                    sdCollege.removeStudent(sdCollege.existingStudentFromInput());
                    break;
                case 'k':
                    sdCollege.removeTeacher(sdCollege.existingTeacherFromInput());
                    break;
                case 'l':
                    sdCollege.removeGroup(sdCollege.existingGroupFromInput());
                    break;
                case 'm':
                    sdCollege.existingGroupFromInput().removeTeacher();
                    break;
                case 'n':
                    sdCollege.existingGroupFromInput().removeStudent(sdCollege.existingStudentFromInput());
                    break;
                case 'o':
                    schoolSchedule.existingRoomFromInput().addGroup(sdCollege.existingGroupFromInput());
                    break;
                case 'p':
                    schoolSchedule.existingRoomFromInput().removeGroup(sdCollege.existingGroupFromInput());
                    break;
                case 'q':
                    quit = true;
                    break;
                default:
                    display("Not a valid input! Try again:");
            }
        }
        display("Goodbye!");
    }
    //toDo: 1. more checks & regex 2. scheduling by date (not only a single set of 4 rooms)
}
