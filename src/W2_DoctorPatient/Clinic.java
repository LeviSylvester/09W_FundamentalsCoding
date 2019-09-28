package W2_DoctorPatient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clinic {
    private String name;
    private static List<Doctor> doctors;
    private static List<Patient> patients;
    private List<Appointment> appointments;
    public static Scanner scanner;

    public Clinic() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public Clinic(String name) {
        this.name = name;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "name='" + name + '\'' +
                ", appointments=" + appointments +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public static void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public static void addPatient(Patient patient) {
        patients.add(patient);
    }

    public static void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void addAppointment(Appointment appointment) {
        LocalDate thisDate = appointment.getDate();
        int count = 0;
        for (Appointment a : this.appointments) {
            if (a.getDate().isEqual(thisDate)) {
                count++;
            }
        }
        if (count < 6) {
            this.appointments.add(appointment);
        } else {
            print("Schedule is full for this date!");
        }
    }

    public void removeAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
    }

    public static void print(String txt) {
        System.out.println(txt);
    }

    public static char getOptionFromInput() {
        return scanner.next().charAt(0);
    }

    public static void printPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public static void printDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public void printAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public static LocalDate buildDateFromInput() {
        LocalDate date;
        print("Enter year in yyyy format:");
        int year = scanner.nextInt();
        print("Enter month in (1)m format (without 0):");
        int month = scanner.nextInt();
        print("Enter day in (d)d format (without 0):");
        int day = scanner.nextInt();
        date = LocalDate.of(year, month, day);
        return date;
    }

    public Appointment existingAppointmentFromInput() {
        print("Enter the no. of the appointment you'd like to select:");
        int appointmentNoFromInput = scanner.nextInt();
        Appointment existingAppointment = new Appointment();
        for (Appointment appointment : appointments) {
            if (appointment.getNo() == appointmentNoFromInput) {
                existingAppointment = appointment;
            }
        }
        return existingAppointment;
    }

    public static Doctor existingDoctorFromInput() {
        print("Enter the name of the doctor you'd like to select:");
        String doctorNameFromInput = scanner.next();
        Doctor existingDoctor = new Doctor();
        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(doctorNameFromInput)) {
                existingDoctor = doctor;
            }
        }
        return existingDoctor;
    }

    public static Patient existingPatientFromInput() {
        print("Enter the name of the patient you'd like to select:");
        String patientNameFromInput = scanner.next();
        Patient existingPatient = new Patient();
        for (Patient patient : patients) {
            if (patient.getName().equals(patientNameFromInput)) {
                existingPatient = patient;
            }
        }
        return existingPatient;
    }


    public Appointment makeAppointmentFromInput() {
        Appointment appointment = new Appointment();
        int count = 0;
        for (Appointment a : this.appointments){
            count++;
        }
        count++;
        appointment.setNo(count);
        appointment.setDate(buildDateFromInput());
        appointment.setDoctor(existingDoctorFromInput());
        appointment.setPatient(existingPatientFromInput());
        return appointment;
    }

    public static Patient constructPatientFromInput() {
        Patient patient = new Patient();
        print("Enter patient's name:");
        patient.setName(scanner.next());
        print("Enter patient's disease");
        patient.setDisease(scanner.next());
        print("Enter patient's phone number:");
        patient.setPhoneNumber(scanner.next());
        return patient;
    }

    public static Doctor constructDoctorFromInput() {
        Doctor doctor = new Doctor();
        print("Enter doctor's name:");
        doctor.setName(scanner.next());
        print("Enter doctor's specialty");
        doctor.setSpecialty(scanner.next());
        print("Enter doctor's email:");
        doctor.setEmail(scanner.next());
        print("Enter doctor's phone number:");
        doctor.setPhoneNumber(scanner.next());
        return doctor;
    }
}