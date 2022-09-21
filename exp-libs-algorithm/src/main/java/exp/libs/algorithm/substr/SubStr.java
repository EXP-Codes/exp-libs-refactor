package exp.libs.algorithm.substr;


import exp.libs.utils.str.StrUtils;

/**
 * @author exp
 * @date 2022-09-21 0:24
 */
public class SubStr {


    public static int indexOf(String str, String pattern) {
        return indexOf(str, pattern, SubStrAlgorithm.DEFAULT);
    }


    public static int indexOf(String str, String pattern, SubStrAlgorithm algorithm) {
        int index = -1;
        Pattern ptn = new Pattern(pattern, algorithm);

        if (!StrUtils.isNotEmpty(str, pattern)) {
            index = -1;

        } else if (algorithm == SubStrAlgorithm.KMP) {
            index = indexOfKMP(str, ptn);

        } else if (algorithm == SubStrAlgorithm.SUNDAY) {
            index = indexOfSunday(str, ptn);

        } else if (algorithm == SubStrAlgorithm.BM) {
            index = indexOfBM(str, ptn);

        } else {
            index = str.indexOf(pattern);
        }
        return index;
    }


    // https://www.cnblogs.com/dusf/p/kmp.html?share_token=c86cd6c3-f95b-46d2-83be-96e64cc7f81b
    private static int indexOfKMP(String str, Pattern pattern) {
        int i = 0;  // 主串的指针
        int j = 0;  // 模式串的指针
        while (i < str.length() && j < pattern.length()) {

            // 当 j 为 -1 时，要移动的是 i，当然 j 也要归 0
            if (j == -1 || str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

            // j 回到指定位置
            } else {
                j = pattern.nextAt(j);
            }
        }
        return (j == pattern.length() ? (i - j) : -1);
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
        System.out.println(SubStr.indexOf(str, ptn, SubStrAlgorithm.KMP));
    }

}
