package exp.libs.algorithm.substr;


/**
 * @author exp
 * @date 2022-09-21 0:24
 */
public class Test {


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
        return substrIndex(str, pattern, exp.libs.algorithm.substr.SubStrAlgorithm.DEFAULT);
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
    public static int substrIndex(String str, String pattern, exp.libs.algorithm.substr.SubStrAlgorithm algorithm) {
        int index = -1;
        if (algorithm == exp.libs.algorithm.substr.SubStrAlgorithm.KMP) {
            index = exp.libs.algorithm.substr.KMP.getInstn().indexOf(str, pattern);

        } else if (algorithm == exp.libs.algorithm.substr.SubStrAlgorithm.SUNDAY) {
//            index = indexOfSunday(str, ptn);

        } else if (algorithm == exp.libs.algorithm.substr.SubStrAlgorithm.BM) {
//            index = indexOfBM(str, ptn);

        } else {
            index = str.indexOf(pattern);
        }
        return index;
    }


    // https://blog.csdn.net/appleprince88/article/details/11881323
    private static int indexOfBM(String str, Pattern pattern) {
        int index = -1;

        // 计算 pattern 每个字符在模式串最后出现的位置索引
        return index;
    }


    // https://cloud.tencent.com/developer/article/1491859
    private static int indexOfSunday(String str, Pattern pattern) {
        int index = -1;

        // 计算 pattern 每个字符在模式串最后出现的位置索引
        return index;
    }


    public static void main(String[] args) {
        String str = "sadfasdfdfdft中fasfadherg";
        String ptn = "中fasfad";
        System.out.println(Test.substrIndex(str, ptn, SubStrAlgorithm.KMP));
    }

}
