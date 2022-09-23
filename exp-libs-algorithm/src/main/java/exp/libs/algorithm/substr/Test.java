package exp.libs.algorithm.substr;


import java.util.Random;

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
            index = str.indexOf(pattern);
        }
        return index;
    }

    /**
     * 随机生成字符串
     *
     * @param length 表示生成字符串的长度
     * @return String
     */
    public static String generateString(int length) {
        String baseString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder result = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(baseString.charAt(random.nextInt(baseString.length())));
        }

        return result.toString();
    }

    public static void main2(String[] args) {
        // 主串
//        String originString = generateString(10);
        String originString = "HERE IS A SIMPLE EXAMPLE";
        // 模式串
//        String moduleString = generateString(4);
        String moduleString = "EXAMPLE";
        // 坏字符规则表
//        int[] badCharacterArray = badCharacter(originString,moduleString);

        System.out.println("主串：" + originString);
        System.out.println("模式串：" + moduleString);


//        int index = match(originString, moduleString);
//        System.out.println("匹配的下标：" + index);
    }


    public static void main(String[] args) {
        String str = "s蚊dfasghgdfdfft中fasfadherg";
        String ptn = "中fasfad";
        System.out.println(Test.substrIndex(str, ptn, SubStrAlgorithm.BM));
    }



}
