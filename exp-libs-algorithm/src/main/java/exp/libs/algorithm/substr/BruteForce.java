package exp.libs.algorithm.substr;

/**
 * <PRE>
 * 字符串模式匹配：暴力匹配 （java 默认）
 * 时间复杂度： O(m*n)
 * ---------------------------------------------
 * 但是实际上在 java 暴力是最快的，
 * 因为其他算法都需要 memory copy 过程去空间换时间，但是 java 的空间是比较昂贵的，
 * 导致某些场景下耗时远超算法本身，
 * 暴力因为不需要开辟新空间，反而是最快的。
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
