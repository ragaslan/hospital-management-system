package com.derman.views.treatment;

import com.derman.Main;
import com.derman.model.Patient;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TreatmentRecordShow {
    private JButton profilButton;
    private JButton geriButton;
    private JTextField textField1;
    private JTextField textField3;
    private JButton sigortaBilgisiSorgulaButton;
    private JPanel treatmentRecordShowPanel;



    //TODO tedavi görüntüleme (emir yapacak yani ben)

    public TreatmentRecordShow() {

        ComponentListener componentListener = new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                Main.afterPatientSearch = "TedaviKaydiGoster";
                if (Main.patientSearchData == null)
                    Main.changeScreen("HastaAra");
            }
        };
        treatmentRecordShowPanel.addComponentListener(componentListener);


    }


    public JPanel getTreatmentRecordShowPanel() {
        return treatmentRecordShowPanel;
    }
}
