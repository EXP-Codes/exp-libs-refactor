package exp.libs.algorithm.substr;

/**
 * <PRE>
 * 字符串模式匹配：BM （Boyer-Moore）
 * https://blog.csdn.net/appleprince88/article/details/11881323
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class BoyerMoore extends _SubStr {

    private static volatile BoyerMoore instance;

    public BoyerMoore() {
        super(SubStrAlgorithm.BM);
    }

    public static BoyerMoore getInstn() {
        if(instance == null) {
            synchronized (BoyerMoore.class) {
                if(instance == null) {
                    instance = new BoyerMoore();
                }
            }
        }
        return instance;
    }

    @Override
    protected int _indexOf(String str, String pattern) {
        return 0;
    }
}
