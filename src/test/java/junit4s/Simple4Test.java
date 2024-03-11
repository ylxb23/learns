package junit4s;

import algs.MathOpr;
import org.junit.Assert;
import org.junit.Test;

/**
 * junit4s.SimpleTest
 *
 * @author ylxb2
 * @since 2024/2/29 14:57
 */
public class Simple4Test {

    @Test
    public void sumTest() {
        int sum = MathOpr.sum(10, 100);
        Assert.assertEquals("sum should be 110", 110, sum);
    }

}
