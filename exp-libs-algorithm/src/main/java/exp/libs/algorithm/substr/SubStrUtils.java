package exp.libs.algorithm.substr;


/**
 * <PRE>
 * 字符串匹配
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" str="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class SubStrUtils {

    /**
     * <pre>
     * 在主串 str 中检索 模式串 pattern 第一次出现的位置索引。
     * （需要 exp-libs-algorithm 包支持）
     * </pre>
     * @param str 主串
     * @param pattern 模式串（子串）
     * @return 存在模式串则范围其首字符在主串中的下标; 不存在则返回 -1
     */
    public static int substrIndex(String str, String pattern) {
        return substrIndex(str, pattern, SubStrAlgorithm.DEFAULT);
    }

    /**
     * <pre>
     * 在主串 str 中检索 模式串 pattern 第一次出现的位置索引。
     * （需要 exp-libs-algorithm 包支持）
     * </pre>
     * @param str 主串
     * @param pattern 模式串（子串）
     * @param algorithm 检索算法： 暴力检索（java 默认）、 KMP、 BM(Boyer-Moore)、 Sunday
     * @return 存在模式串则范围其首字符在主串中的下标; 不存在则返回 -1
     */
    public static int substrIndex(String str, String pattern, SubStrAlgorithm algorithm) {
        int index = -1;
        if (algorithm == SubStrAlgorithm.KMP) {
            index = KMP.getInstn().indexOf(str, pattern);

        } else if (algorithm == SubStrAlgorithm.SUNDAY) {
            index = Sunday.getInstn().indexOf(str, pattern);

        } else if (algorithm == SubStrAlgorithm.BM) {
            index = BM.getInstn().indexOf(str, pattern);

        } else {
            index = BruteForce.getInstn().indexOf(str, pattern);
        }
        return index;
    }

}
