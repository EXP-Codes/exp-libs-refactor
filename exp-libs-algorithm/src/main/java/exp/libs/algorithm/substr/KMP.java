package exp.libs.algorithm.substr;

/**
 * <PRE>
 * 字符串模式匹配：KMP
 * https://www.cnblogs.com/dusf/p/kmp.html?share_token=c86cd6c3-f95b-46d2-83be-96e64cc7f81b
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class KMP extends _SubStr {

    private static volatile KMP instance;

    public KMP() {
        super(SubStrAlgorithm.KMP);
    }

    public static KMP getInstn() {
        if(instance == null) {
            synchronized (KMP.class) {
                if(instance == null) {
                    instance = new KMP();
                }
            }
        }
        return instance;
    }

    @Override
    protected int _indexOf(String str, String pattern) {
        KMPPattern ptn = new KMPPattern(pattern);

        int ps = 0;  // 主串的指针
        int pp = 0;  // 模式串的指针
        while (ps < str.length() && pp < ptn.length()) {

            // 当 pp 为 -1 时，移动 ps，且 pp 也要归 0
            if (pp == -1 || str.charAt(ps) == ptn.charAt(pp)) {
                ps++;
                pp++;

                // pp 回到指定位置
            } else {
                pp = ptn.nextAt(pp);
            }
        }
        return (pp == ptn.length() ? (ps - pp) : -1);
    }
}
