public class Patient {
    private String name;
    private int age;
    private String gender;
    private String contactDetails;

    public Patient(String name, int age, String gender, String contactDetails) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactDetails = contactDetails;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }
}
