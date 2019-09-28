package W2_DoctorPatient;

import java.time.LocalDate;

import static W2_DoctorPatient.Clinic.*;

public class Appointment {
    private int no;
    private LocalDate date;
    private Doctor doctor;
    private Patient patient;

    public Appointment() {
    }

    public Appointment(int no, LocalDate date, Doctor doctor, Patient patient) {
        this.no = no;
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "No." + this.no + ":" + this.date + ":" + this.doctor.getName() + ":" + this.patient.getName();
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static void updateAppointment(Appointment appointment) {
        boolean cancel = false;
        print("Select a) doctor, b) patient or c) cancel:");
        while (!cancel) {
            switch (getOptionFromInput()) {
                case 'a':
                    appointment.setDoctor(existingDoctorFromInput());
                    break;
                case 'b':
                    appointment.setPatient(existingPatientFromInput());
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
