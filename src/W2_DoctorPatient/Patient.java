package W2_DoctorPatient;

import static W2_DoctorPatient.Clinic.getOptionFromInput;
import static W2_DoctorPatient.Clinic.print;

public class Patient {
    private String name;
    private String disease;
    private String phoneNumber;

    public Patient() {
    }

    public Patient(String name, String disease, String phoneNumber) {
        this.name = name;
        this.disease = disease;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", disease='" + disease + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void updatePatient(Patient patient){
        boolean cancel = false;
        print("Select a) disease, b) phone number or c) cancel:");
        while(!cancel){
            switch(getOptionFromInput()){
                case 'a':
                    patient.setDisease(Clinic.scanner.next());
                    break;
                case 'b':
                    patient.setPhoneNumber(Clinic.scanner.next());
                    break;
                case 'c':
                    cancel = true;
                    break;
                default:
                    print("Invalid input, try again!");
            }
        }
    }
}
