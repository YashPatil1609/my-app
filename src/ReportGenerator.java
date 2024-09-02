import java.util.List;

public class ReportGenerator {

    public static void generateAppointmentReport(List<Appointment> appointments) {
        System.out.println("Appointment Report:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public static void generateBillingReport(List<Bill> bills) {
        System.out.println("Billing Report:");
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }

    // Add more report types as needed
}
