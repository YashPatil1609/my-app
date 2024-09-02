public class Appointment {
    private Patient patient;
    private String date;
    private String time;
    private String notes;

    public Appointment(Patient patient, String date, String time, String notes) {
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    // Getters
    public Patient getPatient() {
        return patient;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
