package com.derman;

import com.derman.model.Patient;
import com.derman.views.Login;
import com.derman.views.appointment.AppointmentCalender;
import com.derman.views.appointment.AppointmentRecordShow;
import com.derman.views.appointment.AppointmentSearch;
import com.derman.views.doctor.DoctorCreate;
import com.derman.views.menu.*;
import com.derman.views.patient.PatientCreate;
import com.derman.views.patient.PatientSearch;
import com.derman.views.patient.PatientShow;
import com.derman.views.patient.PatientUpdate;
import com.derman.views.polyclinic.PolyclinicCreate;
import com.derman.views.treatment.InsuranceDetail;
import com.derman.views.treatment.TreatmentCreate;
import com.derman.views.treatment.TreatmentRecordShow;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;


public class  Main {

    // burada stack tutmak gerekiyor

    public static Stack<String> visitedPages = new Stack<>();

    public static Object data = null;

    public static String afterPatientSearch = "";

    public static Patient patientSearchData = null;

    public static CardLayout cardLayout;

    public static JPanel cardPanel;

    public static void goBack(){
        Main.visitedPages.pop();
        String lastPage = Main.visitedPages.pop();
        Main.changeScreen(lastPage);
    }
    public static void changeScreen(String screenName){
        visitedPages.push(screenName);
        cardLayout.show(cardPanel,screenName);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        cardPanel = new JPanel();
        cardLayout = new CardLayout();

        // tüm ekranları oluştur

        // menu
        Login login = new Login();
        AppointmentAttendantMenu appointmentAttendantMenu = new AppointmentAttendantMenu();
        CashierMenu cashierMenu = new CashierMenu();
        ChiefDoctorMenu chiefDoctorMenu = new ChiefDoctorMenu();
        DoctorMenu doctorMenu = new DoctorMenu();
        RegistrarMenu registrarMenu = new RegistrarMenu();

        // appointment
        AppointmentCalender appointmentCalender = new AppointmentCalender();
        AppointmentRecordShow appointmentRecordShow = new AppointmentRecordShow();
        AppointmentSearch appointmentSearch = new AppointmentSearch();

        // doctor
        DoctorCreate doctorCreate = new DoctorCreate();

        // patient
        PatientUpdate patientUpdate = new PatientUpdate();
        PatientCreate patientCreate = new PatientCreate();
        PatientSearch patientSearch = new PatientSearch();
        PatientShow patientShow = new PatientShow();


        // polyclinic
        PolyclinicCreate polyclinicCreate = new PolyclinicCreate();

        // treatment
        InsuranceDetail insuranceDetail = new InsuranceDetail();
        TreatmentCreate treatmentCreate = new TreatmentCreate();
        TreatmentRecordShow treatmentRecordShow = new TreatmentRecordShow();


        cardPanel.setLayout(cardLayout);
        frame.getContentPane().add(cardPanel, BorderLayout.CENTER);


        // tüm ekranları yükleme ve daha sonra geçiş için kullanma

        // menu
        cardPanel.add(login.getLoginContentPanel(),"Giris");
        cardPanel.add(appointmentAttendantMenu.getAppointmentAttendantPanel(),"RandevuGorevlisiMenu");
        cardPanel.add(cashierMenu.getCashierMenuPanel(),"VeznedarMenu");
        cardPanel.add(chiefDoctorMenu.getChiefDoctorMenuPanel(),"BasHekimMenu");
        cardPanel.add(doctorMenu.getDoctorMenuPanel(),"DoktorMenu");
        cardPanel.add(registrarMenu.getRegistrarMenuPanel(),"KayitGorevlisiMenu");

        // appointment
        cardPanel.add(appointmentCalender.getAppointmentCalenderPanel(),"RandevuEkrani");
        cardPanel.add(appointmentRecordShow.getAppointmentRecordShowPanel(),"RandevuKayitGoster");
        cardPanel.add(appointmentSearch.getAppointmentSearchPanel(),"RandevuAra");

        // doctor
        cardPanel.add(doctorCreate.getDoctorCreatePanel(),"DoktorOlustur");

        // patient
        cardPanel.add(patientUpdate.getPatientUpdatePanel(),"HastaGuncelle");
        cardPanel.add(patientCreate.getPatientCreatePanel(),"HastaOlustur");
        cardPanel.add(patientSearch.getPatientSearchPanel(),"HastaAra");
        cardPanel.add(patientShow.getPatientShowPanel(),"HastaGoster");


        // polyclinic
        cardPanel.add(polyclinicCreate.getPolyclinicCreatePanel(),"PoliklinikOlustur");

        // treatment
        cardPanel.add(insuranceDetail.getInsuranceDetailPanel(),"SigortaDetay");
        cardPanel.add(treatmentCreate.getTreatmentCreatePanel(),"TedaviOlustur");
        cardPanel.add(treatmentRecordShow.getTreatmentRecordShowPanel(),"TedaviKaydiGoster");

        frame.pack();
        frame.setVisible(true);

        cardLayout.show(cardPanel,"Giriş");
    }

}