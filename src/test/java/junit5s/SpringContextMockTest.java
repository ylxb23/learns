package junit5s;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.AService;
import spring.App;

/**
 * junit5s.AServiceTest
 *
 * @author ylxb2
 * @since 2024/3/1 17:22
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = App.class)
public class SpringContextMockTest {

    @Autowired
    private AService aService;

    @Test
    public void getNameTest() {
        String name = aService.getName();
        Assertions.assertEquals("This is name", name);
    }
}
