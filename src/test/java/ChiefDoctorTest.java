import com.derman.model.ChiefDoctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ChiefDoctorTest{

    private ChiefDoctor doctor;

    @BeforeEach
    void beforeEachTest(){
        doctor = new ChiefDoctor(12,"doctor1","ahmet","can","05551233445","123456","bashekim");
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
        Assertions.assertEquals("bashekim",doctor.getRole());
    }
}
