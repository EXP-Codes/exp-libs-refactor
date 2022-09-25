package exp.libs.algorithm.substr;

/**
 * <PRE>
 * 字符串模式匹配：Sunday
 * 时间复杂度： O(m/n)
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Sunday extends _SubStr {

    private static volatile Sunday instance;

    private Sunday() {
        super(SubStrAlgorithm.SUNDAY);
    }

    public static Sunday getInstn() {
        if(instance == null) {
            synchronized (Sunday.class) {
                if(instance == null) {
                    instance = new Sunday();
                }
            }
        }
        return instance;
    }

    @Override
    protected int _indexOf(String str, String pattern) {
        int index = -1;
        SundayPattern ptn = new SundayPattern(pattern);
        int sLen = str.length();
        int pLen = ptn.length();

        int ps = 0;  // 主串的指针
        int pp = 0;  // 模式串的指针

        // 主串 剩余字符少于 模式串 时跳过比较
        while (ps <= sLen - pLen) {

            // 将 模式串 与 主串 中参与比较的子串进行逐个字符比对
            while (pp < pLen && str.charAt(ps + pp) == ptn.charAt(pp)) {
                pp++;
            }

            // 如果 pp 等于 模式串 的长度说明此时匹配成功，可以直接返回此时 主串 的指针
            if (pp == pLen) {
                index = ps;
                break;
            }

            // 不匹配时计算需要跳过的字符数，移动 主串 的指针
            if (ps < sLen - pLen) {

                // 对照字符在 模式串 中存在，则需要跳过的字符数为从对照字符在 模式串 中最后出现的位置起剩余的字符个数
                // 不存在则跳过的字符数为 模式串 长度 + 1，也就是代码 pLen - (-1) 的情况
                char ch = str.charAt(ps + pLen);
                ps += (pLen - ptn.nextAt(ch));

            } else {
                break;
            }
            pp = 0;     // 每次比较之后将 模式串 的指针置 0
        }
        return index;
    }

}
