package exp.libs.cep.fun.impl.cast;

import exp.libs.cep.CEPUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _StringTest {

    /**
     * toString测试
     * @throws Exception
     */
    @Test
    public void testCastString() throws Exception {

        //正确性测试
        Object rst = CEPUtils.call(
                _String.NAME, new Object[] {"-123456789"});
        Assertions.assertEquals("-123456789", rst);

        rst = CEPUtils.call("str(\"987654321012345678\")");
        Assertions.assertEquals("987654321012345678", rst);

        rst = CEPUtils.call("str(\"abc\")");
        Assertions.assertEquals("abc", rst);

        rst = CEPUtils.call("str(\"\")");
        Assertions.assertEquals("", rst);

        rst = CEPUtils.call("str(\"null\")");
        Assertions.assertEquals("null", rst);

        rst = CEPUtils.call("str(\"abc123!@#\")");
        Assertions.assertEquals("abc123!@#", rst);

        rst = CEPUtils.call("str(\"    \")");
        Assertions.assertEquals("    ", rst);

        //错误测试
        rst = CEPUtils.call("str()");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);

        rst = CEPUtils.call("str(\" \r\n \t \0   \")");	//参数不能有换行
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);
    }
}