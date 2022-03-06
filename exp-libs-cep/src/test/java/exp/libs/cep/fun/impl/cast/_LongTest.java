package exp.libs.cep.fun.impl.cast;

import exp.libs.cep.CEPUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _LongTest {

    /**
     * long强制类型转换测试
     * @throws Exception
     */
    @Test
    public void testCastLong() throws Exception {

        //正确性测试
        Object lnum1 = CEPUtils.call(
                _Long.NAME, new Object[] {"-123456789"});
        Assertions.assertTrue(lnum1 instanceof Long);
        System.out.println(lnum1);

        Object lnum2 = CEPUtils.call("long(\"987654321012345678\")");
        Assertions.assertTrue(lnum2 instanceof Long);
        System.out.println(lnum2);

        //错误测试
        Object rst = CEPUtils.call("long(\"9876543210123456789\")");	//数值溢出
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);

        rst = CEPUtils.call("long(\"1L\")");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);

        rst = CEPUtils.call("long()");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);
    }

}