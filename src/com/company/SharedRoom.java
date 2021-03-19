package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedRoom extends Homeowner implements SpaceProperties {
    protected String city;
    protected String address;
    protected int nrOfBeds;
    protected List<String> checkinDates = new ArrayList<>();
    protected List<String> checkoutDates = new ArrayList<>();
    protected int nrOfReservations = 0;

    @Override
    public boolean privateBathroom(){ return false; }

    @Override
    public boolean providedToiletries(){
        return true;
    }

    @Override
    public boolean smokingAllowed(){
        return false;
    }

    @Override
    public boolean availableWifi(){
        return true;
    }

    @Override
    public boolean availableTV(){
        return false;
    }

    @Override
    public boolean airConditioning(){
        return true;
    }

    public SharedRoom(int ownerID, String city, String address, int nrOfBeds) {
        this.ownerID = ownerID;
        this.city = city;
        this.address = address;
        this.nrOfBeds = nrOfBeds;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getNrOfBeds() {
        return nrOfBeds;
    }

    public int getNrOfReservations() {
        return nrOfReservations;
    }

    public List<String> getCheckinDates() {
        return checkinDates;
    }

    public List<String> getCheckoutDates() {
        return checkoutDates;
    }

    public void setCheckinDates(String checkinDate) {
        this.checkinDates.add(checkinDate);
    }

    public void setCheckoutDates(String checkoutDate) {
        this.checkoutDates.add(checkoutDate);
    }

    public void setNrOfReservations(int nrOfReservations) {
        this.nrOfReservations = nrOfReservations;
    }

    public void addedReservation() {
        this.nrOfReservations++;
    }

    @Override
    public String toString() {
        return "SharedRoom{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", nrOfBeds=" + nrOfBeds +
                ", checkinDates=" + checkinDates +
                ", checkoutDates=" + checkoutDates +
                ", ownerID= " + ownerID +
                ", privateBathroom= " + privateBathroom() +
                ", providedToiletries= " + providedToiletries() +
                ", smokingAllowed= " + smokingAllowed() +
                ", availableWifi= " + availableWifi() +
                ", availableTV= " + availableTV() +
                ", airConditioning= " + airConditioning() +
                '}';
    }
}