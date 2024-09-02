public class Bill {
    private Appointment appointment;
    private double amount;
    private boolean paid;

    public Bill(Appointment appointment, double amount) {
        this.appointment = appointment;
        this.amount = amount;
        this.paid = false; // default to unpaid
    }

    // Getters
    public Appointment getAppointment() {
        return appointment;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }

    // Method to pay the bill
    public void pay() {
        this.paid = true;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "appointment=" + appointment +
                ", amount=" + amount +
                ", paid=" + paid +
                '}';
    }
}
