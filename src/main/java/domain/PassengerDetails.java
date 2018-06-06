package domain;

import org.apache.commons.lang.RandomStringUtils;

public class PassengerDetails {
    private String title;
    private String firstName;
    private String lastName;

    public PassengerDetails() {
        this.title = "";
        this.firstName = RandomStringUtils.randomAlphabetic(7);
        this.lastName = RandomStringUtils.randomAlphabetic(7);
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
