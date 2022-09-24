package exp.libs.algorithm.substr;

import exp.libs.utils.other.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <PRE>
 * Sunday 模式串对象
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" str="_blank">https://exp-blog.com</a>
 * @version   2022-09-22
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class SundayPattern extends _Pattern {

    private Map<Character, Integer> next;

    private int pLast;

    protected SundayPattern(String pattern) {
        super(pattern);
        this.pLast = length - 1;
    }

    @Override
    protected void init() {
        this.next = new HashMap<>(MapUtils.genSize(length));
    }

    protected int nextAt(char ch) {
        int index = -1;
        Integer val = next.get(ch);

        if (val != null) {
            index = val.intValue();

        // 从后往前检索
        } else {
            for (int i = pLast; i >= 0; i--) {
                char pch = charAt(i);
                next.putIfAbsent(pch, i);   // 把所有字符的最后出现的索引放进 next 表
                pLast = i - 1;              // 更新下次开始检索的起始位置，确保 模式串 最多只会迭代一轮

                if (pch == ch) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

}
