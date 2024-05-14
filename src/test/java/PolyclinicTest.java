import com.derman.model.Doctor;
import com.derman.model.Polyclinic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PolyclinicTest {

    private Polyclinic thePolyclinic;

    @BeforeEach
    void beforeEachTest(){
        thePolyclinic = new Polyclinic(10,"Göz Hastalıkları");
    }

    @Test
    void testPolyclinicId(){
        Assertions.assertEquals(10,thePolyclinic.getId());
    }

    @Test
    void testPolyclinicName(){
        Assertions.assertEquals("Göz Hastalıkları",thePolyclinic.getName());
    }


}
