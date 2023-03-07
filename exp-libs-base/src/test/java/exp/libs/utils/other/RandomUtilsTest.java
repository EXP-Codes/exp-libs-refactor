package exp.libs.utils.other;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilsTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testRandomInt() {
        int scope = -1;
        int num = RandomUtils.genInt(scope);
        Assertions.assertEquals(0, num);

        scope = 0;
        num = RandomUtils.genInt(scope);
        Assertions.assertEquals(0, num);

        scope = 1;
        num = RandomUtils.genInt(scope);
        Assertions.assertTrue(num <= scope);

        scope = 10;
        num = RandomUtils.genInt(scope);
        Assertions.assertTrue(num <= scope);
    }

    @Test
    public void testRandomIntInt() {
        int min = 0;
        int max = 0;
        int num = RandomUtils.genInt(min, max);
        Assertions.assertEquals(0, num);

        min = -1;
        max = -1;
        num = RandomUtils.genInt(min, max);
        Assertions.assertEquals(0, num);

        min = 9;
        max = 2;
        num = RandomUtils.genInt(min, max);
        Assertions.assertEquals(min, num);

        min = -1;
        max = 10;
        num = RandomUtils.genInt(min, max);
        Assertions.assertTrue(num >= 0);
        Assertions.assertTrue(num <= 10);

        min = 5;
        max = 10;
        num = RandomUtils.genInt(min, max);
        Assertions.assertTrue(num >= 5);
        Assertions.assertTrue(num <= 10);
    }

    @Test
    public void testRandomIntIntInt() {
        // fail("Not yet implemented");
    }

    @Test
    public void testRandomLong() {
        // fail("Not yet implemented");
    }

    @Test
    public void testRandomDouble() {
        // fail("Not yet implemented");
    }

    @Test
    public void testRandomFloat() {
        // fail("Not yet implemented");
    }

    @Test
    public void testRandomBoolean() {
        // fail("Not yet implemented");
    }

    @Test
    public void testRandomGaussian() {
        // fail("Not yet implemented");
    }

    @Test
    public void testRandomSpellName() {
        // fail("Not yet implemented");
    }

    @Test
    public void testRandomKanjiName() {
        // fail("Not yet implemented");
    }

    @Test
    public void testRandomChineseName() {
        for(int i = 0; i < 100; i++) {
            String[] name = RandomUtils.genChineseName();
            System.out.println(name[0]);
            System.out.println(name[1]);
        }
    }

}