package exp.libs.utils.other;

import org.junit.jupiter.api.AfterEach;
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
        fail("Not yet implemented");
    }

    @Test
    public void testRandomIntInt() {
        fail("Not yet implemented");
    }

    @Test
    public void testRandomIntIntInt() {
        fail("Not yet implemented");
    }

    @Test
    public void testRandomLong() {
        fail("Not yet implemented");
    }

    @Test
    public void testRandomDouble() {
        fail("Not yet implemented");
    }

    @Test
    public void testRandomFloat() {
        fail("Not yet implemented");
    }

    @Test
    public void testRandomBoolean() {
        fail("Not yet implemented");
    }

    @Test
    public void testRandomGaussian() {
        fail("Not yet implemented");
    }

    @Test
    public void testRandomSpellName() {
        fail("Not yet implemented");
    }

    @Test
    public void testRandomKanjiName() {
        fail("Not yet implemented");
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