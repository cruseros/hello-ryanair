package domain;

public class PaxDetails {
    private Title title;
    private String firstName;
    private String lastName;
    private boolean specialAssitance;

    public PaxDetails(Title title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Title getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
