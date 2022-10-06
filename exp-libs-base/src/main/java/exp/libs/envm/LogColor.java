package exp.libs.envm;

import exp.libs.utils.str.StrUtils;

/**
 * <PRE>
 * 枚举类：日志颜色
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-10-02
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public enum LogColor {

    /* 默认（灰色） */
    DEFAULT(39),

    /* 灰色 */
    GREY(39),

    /* 黑色 */
    BLACK(30),

    /* 红色 */
    RED(31),

    /* 绿色 */
    GREEN(32),

    /* 黄色 */
    YELLOW(33),

    /* 蓝色 */
    BLUE(34),

    /* 粉色 */
    MAGENTA(35),

    /* 青色 */
    CYAN(36),

    /* 白色 */
    WHITE(37),

    ;

    private String prefix;

    private String suffix;

    private int code;

    private LogColor(int code) {
        this.prefix = StrUtils.concat("\033[", code, "m");
        this.suffix = "\033[0m";
        this.code = code;
    }

    public String PREFIX() {
        return prefix;
    }

    public String SUFFIX() {
        return suffix;
    }

    public int CODE() {
        return code;
    }
}
