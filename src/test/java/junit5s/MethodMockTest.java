package junit5s;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.AService;

/**
 * junit5s.MethodMockTest
 *
 * @author ylxb2
 * @since 2024/3/3 11:59
 */
@ExtendWith(MockitoExtension.class)
public class MethodMockTest {

    @Mock
    private AService aService;

    @Test
    public void getNameMockTest() {
        String mockedName = "mocked";
        Mockito.when(aService.getName()).thenReturn(mockedName);

        String name = aService.getName();
        Assertions.assertEquals(mockedName, name);
    }
}
