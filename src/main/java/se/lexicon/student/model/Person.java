package se.lexicon.student.model;

public class Person {
    private static int PersonCount = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email) {
        ++PersonCount;
        this.id = PersonCount;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email field cannot be null or empty.");
        }
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void getSummary() {
        System.out.println("Id: " + id + ", " + firstName + " " + lastName + ", Email: " + email);
    }
}