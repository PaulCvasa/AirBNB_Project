package com.company;

public class Homeowner {
    protected String firstName;
    protected String lastName;
    protected int ownerID;
    protected String phoneNumber;


    public Homeowner(String firstName, String lastName, int ownerID, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownerID = ownerID;
        this.phoneNumber = phoneNumber;
    }

    public Homeowner() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Homeowner{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ownerID=" + ownerID +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
