package W1_CollegeScheduler;

public class Student {
    private String name;
    private String email;
    private int stage;
    private char gender;
    private int age;

    public Student() {
    }

    public Student(String name, String email, int stage, char gender, int age) {
        this.name = name;
        this.email = email;
        this.stage = stage;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.getStage() + ")";
    }


    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getStage() {
        return this.stage;
    }

    public char getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
