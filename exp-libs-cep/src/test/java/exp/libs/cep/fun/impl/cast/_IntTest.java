package exp.libs.cep.fun.impl.cast;

import exp.libs.cep.CEPUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _IntTest {

    /**
     * int强制类型转换测试
     * @throws Exception
     */
    @Test
    public void testCastInt() throws Exception {

        //正确性测试
        Object inum1 = CEPUtils.call(
                _Int.NAME, new Object[] {"-123"});
        Assertions.assertTrue(inum1 instanceof Integer);
        System.out.println(inum1);

        Object inum2 = CEPUtils.call("int(\"987\")");
        Assertions.assertTrue(inum2 instanceof Integer);
        System.out.println(inum2);

        //错误测试
        Object rst = CEPUtils.call("int(\"abc\")");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);

        rst = CEPUtils.call("int()");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);
    }

}