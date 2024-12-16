package com.example.patreg.model;

public class Patient {
    private String firstName;
    private String lastName;
    private String dob;
    private double weight;
    private double shoeSize;

    public Patient(String firstName, String lastName, String dob, double weight, double shoeSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.weight = weight;
        this.shoeSize = shoeSize;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public double getShoeSize() { return shoeSize; }
    public void setShoeSize(double shoeSize) { this.shoeSize = shoeSize; }
}
