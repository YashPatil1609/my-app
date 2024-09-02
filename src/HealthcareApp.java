import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HealthcareApp {

    private List<Patient> patients;
    private List<Appointment> appointments;
    private List<Bill> bills;

    public HealthcareApp() {
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        bills = new ArrayList<>();
    }

    // Methods for managing patients
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient findPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    // Methods for managing appointments
    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAppointmentsForPatient(Patient patient) {
        List<Appointment> patientAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().equals(patient)) {
                patientAppointments.add(appointment);
            }
        }
        return patientAppointments;
    }

    // Methods for managing billing
    public void generateBill(Appointment appointment, double amount) {
        Bill bill = new Bill(appointment, amount);
        bills.add(bill);
    }

    public List<Bill> getBillsForPatient(Patient patient) {
        List<Bill> patientBills = new ArrayList<>();
        for (Bill bill : bills) {
            if (bill.getAppointment().getPatient().equals(patient)) {
                patientBills.add(bill);
            }
        }
        return patientBills;
    }

    public void payBill(int billId) {
        if (billId >= 0 && billId < bills.size()) {
            Bill bill = bills.get(billId);
            bill.pay();
            System.out.println("Bill paid successfully.");
        } else {
            System.out.println("Invalid Bill ID.");
        }
    }

    // Method to view patient profile
    // View patient profile
    public void viewPatientProfile(String patientName) {
    Patient patient = findPatientByName(patientName);
    if (patient == null) {
        System.out.println("Patient not found.");
        return;
    }

    System.out.println("Patient Profile:");
    System.out.println("Name: " + patient.getName());
    System.out.println("Age: " + patient.getAge());
    System.out.println("Gender: " + patient.getGender());
    System.out.println("Contact Details: " + patient.getContactDetails());

    List<Appointment> patientAppointments = getAppointmentsForPatient(patient);
    System.out.println("Appointments:");
    for (Appointment appointment : patientAppointments) {
        System.out.println("Date: " + appointment.getDate() + ", Time: " + appointment.getTime() + ", Notes: " + appointment.getNotes());
    }

    List<Bill> patientBills = getBillsForPatient(patient);
    System.out.println("Billing Information:");
    for (int i = 0; i < patientBills.size(); i++) {
        Bill bill = patientBills.get(i);
        System.out.println("Bill ID: " + i + ", Amount: " + bill.getAmount() + ", Paid: " + bill.isPaid());
    }
}


    // Main method for console interaction
    public static void main(String[] args) {
        HealthcareApp app = new HealthcareApp();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nHealthcare Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Generate Bill");
            System.out.println("4. Pay Bill");
            System.out.println("5. View Patient Profile");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Patient Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Patient Contact Details: ");
                    String contactDetails = scanner.nextLine();
                    Patient patient = new Patient(name, age, gender, contactDetails);
                    app.addPatient(patient);
                    System.out.println("Patient added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    Patient existingPatient = app.findPatientByName(patientName);
                    if (existingPatient != null) {
                        System.out.print("Enter Appointment Date: ");
                        String date = scanner.nextLine();
                        System.out.print("Enter Appointment Time: ");
                        String time = scanner.nextLine();
                        System.out.print("Enter Notes: ");
                        String notes = scanner.nextLine();
                        Appointment appointment = new Appointment(existingPatient, date, time, notes);
                        app.scheduleAppointment(appointment);
                        System.out.println("Appointment scheduled successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient Name: ");
                    String billingPatientName = scanner.nextLine();
                    Patient billingPatient = app.findPatientByName(billingPatientName);
                    if (billingPatient != null) {
                        List<Appointment> patientAppointments = app.getAppointmentsForPatient(billingPatient);
                        if (!patientAppointments.isEmpty()) {
                            System.out.print("Enter Appointment Date to Bill: ");
                            String billingDate = scanner.nextLine();
                            Appointment appointmentToBill = null;
                            for (Appointment a : patientAppointments) {
                                if (a.getDate().equalsIgnoreCase(billingDate)) {
                                    appointmentToBill = a;
                                    break;
                                }
                            }
                            if (appointmentToBill != null) {
                                System.out.print("Enter Bill Amount: ");
                                double amount = scanner.nextDouble();
                                app.generateBill(appointmentToBill, amount);
                                System.out.println("Bill generated successfully.");
                            } else {
                                System.out.println("Appointment not found.");
                            }
                        } else {
                            System.out.println("No appointments found for this patient.");
                        }
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Bill ID to Pay: ");
                    int billId = scanner.nextInt();
                    app.payBill(billId);
                    break;

                case 5:
                    System.out.print("Enter Patient Name: ");
                    String profilePatientName = scanner.nextLine();
                    app.viewPatientProfile(profilePatientName);
                    break;

                case 6:
                    System.out.print("Enter Report Type (appointments/billing): ");
                    String reportType = scanner.nextLine();
                    app.generateReport(reportType);
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }

    // Report generation
    public void generateReport(String reportType) {
        if ("appointments".equalsIgnoreCase(reportType)) {
            ReportGenerator.generateAppointmentReport(appointments);
        } else if ("billing".equalsIgnoreCase(reportType)) {
            ReportGenerator.generateBillingReport(bills);
        } else {
            System.out.println("Unknown report type: " + reportType);
        }
    }
}
