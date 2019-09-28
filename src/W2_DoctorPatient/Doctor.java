package W2_DoctorPatient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static W2_DoctorPatient.Clinic.getOptionFromInput;
import static W2_DoctorPatient.Clinic.print;

public class Doctor {
    private String name;
    private String specialty;
    private String email;
    private String phoneNumber;

    public Doctor() {
    }

    public Doctor(String name, String specialty, String email, String phoneNumber) {
        this.name = name;
        this.specialty = specialty;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void updateDoctor(Doctor doctor){
        boolean cancel = false;
        print("Select a) specialty, b) email, c) phone number or d) cancel:");
        while(!cancel){
            switch(getOptionFromInput()){
                case 'a':
                    doctor.setSpecialty(Clinic.scanner.next());
                    break;
                case 'b':
                    doctor.setEmail(Clinic.scanner.next());
                    break;
                case 'c':
                    doctor.setPhoneNumber(Clinic.scanner.next());
                    break;
                case 'd':
                    cancel = true;
                    break;
                default:
                    print("Invalid input, try again!");
            }
        }
    }
}
