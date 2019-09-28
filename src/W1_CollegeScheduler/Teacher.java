package W1_CollegeScheduler;

public class Teacher {
    private String name;
    private String specialty;
    private String email;
    private String phoneNumber;
    private char gender;

    public Teacher() {
    }

    public Teacher(String name, String specialty, String email, String phoneNumber, char gender) {
        this.name = name;
        this.specialty = specialty;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.specialty + ")";
    }


    public String getName() {
        return this.name;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public char getGender() {
        return this.gender;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
