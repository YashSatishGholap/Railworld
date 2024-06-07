import Dao.*;
import Model.*;
import Service.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/HMS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PatientDao patientDao = new PatientDao(connection);
            DoctorDao doctorDao = new DoctorDao(connection);
            AppointmentDao appointmentDao = new AppointmentDao(connection);
            ReceptionistDao receptionistDao = new ReceptionistDao(connection);

            PatientService patientService = new PatientService(patientDao);
            DoctorService doctorService = new DoctorService(doctorDao);
            AppointmentService appointmentService = new AppointmentService(appointmentDao);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patient");
                System.out.println("2. Add Doctor");
                System.out.println("3. Update Patient");
                System.out.println("4. Delete Patient");
                System.out.println("5. Update Doctor");
                System.out.println("6. Delete Doctor");
                System.out.println("7. View Patients");
                System.out.println("8. View Doctors");
                System.out.println("9. Book Appointment");
                System.out.println("10. View Appointments");
                System.out.println("11. Record Transaction");
                System.out.println("12. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Patient Name: ");
                        String name = scanner.next();
                        System.out.print("Enter Patient Age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter Patient Gender: ");
                        String gender = scanner.next();
                        Patient newPatient = new Patient();
                        newPatient.setName(name);
                        newPatient.setAge(age);
                        newPatient.setGender(gender);
                        patientService.addPatient(newPatient);
                        System.out.println("Patient Added Successfully!");
                        break;
                    case 2:
                        System.out.print("Enter Doctor Name: ");
                        String doctorName = scanner.next();
                        System.out.print("Enter Doctor Specialization: ");
                        String specialization = scanner.next();
                        Doctor newDoctor = new Doctor();
                        newDoctor.setName(doctorName);
                        newDoctor.setSpecialization(specialization);
                        doctorService.addDoctor(newDoctor);
                        System.out.println("Doctor Added Successfully!");
                        break;
                    case 3:
                        System.out.print("Enter Patient ID to update: ");
                        int updateId = scanner.nextInt();
                        if (patientService.getPatientById(updateId)) {
                            System.out.print("Enter Patient Name: ");
                            String updateName = scanner.next();
                            System.out.print("Enter Patient Age: ");
                            int updateAge = scanner.nextInt();
                            System.out.print("Enter Patient Gender: ");
                            String updateGender = scanner.next();
                            Patient updatePatient = new Patient();
                            updatePatient.setId(updateId);
                            updatePatient.setName(updateName);
                            updatePatient.setAge(updateAge);
                            updatePatient.setGender(updateGender);
                            patientService.updatePatient(updatePatient);
                            System.out.println("Patient Updated Successfully!");
                        } else {
                            System.out.println("Patient ID not found!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Patient ID to delete: ");
                        int deleteId = scanner.nextInt();
                        if (patientService.getPatientById(deleteId)) {
                            patientService.deletePatient(deleteId);
                            System.out.println("Patient Deleted Successfully!");
                        } else {
                            System.out.println("Patient ID not found!");
                        }
                        break;
                    case 5:
                        System.out.print("Enter Doctor ID to update: ");
                        int updateDoctorId = scanner.nextInt();
                        if (doctorService.getDoctorById(updateDoctorId)) {
                            System.out.print("Enter Doctor Name: ");
                            String updateDoctorName = scanner.next();
                            System.out.print("Enter Doctor Specialization: ");
                            String updateSpecialization = scanner.next();
                            Doctor updateDoctor = new Doctor();
                            updateDoctor.setId(updateDoctorId);
                            updateDoctor.setName(updateDoctorName);
                            updateDoctor.setSpecialization(updateSpecialization);
                            doctorService.updateDoctor(updateDoctor);
                            System.out.println("Doctor Updated Successfully!");
                        } else {
                            System.out.println("Doctor ID not found!");
                        }
                        break;
                    case 6:
                        System.out.print("Enter Doctor ID to delete: ");
                        int deleteDoctorId = scanner.nextInt();
                        if (doctorService.getDoctorById(deleteDoctorId)) {
                            doctorService.deleteDoctor(deleteDoctorId);
                            System.out.println("Doctor Deleted Successfully!");
                        } else {
                            System.out.println("Doctor ID not found!");
                        }
                        break;
                    case 7:
                        List<Patient> patients = patientService.getAllPatients();
                        System.out.println("Patients:");
                        System.out.println("+------------+--------------------+----------+------------+");
                        System.out.println("| Patient Id | Name               | Age      | Gender     |");
                        System.out.println("+------------+--------------------+----------+------------+");
                        for (Patient patient : patients) {
                            System.out.printf("| %-10d | %-18s | %-8d | %-10s |\n", patient.getId(), patient.getName(), patient.getAge(), patient.getGender());
                        }
                        System.out.println("+------------+--------------------+----------+------------+");
                        break;
                    case 8:
                        List<Doctor> doctors = doctorService.getAllDoctors();
                        System.out.println("Doctors:");
                        System.out.println("+------------+--------------------+-------------------------+");
                        System.out.println("| Doctor Id  | Name               | Specialization          |");
                        System.out.println("+------------+--------------------+-------------------------+");
                        for (Doctor doctor : doctors) {
                            System.out.printf("| %-10d | %-18s | %-23s |\n", doctor.getId(), doctor.getName(), doctor.getSpecialization());
                        }
                        System.out.println("+------------+--------------------+-------------------------+");
                        break;

                    case 9:
                        System.out.print("Enter Patient Id: ");
                        int patientId = scanner.nextInt();
                        System.out.print("Enter Doctor Id: ");
                        int doctorId = scanner.nextInt();
                        System.out.print("Enter Appointment Date and Time (yyyy-MM-ddTHH:mm:ss): ");
                        String dateTimeString = scanner.next();
                        LocalDateTime appointmentDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);


                        Date currentDate = new Date();
                        if (appointmentDateTime.isBefore(LocalDateTime.now())) {
                            System.out.println("Invalid date! Appointment date cannot be in the past.");
                            break;
                        }

                        if (patientService.getPatientById(patientId) && doctorService.getDoctorById(doctorId)) {
                            if (appointmentService.isDoctorAvailable(doctorId, appointmentDateTime )) {
                                Appointment appointment = new Appointment();
                                appointment.setPatientId(patientId);
                                appointment.setDoctorId(doctorId);
                                appointment.setAppointmentDateTime(appointmentDateTime);
                                appointmentService.bookAppointment(appointment);
                                System.out.println("Appointment Booked Successfully!");
                            } else {
                                System.out.println("The Doctor is not available at the selected date and time.");
                            }
                        } else {
                            System.out.println("Either doctor or patient doesn't exist!");
                        }
                        break;
                    case 10:
                        List<Appointment> appointments = appointmentService.getAllAppointments();
                        System.out.println("Appointments:");
                        System.out.println("+----------------+------------+-----------+-------------------+");
                        System.out.println("| Appointment Id | Patient Id | Doctor Id | Date and Time     |");
                        System.out.println("+----------------+------------+-----------+-------------------+");
                        for (Appointment appointment : appointments) {
                            System.out.printf("| %-14d | %-10d | %-9d | %-17s |\n", appointment.getId() , appointment.getPatientId() , appointment.getDoctorId() , appointment.getAppointmentDateTime());
                        }
                        System.out.println("+----------------+------------+-----------+-------------------+");
                        break;
                    case 11:
                        System.out.print("Enter Doctor Id: ");
                        int transactionDoctorId = scanner.nextInt();
                        System.out.print("Enter Fee Amount: ");
                        double fee = scanner.nextDouble();
                        receptionistDao.recordTransaction(transactionDoctorId, fee);
                        System.out.println("Transaction Recorded Successfully!");
                        break;
                    case 12:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

