package exp.libs.algorithm.substr;

/**
 * <PRE>
 * 字符串模式匹配：暴力匹配 （java 默认）
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class BruteForce extends _SubStr {

    private static volatile BruteForce instance;

    public BruteForce() {
        super(SubStrAlgorithm.DEFAULT);
    }

    public static BruteForce getInstn() {
        if(instance == null) {
            synchronized (BruteForce.class) {
                if(instance == null) {
                    instance = new BruteForce();
                }
            }
        }
        return instance;
    }

    @Override
    protected int _indexOf(String str, String pattern) {
        return str.indexOf(pattern);
    }

}
