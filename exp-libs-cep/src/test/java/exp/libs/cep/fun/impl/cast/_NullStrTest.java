package exp.libs.cep.fun.impl.cast;

import exp.libs.cep.CEPUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class _NullStrTest {

    /**
     * 空串强制类型转换测试
     * @throws Exception
     */
    @Test
    public void testCastNullStr() throws Exception {

        //正确性测试
        Object rst = CEPUtils.call(
                _NullStr.NAME, new Object[] {"-123456789"});
        Assertions.assertEquals("", rst);

        rst = CEPUtils.call("nullstr(\"987654321012345678\")");
        Assertions.assertEquals("", rst);

        rst = CEPUtils.call("nullstr(\"abc\")");
        Assertions.assertEquals("", rst);

        rst = CEPUtils.call("nullstr(\"\")");
        Assertions.assertEquals("", rst);

        rst = CEPUtils.call("nullstr(\"null\")");
        Assertions.assertEquals("", rst);

        rst = CEPUtils.call("nullstr(\"abc123!@#\")");
        Assertions.assertEquals("", rst);

        rst = CEPUtils.call("nullstr(\"    \")");
        Assertions.assertEquals("", rst);

        Date now = new Date();
        CEPUtils.declare("now", now);
        rst = CEPUtils.call("nullstr($now$)");
        Assertions.assertEquals("", rst);

        //错误测试
        rst = CEPUtils.call("nullstr()");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);

        rst = CEPUtils.call("nullstr(\" \r\n \t \0   \")");	//参数不能有换行
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);
    }
    
}