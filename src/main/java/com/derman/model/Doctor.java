package com.derman.model;

public class Doctor extends Account{

    private Polyclinic polyclinic;

    public Doctor(int id, String username, String name, String surname, String password, String role,Polyclinic polyclinic) {
        super(id, username, name, surname, password, role);
        this.polyclinic = polyclinic;
    }

    public Polyclinic getPolyclinic() {
        return polyclinic;
    }

    public void setPolyclinic(Polyclinic polyclinic) {
        this.polyclinic = polyclinic;
    }
}
