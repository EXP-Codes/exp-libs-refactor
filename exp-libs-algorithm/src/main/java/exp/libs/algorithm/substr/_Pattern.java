package exp.libs.algorithm.substr;

/**
 * <PRE>
 * 模式字符串对象
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
abstract class _Pattern {

    protected String pattern;

    protected int length;

    protected _Pattern(String pattern) {
        this.pattern = (pattern == null ? "" : pattern);
        this.length = this.pattern.length();
        init();
    }

    abstract protected void init();

    protected char charAt(int index) {
        return this.pattern.charAt(index);
    }

    protected int length() {
        return this.length;
    }

}
