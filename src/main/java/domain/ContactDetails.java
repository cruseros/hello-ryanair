package domain;

public class ContactDetails {
    private String country;
    private int phoneNumber;
    private boolean sendSms;
    private boolean sendNewsletter;
    private boolean donateFootprint;

    public ContactDetails(String country, int phoneNumber) {
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
