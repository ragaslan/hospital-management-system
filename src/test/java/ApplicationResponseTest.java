import com.derman.model.Account;
import com.derman.model.ApplicationResponse;
import com.derman.model.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationResponseTest {

    private ApplicationResponse<Account> theResponse;
    private Account theAccount;

    @BeforeEach
    void beforeEachTest(){
        theAccount = new Account(76,"bhekim","alican","karaca","05551233445","deneme","bashekim");
        theResponse = new ApplicationResponse<>(true,"İşlem başarılı",theAccount);
    }

    @Test
    void testApplicationResponseSuccess(){
        Assertions.assertTrue(theResponse.getSuccess());
    }

    @Test
    void testApplicationResponseMessage(){
        Assertions.assertEquals("İşlem başarılı",theResponse.getMessage());
    }

    @Test
    void testApplicationResponseData(){
        Assertions.assertEquals(theAccount,theResponse.getData());
    }

}
