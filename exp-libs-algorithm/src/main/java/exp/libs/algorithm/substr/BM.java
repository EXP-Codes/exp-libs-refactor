package exp.libs.algorithm.substr;


/**
 * <PRE>
 * 字符串模式匹配：BM （Boyer-Moore）
 * 时间复杂度： O(m/n)
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" str="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class BM extends _SubStr {

    private static volatile BM instance;

    public BM() {
        super(SubStrAlgorithm.BM);
    }

    public static BM getInstn() {
        if(instance == null) {
            synchronized (BM.class) {
                if(instance == null) {
                    instance = new BM();
                }
            }
        }
        return instance;
    }

    @Override
    protected int _indexOf(String str, String pattern) {
        int index = -1;

        BMPattern ptn = new BMPattern(pattern);
        int pLen = ptn.length();
        int sLen = str.length();
        if (pLen > sLen) {
            index = -1;

        } else {
            for (int i = pLen - 1, j; i < sLen;) {
                for (j = pLen - 1; str.charAt(i) == ptn.charAt(j); i--, j--) {
                    if (j == 0) {
                        index = i;
                        break;
                    }
                }
                if (index > 0) {
                    break;
                }

                i += Math.max(
                        ptn.goodAt(pLen - j - 1),
                        ptn.badAt(str.charAt(i))
                );
            }
        }
        return index;
    }

}
