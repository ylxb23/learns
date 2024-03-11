package junit5s;

import algs.MathOpr;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * junit5s.Simple5Test
 *
 * @author ylxb2
 * @since 2024/2/29 17:17
 */
public class Simple5Test {


    @Test
    public void sumTest() {
        int sum = MathOpr.sum(10, 100);
        Assertions.assertEquals(110, sum);
    }
}
