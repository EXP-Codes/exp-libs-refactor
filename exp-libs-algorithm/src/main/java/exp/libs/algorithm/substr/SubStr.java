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
        algorithm = (algorithm == null ? SubStrAlgorithm.DEFAULT : algorithm);
        if (!StrUtils.isNotEmpty(str, pattern)) {
            index = -1;

        } else if (algorithm == SubStrAlgorithm.KMP) {
            index = indexOfKMP(str, pattern);

        } else if (algorithm == SubStrAlgorithm.SUNDAY) {
            index = indexOfSunday(str, pattern);

        } else {
            index = str.indexOf(pattern);
        }
        return index;
    }


    private static int indexOfKMP(String str, String pattern) {
        int index = -1;
        int[] nextArray = toNextArray(pattern);
        int tar = 0;
        int pos = 0;
        while (tar < str.length()) {
            if (str.charAt(tar) == pattern.charAt(pos)) {
                tar++;
                pos++;

            } else if (pos != 0) {
                pos = nextArray[pos - 1];

            } else {
                tar++;
            }

            if (pos == pattern.length()) {
                pos = nextArray[pos - 1];
            }
        }
        return index;
    }

    private static int[] toNextArray(String pattern) {
        int[] nextArray = new int[pattern.length()];
        int i = 1;
        int now = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(now)) {
                now++;
                nextArray[i] = now;
                i++;

            } else if (now != 0) {
                now = nextArray[now - 1];

            } else {
                i++;
                nextArray[i] = now;
            }
        }
        return nextArray;
    }



    private static int indexOfSunday(String str, String pattern) {
        int index = -1;

        // 计算 pattern 每个字符在模式串最后出现的位置索引
        return index;
    }

    public static void main(String[] args) {
        String str = "sadfasdftherg";
        String ptn = "fas";
        System.out.println(SubStr.indexOf(str, ptn, SubStrAlgorithm.KMP));
    }

}
