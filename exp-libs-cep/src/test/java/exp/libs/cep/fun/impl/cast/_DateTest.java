package exp.libs.cep.fun.impl.cast;

import exp.libs.cep.CEPUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class _DateTest {

    /**
     * FIXME
     * Date强制类型转换测试
     * @throws Exception
     */
    @Test
    public void testCastDate() throws Exception {

        //正确性测试
        Object date1 = CEPUtils.call(
                _Date.NAME, new Object[] {"2014-09-30 14:05:16"});
        Assertions.assertTrue(date1 instanceof Date);
        System.out.println(date1);

        Object date2 = CEPUtils.call(
                "date(\"2014-09-30 14:05:16\", \"yyyy-MM-dd HH:mm:ss\")");
        Assertions.assertTrue(date2 instanceof Date);
        System.out.println(date2);

        //错误测试
        Object rst = CEPUtils.call("date(\"2014,09,30 14,05,16\")");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);

        rst = CEPUtils.call("date()");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, rst);
    }
    
}