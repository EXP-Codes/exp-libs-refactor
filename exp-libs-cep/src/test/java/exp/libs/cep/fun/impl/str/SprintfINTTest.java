package exp.libs.cep.fun.impl.str;

import exp.libs.cep.CEPUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SprintfINTTest {

    @Test
    public void testEval() throws Exception {
        Object re = null;
        re = CEPUtils.call("sprintf(\"%2d\", 2)");
        Assertions.assertEquals(" 2", re.toString());
        System.out.println(re);

        // 不允许非整型入参
        re = CEPUtils.call("sprintf(\"%2f\", 0.22)");
        Assertions.assertEquals(CEPUtils.ERROR_RESULT, re);
    }

}