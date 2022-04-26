import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.library.demo.models.UserLibrary;
import org.library.demo.repository.UserDao;
import org.library.demo.repository.UserLibraryRepository;
import org.library.demo.service.UserLibraryService;
import org.library.demo.service.UserLibraryServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

public class UserLibraryTest {


    @Test
    public void test() throws Exception {

        UserLibraryService service = new UserLibraryServiceImpl(new UserLibraryRepository());

        {
            UserLibrary userLibrary = service.getUserLibrary("DLFLCU456");
        if (userLibrary == null) {
            System.out.println("tax code user not found!");
        } else {
            System.out.println(userLibrary.toString());
        }
        }
    }

}
