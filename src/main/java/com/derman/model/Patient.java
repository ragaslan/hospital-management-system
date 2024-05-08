package com.derman.model;

public class Patient {
    private int id;
    private String tc;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String blood;
    private String alergies;
    private String diseases;

    public Patient(int id, String tc, String name, String surname, String phone, String address, String blood, String alergies, String diseases) {
        this.id = id;
        this.tc = tc;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.blood = blood;
        this.alergies = alergies;
        this.diseases = diseases;
    }

    public Patient() {  };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }
}
