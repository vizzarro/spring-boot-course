import org.junit.Test;
import org.library.demo.service.PersonServiceImpl;

public class ClientTest {


    @Test
    public void test() throws Exception {

        PersonServiceImpl service = new PersonServiceImpl();

        System.out.println(service.getPerson("").toString());
    }

}
