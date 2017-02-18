package saltmineworkers.saltminehackathon;

/**
 * Created by Sondre on 18.02.2017.
 *
 * Hardkodet UserModel som midlertidig løsning til bruk av brukerinformasjon i appen.
 * Dette skal egentlig være koblet opp mot DB, og en UserModel genereres ved autentisering ved å 'fetche' brukerdata
 */

public class UserModel {
    private static String firstName;
    private static String surName;
    private static String username;
    private static String email;
    private static int phoneNr;
    private static int age;
    private static String interest;

    /**
    public void UserModel(String firstName, String surName, String username, String email, int phoneNr, int age) {
        this.firstName = firstName;
        this.surName = surName;
        this.username = username;
        this.email = email;
        this.phoneNr = phoneNr;
        this.age = age;

    }
     */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

}
