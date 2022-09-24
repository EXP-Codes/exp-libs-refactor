package exp.libs.algorithm.substr;

/**
 * <PRE>
 * 枚举类：字符串匹配算法
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" str="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public enum SubStrAlgorithm {

    /* 暴力搜索 */
    DEFAULT("Brute-Force"),

    /* KMP 算法 */
    KMP("KMP"),

    /* BM 算法 */
    BM("Boyer-Moore"),

    /* Sunday 算法 */
    SUNDAY("Sunday"),

    ;

    private String type;

    private SubStrAlgorithm(String type) {
        this.type = type;
    }

    public String TYPE() {
        return type;
    }

}
