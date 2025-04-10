package mock;

import com.alibaba.fastjson2.JSON;
import com.zero.learns.benchmark.seris.ElevenPropertiesValue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.creation.MockSettingsImpl;
import org.mockito.internal.stubbing.defaultanswers.ReturnsMocks;

/**
 * com.zero.learns.ValueMock
 *
 * @author ylxb2
 * @since 2024/1/18 15:49
 */

public class ValueMockTest {

    private ElevenPropertiesValue elevenPropertiesValue;


    @Test
    public void mockValue() {
        elevenPropertiesValue = Mockito.mock(ElevenPropertiesValue.class, new MockSettingsImpl<>().defaultAnswer(new ReturnsMocks()));
        System.out.println(JSON.toJSONString(elevenPropertiesValue));
    }
}
