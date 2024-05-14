import com.derman.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PatientTest {

    private Patient thePatient;

    @BeforeEach
    void beforeEachTest(){
        thePatient = new Patient(56,"24432515694","ali","can","05533251234","İstanbul Şişli","0+","yok","yok","sgk");
    }

    @Test
    void testPatientTc(){
        Assertions.assertEquals("24432515694",thePatient.getTc());
    }

    @Test
    void testPatientName() {
        Assertions.assertEquals("ali",thePatient.getName());
    }

    @Test
    void testPatientSurname(){
        Assertions.assertEquals("can",thePatient.getSurname());
    }

    @Test
    void testPatientPhone(){
        Assertions.assertEquals("05533251234",thePatient.getPhone());
    }

    @Test
    void testPatientAddress(){
        Assertions.assertEquals("İstanbul Şişli",thePatient.getAddress());
    }

    @Test
    void testPatientBlood(){
        Assertions.assertEquals("0+",thePatient.getBlood());
    }

    @Test
    void testPatientAlergies(){
        Assertions.assertEquals("yok",thePatient.getAlergies());
    }

    @Test
    void testPatientDiseases(){
        Assertions.assertEquals("yok",thePatient.getDiseases());
    }

    @Test
    void testPatientInsurance(){
        Assertions.assertEquals("sgk",thePatient.getInsurance());
    }

}
