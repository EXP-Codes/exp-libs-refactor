package exp.libs.cep.fun.impl.cast;

import exp.libs.cep.CEPUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _DoubleTest {

    /**
     * Double强制类型转换测试
     * @throws Exception
     */
    @Test
    public void testCastDouble() throws Exception {

        //正确性测试
        Object dnum1 = CEPUtils.call(
                _Double.NAME, new Object[] {"-123456789"});
        Assertions.assertTrue(dnum1 instanceof Double);
        System.out.println(dnum1);

        Object dnum2 = CEPUtils.call("double(\"9876543210123456789\")");
        Assertions.assertTrue(dnum2 instanceof Double);
        System.out.println(dnum2);

        Object rst = CEPUtils.call("double(\"1D\")");
        Assertions.assertEquals(1.0, rst);

        //错误测试
        rst = CEPUtils.call("double()");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);
    }
    
}