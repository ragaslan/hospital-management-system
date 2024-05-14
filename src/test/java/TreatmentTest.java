import com.derman.model.Doctor;
import com.derman.model.Patient;
import com.derman.model.Polyclinic;
import com.derman.model.Treatment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreatmentTest {

    private Treatment treatment;

    @BeforeEach
    void beforeEachTest(){
        Polyclinic polyclinic = new Polyclinic(10,"KBB");
        Doctor theDoctor = new Doctor(12,"doctor1","ahmet","can","05551233445","123456","doktor",polyclinic);
        Patient thePatient = new Patient(44,"24913312234","ramazan","agaslan","05510231145","Gaziantep şehitkamil","AB+","yok","yok","sgk");
        treatment = new Treatment(25,theDoctor,thePatient,"boğaz şişliği","akciğer tomogrofisi","soğuk algınlığı","antibiyotik");
    }


    @Test
    void testTreatmentComplaint(){
        Assertions.assertEquals("boğaz şişliği",treatment.getComplaint());
    }

    @Test
    void testTreatmentTests(){
        Assertions.assertEquals("akciğer tomogrofisi",treatment.getTests());
    }

    @Test
    void testTreatmentDiagnosis(){
        Assertions.assertEquals("soğuk algınlığı",treatment.getDiagnosis());
    }

    @Test
    void testTreatmentPrescriptions(){
        Assertions.assertEquals("antibiyotik",treatment.getPrescriptions());
    }

    @Test
    void testTreatmentDoctorPolyclinicName(){
        Assertions.assertEquals("KBB",treatment.getDoctor().getPolyclinic().getName());
    }
    @Test
    void testTreatmentPatientName(){
        Assertions.assertEquals("ramazan",treatment.getPatient().getName());
    }

    @Test
    void testTreatmentPatientBlood(){
        Assertions.assertEquals("AB+",treatment.getPatient().getBlood());
    }

}
