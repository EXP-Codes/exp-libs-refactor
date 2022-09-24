package exp.libs.algorithm.substr;

import exp.libs.utils.other.RandomUtils;
import exp.libs.utils.str.StrUtils;
import exp.libs.utils.time.QuickTimer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * <PRE>
 * 字符串匹配算法测试
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" str="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class SubStrUtilsTest {

    private QuickTimer qt;

    private static final int STR_LEN = 100000000;

    private String str;

    // include
    private int pattrenBgnIdx;

    // exclude
    private int pattrenEndIdx;

    private String headPattren;

    private String bodyPattren;

    private String tailPattren;

    private String notMatchPattren;

    @BeforeEach
    void setup() {
        this.qt = new QuickTimer();

        System.out.println("正在生成测试用 [主串] ...");
        boolean flop = true;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < STR_LEN; i++) {
            if (flop) {
                sb.append(RandomUtils.genCharacter());
            } else {
                sb.append(RandomUtils.genOneUsedKanji());
            }
            flop = !flop;
        }
        this.str = sb.toString();
        System.out.println(" > 测试用的 [主串] 为: " + StrUtils.showSummary(str));
        System.out.println(" > 长度 [" + STR_LEN + "] ...");

        System.out.println("正在生成测试用 [模式串] ...");
        this.pattrenBgnIdx = RandomUtils.genInt(0, STR_LEN - 1);
        this.pattrenEndIdx = RandomUtils.genInt(pattrenBgnIdx, STR_LEN);
        this.headPattren = str.substring(0, pattrenBgnIdx);
        this.tailPattren = str.substring(pattrenEndIdx);
        this.bodyPattren = str.substring(pattrenBgnIdx, pattrenEndIdx);
        this.notMatchPattren = RandomUtils.genString(10);   // 因为主串是中英文间隔，所以 > 2 的英文模式串即可确保不匹配

        System.out.println("已生成随机 [模式串]: ");
        System.out.println(" > 索引范围为: [" + pattrenBgnIdx + ", " + pattrenEndIdx + ")");
        System.out.println(" > 测试用的 [头部匹配] 模式串为: " + StrUtils.showSummary(headPattren));
        System.out.println(" > 测试用的 [中段匹配] 模式串为: " + StrUtils.showSummary(bodyPattren));
        System.out.println(" > 测试用的 [尾部匹配] 模式串为: " + StrUtils.showSummary(tailPattren));
        System.out.println(" > 测试用的 [不匹配] 模式串为: " + StrUtils.showSummary(notMatchPattren));
        System.out.println("========================");
    }

    @Test
    void substrIndex() {
        testBruteForce();   // 时间复杂度 O(m * n)
        System.out.println("------------------------");
        testKMP();          // 时间复杂度 O(m + n)
        System.out.println("------------------------");
        testBM();           // 时间复杂度 O(m / n)
        System.out.println("------------------------");
        testSunday();       // 时间复杂度 O(m / n)
    }

    private void testBruteForce() {
        System.out.println("正在验证 [暴力匹配(JDK)] 算法，时间复杂度 O(m * n) ...");
        qt.checkpoint();
        int index = SubStrUtils.substrIndex(str, headPattren);
        Assertions.assertEquals(0, index);
        System.out.println(" > 验证 [头部匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, bodyPattren);
        Assertions.assertEquals(pattrenBgnIdx, index);
        System.out.println(" > 验证 [中段匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, tailPattren);
        Assertions.assertEquals(pattrenEndIdx, index);
        System.out.println(" > 验证 [尾部匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, notMatchPattren);
        Assertions.assertEquals(-1, index);
        System.out.println(" > 验证 [不匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex("", "");
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex(null, null);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex("", null);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex(null, "");
        Assertions.assertEquals(-1, index);
        System.out.println(" > 验证 [异常] 成功，耗时: " + qt.checkpoint() + " ms");
    }

    private void testKMP() {
        System.out.println("正在验证 [KMP 匹配] 算法，时间复杂度 O(m + n) ...");
        qt.checkpoint();
        int index = SubStrUtils.substrIndex(str, headPattren, SubStrAlgorithm.KMP);
        Assertions.assertEquals(0, index);
        System.out.println(" > 验证 [头部匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, bodyPattren, SubStrAlgorithm.KMP);
        Assertions.assertEquals(pattrenBgnIdx, index);
        System.out.println(" > 验证 [中段匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, tailPattren, SubStrAlgorithm.KMP);
        Assertions.assertEquals(pattrenEndIdx, index);
        System.out.println(" > 验证 [尾部匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, notMatchPattren, SubStrAlgorithm.KMP);
        Assertions.assertEquals(-1, index);
        System.out.println(" > 验证 [不匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex("", "", SubStrAlgorithm.KMP);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex(null, null, SubStrAlgorithm.KMP);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex("", null, SubStrAlgorithm.KMP);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex(null, "", SubStrAlgorithm.KMP);
        Assertions.assertEquals(-1, index);
        System.out.println(" > 验证 [异常] 成功，耗时: " + qt.checkpoint() + " ms");
    }

    private void testBM() {
        System.out.println("正在验证 [Boyer-Moore 匹配] 算法，时间复杂度 O(m / n) ...");
        qt.checkpoint();
        int index = SubStrUtils.substrIndex(str, headPattren, SubStrAlgorithm.BM);
        Assertions.assertEquals(0, index);
        System.out.println(" > 验证 [头部匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, bodyPattren, SubStrAlgorithm.BM);
        Assertions.assertEquals(pattrenBgnIdx, index);
        System.out.println(" > 验证 [中段匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, tailPattren, SubStrAlgorithm.BM);
        Assertions.assertEquals(pattrenEndIdx, index);
        System.out.println(" > 验证 [尾部匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, notMatchPattren, SubStrAlgorithm.BM);
        Assertions.assertEquals(-1, index);
        System.out.println(" > 验证 [不匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex("", "", SubStrAlgorithm.BM);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex(null, null, SubStrAlgorithm.BM);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex("", null, SubStrAlgorithm.BM);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex(null, "", SubStrAlgorithm.BM);
        Assertions.assertEquals(-1, index);
        System.out.println(" > 验证 [异常] 成功，耗时: " + qt.checkpoint() + " ms");
    }

    private void testSunday() {
        System.out.println("正在验证 [Sunday 匹配] 算法，时间复杂度 O(m / n) ...");
        qt.checkpoint();
        int index = SubStrUtils.substrIndex(str, headPattren, SubStrAlgorithm.SUNDAY);
        Assertions.assertEquals(0, index);
        System.out.println(" > 验证 [头部匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, bodyPattren, SubStrAlgorithm.SUNDAY);
        Assertions.assertEquals(pattrenBgnIdx, index);
        System.out.println(" > 验证 [中段匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, tailPattren, SubStrAlgorithm.SUNDAY);
        Assertions.assertEquals(pattrenEndIdx, index);
        System.out.println(" > 验证 [尾部匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex(str, notMatchPattren, SubStrAlgorithm.SUNDAY);
        Assertions.assertEquals(-1, index);
        System.out.println(" > 验证 [不匹配] 成功，耗时: " + qt.checkpoint() + " ms");

        qt.checkpoint();
        index = SubStrUtils.substrIndex("", "", SubStrAlgorithm.SUNDAY);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex(null, null, SubStrAlgorithm.SUNDAY);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex("", null, SubStrAlgorithm.SUNDAY);
        Assertions.assertEquals(-1, index);
        index = SubStrUtils.substrIndex(null, "", SubStrAlgorithm.SUNDAY);
        Assertions.assertEquals(-1, index);
        System.out.println(" > 验证 [异常] 成功，耗时: " + qt.checkpoint() + " ms");
    }

}