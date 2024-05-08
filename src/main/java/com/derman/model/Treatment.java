package com.derman.model;

public class Treatment {
    private int id;
    private Doctor doctor;
    private String complaint;
    private String tests;
    private String diagnosis;
    private String prescriptions;
    private Patient patient;

    public Treatment(int id, Doctor doctor,Patient patient, String complaint, String tests, String diagnosis, String prescriptions) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.complaint = complaint;
        this.tests = tests;
        this.diagnosis = diagnosis;
        this.prescriptions = prescriptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }
}
