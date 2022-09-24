package exp.libs.algorithm.substr;

import exp.libs.utils.str.StrUtils;

/**
 * <PRE>
 * 字符串匹配算法对象
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
abstract class _SubStr {

    protected SubStrAlgorithm algorithm;

    protected _SubStr(SubStrAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public int indexOf(String str, String pattern) {
        int index = -1;
        if (StrUtils.isNotEmpty(str, pattern)) {
            index = _indexOf(str, pattern);
        }
        return index;
    }

    abstract protected int _indexOf(String str, String pattern);

}
