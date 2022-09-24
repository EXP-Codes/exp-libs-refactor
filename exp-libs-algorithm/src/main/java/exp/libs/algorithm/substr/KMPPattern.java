package exp.libs.algorithm.substr;

/**
 * <PRE>
 * KMP 模式串对象
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" str="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class KMPPattern extends _Pattern {

    private int[] next;

    protected KMPPattern(String pattern) {
        super(pattern);
    }

    @Override
    protected void init() {
        this.next = new int[this.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < length - 1) {
            if (k == -1 || charAt(j) == charAt(k)) {
                if (charAt(++j) == charAt(++k)) {       // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
    }

    protected int nextAt(int index) {
        return this.next[index];
    }

}
