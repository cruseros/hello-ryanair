package domain;

import pages.helpers.Credentials;

public class Login {
    private String email;
    private String password;

    public Login(Credentials credentials) {
        this.email = credentials.getEmail();
        this.password = credentials.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
