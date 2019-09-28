package W2_DoctorPatient;


import java.time.LocalDate;

import static W2_DoctorPatient.Clinic.*;
import static W2_DoctorPatient.Appointment.updateAppointment;
import static W2_DoctorPatient.Patient.updatePatient;
import static W2_DoctorPatient.Doctor.updateDoctor;

/*Create a doctor patient appointment application. We will have a patient class and a doctor class.
The patient will have a name, a disease, and a phone number.
The doctor will also have a name, a specialty, an email and a phone number.
We also need an appointment class which will have the date of the appointment,
the doctor holding the appointment and the patient.
We will also need a clinic class with state: name, and a list of appointments.[list of doctors, list of patients]
 *I want to be able to add doctors & patients, and appointments only for already created doctors & patients.
 **I want to add only 6 appointments per day as my clinic is very small and i want to add only 2 per doctor
 as my doctors are very lazy.
 ***As my business grows i want to add another clinic sharing both the doctors and the patients
 but because this one is bigger i want it to take 10 appointments per day as a maximum
 and because at the new clinic we have coffee
 the doctors are now able to take 3 appointments per day at this clinic.
 Since the doctors are shared, if all their appointments are at the second clinic
 they can have up to 3 appointments, if they are shared or all at the first clinic
 then only 2 appoinments (no coffee, no appointment)*/
public class Main {
    public static void main(String[] args) {

        Clinic clinic1 = new Clinic("firstClinic");
        Clinic clinic2 = new Clinic("secondClinic");

        Doctor doctor1 = new Doctor("doctor1", "general", "doctor1@email.com", "012");
        Doctor doctor2 = new Doctor("doctor2", "general", "doctor2@email.com", "023");
//        Doctor doctor3 = new Doctor();
//        Doctor doctor4 = new Doctor();
        addDoctor(doctor1);
        addDoctor(doctor2);

        Patient patient1 = new Patient("patient1", "disease", "0123456789");
        Patient patient2 = new Patient("patient2", "disease", "0234567891");
//        Patient patient3 = new Patient();
//        Patient patient4 = new Patient();
//        Patient patient5 = new Patient();
//        Patient patient6 = new Patient();
//        Patient patient7 = new Patient();
        addPatient(patient1);
        addPatient(patient2);

        Appointment appointment1 = new Appointment(1, LocalDate.of(2019, 9, 23), doctor1, patient1);
        Appointment appointment2 = new Appointment(2, LocalDate.of(2019,9,23), doctor2, patient2);

        clinic1.addAppointment(appointment1);
        clinic1.addAppointment(appointment2);


        print("Welcome to our clinic!");

        boolean exit = false;

        while (!exit) {

            print("Enter a character from the Menu:");
            print("a  Add appointment   g  Remove appointment");
            print("b  Add patient       h  Remove patient");
            print("c  Add doctor        i  Remove doctor");
            print("d  List appointments j  Update appointment");
            print("e  List patients     k  Update patient");
            print("f  List doctors      l  Update doctor");
            print("▼                    m  Exit");

            switch (getOptionFromInput()) {
                case 'a':
                    clinic1.addAppointment(clinic1.makeAppointmentFromInput());
                    break;
                case 'b':
                    addPatient(constructPatientFromInput());
                    break;
                case 'c':
                    addDoctor(constructDoctorFromInput());
                    break;
                case 'd':
                    clinic1.printAppointments();
                    break;
                case 'e':
                    printPatients();
                    break;
                case 'f':
                    printDoctors();
                    break;
                case 'g':
                    clinic1.removeAppointment(clinic1.existingAppointmentFromInput());
                    break;
                case 'h':
                    removePatient(existingPatientFromInput());
                    break;
                case 'i':
                    removeDoctor(existingDoctorFromInput());
                    break;
                case 'j':
                    updateAppointment(clinic1.existingAppointmentFromInput());
                    break;
                case 'k':
                    updatePatient(existingPatientFromInput());
                    break;
                case 'l':
                    updateDoctor(existingDoctorFromInput());
                    break;
                case 'm':
                    exit = true;
                    break;
                default:
                    print("Not a valid input! Try again:");
            }
        }
        print("Goodbye!");
    }
    //toDo 1. max 2 appointments/doctor 2. clinic2 3. more checks & regex 4. nicer appointment-table
}
