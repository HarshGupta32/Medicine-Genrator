package com.example.medicine_generator;

public class Hospital {

    String name,address,number,treatment,lati,longi;

    public Hospital() {
    }

    public Hospital(String name, String address, String number, String treatment, String lati, String longi) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.treatment = treatment;
        this.lati = lati;
        this.longi = longi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }
}
