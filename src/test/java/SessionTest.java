import com.derman.model.Doctor;
import com.derman.model.Polyclinic;
import com.derman.model.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SessionTest {
    private Session theSession;


    @BeforeEach
    void beforeEachTest(){
        theSession = new Session(13,30);
    }

    @Test
    void testSessionHour(){
        Assertions.assertEquals(13,theSession.getHour());
    }

    @Test
    void testSessionMinute(){
        Assertions.assertEquals(30,theSession.getMinute());
    }


}
