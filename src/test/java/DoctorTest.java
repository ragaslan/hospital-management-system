import com.derman.model.Doctor;
import com.derman.model.Polyclinic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoctorTest {

    private Doctor doctor;

    @BeforeEach
    void beforeEachTest(){
        Polyclinic polyclinic = new Polyclinic(10,"Göz Hastalıkları");
        doctor = new Doctor(12,"doctor1","ahmet","can","05551233445","123456","doktor",polyclinic);
    }

    @Test
    void testDoctorId(){
        Assertions.assertEquals(12,doctor.getId());
    }

    @Test
    void testDoctorName(){
        Assertions.assertEquals("ahmet",doctor.getName());
    }

    @Test
    void testDoctorSurname(){
        Assertions.assertEquals("can",doctor.getSurname());
    }

    @Test
    void testDoctorUsername(){
        Assertions.assertEquals("doctor1",doctor.getUsername());
    }

    @Test
    void testDoctorPhone(){
        Assertions.assertEquals("05551233445",doctor.getPhone());
    }

    @Test
    void testDoctorPassword(){
        Assertions.assertEquals("123456",doctor.getPassword());
    }

    @Test
    void testDoctorRole(){
        Assertions.assertEquals("doktor",doctor.getRole());
    }

    @Test
    void testDoctorPolyclinicName(){
        Assertions.assertEquals("Göz Hastalıkları",doctor.getPolyclinic().getName());
    }


}
