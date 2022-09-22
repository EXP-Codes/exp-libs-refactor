package exp.libs.algorithm.substr;

/**
 * <PRE>
 * 字符串模式匹配：Sunday
 * https://cloud.tencent.com/developer/article/1491859
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
        return 0;
    }
}
