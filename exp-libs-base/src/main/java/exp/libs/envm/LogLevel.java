package exp.libs.envm;

import exp.libs.utils.str.StrUtils;

/**
 * <PRE>
 * 枚举类：日志等级
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-10-02
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public enum LogLevel {

    /* 默认 */
    DEFAULT("", 0),

    DEBUG("[DEBUG] ", 1),

    INFO("[INFO] ", 2),

    WARN("[WARN] ", 3),

    ERROR("[ERROR] ", 4),

    ;

    private String desc;

    private int code;

    private LogLevel(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public String DESC() {
        return desc;
    }

    public int CODE() {
        return code;
    }
}
