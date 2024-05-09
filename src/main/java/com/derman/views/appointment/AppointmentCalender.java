package com.derman.views.appointment;

import com.derman.Main;
import com.derman.controller.AppointmentController;
import com.derman.controller.DoctorController;
import com.derman.controller.PolyclinicController;
import com.derman.model.Doctor;
import com.derman.model.Polyclinic;
import com.derman.model.Session;
import com.derman.views.alerts.AlertBox;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AppointmentCalender {
    private JButton geriButton;
    private JList<String> polyclinicList;
    private JList<String> monthList;
    private JList<Integer> dayList;
    private JList<String> hoursList;
    private JButton createAppointmentButton;
    private JList<String> doctorList;
    private JPanel appointmentCalenderPanel;

    public List<Doctor> doctors;
    public List<String> timeList;

    public int polyclinic_id;
    public int doctor_id;
    public int month;
    public int day;
    public int hour;
    public int minute;

    public void setDefaultAllList(){
        List<Polyclinic> allPolyclinics = PolyclinicController.getAllPolyclinics();
        List<String> polyclinicNames = new ArrayList<>();
        for(Polyclinic pol : allPolyclinics){
            polyclinicNames.add(pol.getName());
        }
        polyclinicList.setListData(polyclinicNames.toArray(new String[polyclinicNames.size()]));
        doctorList.setListData(new String[]{});
        monthList.setListData(new String[]{});
        dayList.setListData(new Integer[]{});
        hoursList.setListData(new String[]{});
    }

    public AppointmentCalender() {
        Map<Integer,String> months =new HashMap<Integer,String>();
        months.put(1,"Ocak");
        months.put(2,"Şubat");
        months.put(3,"Mart");
        months.put(4,"Nisan");
        months.put(5,"Mayıs");
        months.put(6,"Haziran");
        months.put(7,"Temmuz");
        months.put(8,"Ağustos");
        months.put(9,"Eylül");
        months.put(10,"Ekim");
        months.put(11,"Kasım");
        months.put(12,"Aralık");

        List<Integer> days = new ArrayList<>();

        // Diziyi 1'den 31'e kadar olan sayılarla doldurma
        for (int i = 0; i < 31; i++) {
            days.add(i+1);
        }


        List<Polyclinic> allPolyclinics = PolyclinicController.getAllPolyclinics();
        List<String> polyclinicNames = new ArrayList<>();
        for(Polyclinic pol : allPolyclinics){
            polyclinicNames.add(pol.getName());
        }

        polyclinicList.setListData(polyclinicNames.toArray(new String[polyclinicNames.size()]));

        polyclinicList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    int selectedIndex = polyclinicList.getSelectedIndex();
                    if(selectedIndex != -1){
                        Polyclinic selectedPolyclinic = allPolyclinics.get(selectedIndex);
                        polyclinic_id = selectedPolyclinic.getId();
                        doctors = DoctorController.getAllDoctorByPolyclinicId(selectedPolyclinic.getId());
                        List<String> doctorNames = new ArrayList<>();
                        for(Doctor doctor : doctors){
                            doctorNames.add(doctor.getName() + " " + doctor.getSurname());
                        }
                        doctorList.setListData(doctorNames.toArray(new String[doctors.size()]));
                        monthList.setListData(new String[]{});
                        dayList.setListData(new Integer[]{});
                        hoursList.setListData(new String[]{});
                        //System.out.println(allDoctors);
                    }


                }
            }
        });



        doctorList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    int selectedIndex = doctorList.getSelectedIndex();
                    if(selectedIndex != - 1){
                        doctor_id = doctors.get(selectedIndex).getId();
                        monthList.setListData(months.values().toArray(new String[0]));
                        dayList.setListData(new Integer[]{});
                        hoursList.setListData(new String[]{});
                    }
                }
            }
        });

        monthList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    int selectedIndex = monthList.getSelectedIndex();
                    if(selectedIndex != -1){
                        month = months.keySet().toArray(new Integer[]{})[selectedIndex];
                        dayList.setListData(days.toArray(new Integer[]{}));
                        hoursList.setListData(new String[]{});
                    }
                }
            }
        });

        dayList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    int selectedIndex = dayList.getSelectedIndex();
                    if(selectedIndex != -1){
                        day = days.get(selectedIndex);
                        // oradan olan kayıtları getir

                        List<Session> sessions = AppointmentController.getAllAvailableAppointmentHours(polyclinic_id,doctor_id,month,day);
                        List<String> times = new ArrayList<>();

                        for(Session tmpSession : sessions){
                            String minuteStr;
                            if(tmpSession.getMinute() == 0){
                                minuteStr =  "00";
                            }else{
                                minuteStr = String.valueOf(tmpSession.getMinute());
                            }

                            String timeText = tmpSession.getHour() + " : " + minuteStr;
                            times.add(timeText);
                        }
                        timeList = times;
                        hoursList.setListData(times.toArray(new String[]{}));
                    }

                }
            }
        });

        hoursList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = hoursList.getSelectedIndex();
                if(selectedIndex != -1){
                    String[] tokens = timeList.get(selectedIndex).split(" : ");
                    hour = Integer.parseInt(tokens[0]);
                    minute = Integer.parseInt(tokens[1]);
                }
            }
        });
        geriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.goBack();
            }
        });

        createAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean result = AppointmentController.createAppointment(doctor_id,Main.patientSearchData.getId(),polyclinic_id,month,day,hour,minute);
                if (result){
                    AlertBox.ShowError(appointmentCalenderPanel,"Randevu Kaydı başarılı bir şekilde oluşturuldu !");
                    setDefaultAllList();
                    Main.goBack();
                }else{
                    AlertBox.ShowError(appointmentCalenderPanel,"Randevu Kaydı Oluşturma Hatası !");
                }
                //System.out.println(Main.patientSearchData);
            }
        });


    }

    public JPanel getAppointmentCalenderPanel() {
        return appointmentCalenderPanel;
    }
}
