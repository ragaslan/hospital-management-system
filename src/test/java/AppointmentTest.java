
import com.derman.model.Appointment;
import com.derman.model.Doctor;
import com.derman.model.Patient;
import com.derman.model.Polyclinic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
    private Appointment appointment;

    @BeforeEach
    void beforeEachTest(){
        Polyclinic polyclinic = new Polyclinic(10,"KBB");
        Doctor theDoctor = new Doctor(12,"doctor1","ahmet","can","05551233445","123456","doktor",polyclinic);
        Patient thePatient = new Patient(44,"24913312234","ramazan","agaslan","05510231145","Gaziantep şehitkamil","AB+","yok","yok","sgk");
        appointment = new Appointment(15,theDoctor,thePatient,polyclinic,6,25,12,0);
    }


    @Test
    void testAppointmentId(){
        Assertions.assertEquals(15,appointment.getId());
    }
    @Test
    void testAppointmentMonth(){
        Assertions.assertEquals(6,appointment.getMonth());
    }

    @Test
    void testAppointmentDay(){
        Assertions.assertEquals(25,appointment.getDay());
    }

    @Test
    void testAppointmentHour(){
        Assertions.assertEquals(12,appointment.getHour());
    }

    @Test
    void testAppointmentMinute(){
        Assertions.assertEquals(6,appointment.getMonth());
    }

    @Test
    void testAppointmentDoctorName(){
        Assertions.assertEquals("ahmet",appointment.getDoctor().getName());
    }

    @Test
    void testAppointmentPatientName(){
        Assertions.assertEquals("ramazan",appointment.getPatient().getName());
    }

    @Test
    void testAppointmentPolyclinicName(){
        Assertions.assertEquals("KBB",appointment.getPolyclinic().getName());
    }

}
