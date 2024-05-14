import com.derman.model.Account;
import com.derman.model.Doctor;
import com.derman.model.Polyclinic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account theAccount;

    @BeforeEach
    void beforeEachTest(){
        theAccount = new Account(76,"bhekim","alican","karaca","05551233445","deneme","bashekim");
    }

    @Test
    void testAccountId(){
        Assertions.assertEquals(76,theAccount.getId());
    }

    @Test
    void testAccountName(){
        Assertions.assertEquals("alican",theAccount.getName());
    }

    @Test
    void testAccountSurname(){
        Assertions.assertEquals("karaca",theAccount.getSurname());
    }

    @Test
    void testAccountUsername(){
        Assertions.assertEquals("bhekim",theAccount.getUsername());
    }

    @Test
    void testAccountPhone(){
        Assertions.assertEquals("05551233445",theAccount.getPhone());
    }

    @Test
    void testAccountPassword(){
        Assertions.assertEquals("deneme",theAccount.getPassword());
    }

    @Test
    void testAccountRole(){
        Assertions.assertEquals("bashekim",theAccount.getRole());
    }
}
