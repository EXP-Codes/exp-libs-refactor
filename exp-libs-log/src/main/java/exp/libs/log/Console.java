package exp.libs.log;

import exp.libs.envm.LogColor;
import exp.libs.utils.str.StrUtils;

/**
 * <PRE>
 * 控制台日志（支持颜色）
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">www.exp-blog.com</a>
 * @version   2022-10-02
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class Console {

    private Console() {}

    public static void log(String message) {
        log(message, null);
    }

    public static void log(String message, LogColor color) {
        color = (color == null ? LogColor.DEFAULT : color);
        System.out.println(StrUtils.concat(
                color.PREFIX(),
                message,
                color.SUFFIX()
        ));
    }
}
