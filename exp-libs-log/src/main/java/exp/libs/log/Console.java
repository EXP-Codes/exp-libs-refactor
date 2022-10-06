package exp.libs.log;

import exp.libs.envm.LogColor;
import exp.libs.envm.LogLevel;

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

    /**
     * 打印通常日志（青色）
     * @param message 日志内容
     */
    public static void out(String message) {
        out(LogColor.CYAN, message, null);
    }

    /**
     * 打印通常日志（青色）
     * @param format 日志内容格式
     * @param arguments 日志内容参数（最末位支持传入异常对象）
     */
    public static void out(String format, Object... arguments) {
        out(LogColor.CYAN, format, arguments);
    }

    /**
     * 打印通常日志
     * @param color 日志颜色
     * @param message 日志内容
     */
    public static void out(LogColor color, String message) {
        out(color, message, null);
    }

    /**
     * 打印通常日志
     * @param color 日志颜色
     * @param format 日志内容格式
     * @param arguments 日志内容参数（最末位支持传入异常对象）
     */
    public static void out(LogColor color, String format, Object... arguments) {
        String message = LogUtils.replacePlaceholder(format, arguments);
        String colorMsg = LogUtils.comboMessage(LogLevel.INFO, color, message);
        Throwable t = LogUtils.takeException(arguments);

        System.out.println(colorMsg);
        if (t != null) {
            t.printStackTrace(System.out);
        }
    }

    /**
     * 打印异常日志（红色）
     * @param message 日志内容
     */
    public static void err(String message) {
        err(LogColor.RED, message, null);
    }

    /**
     * 打印异常日志（红色）
     * @param format 日志内容格式
     * @param arguments 日志内容参数（最末位支持传入异常对象）
     */
    public static void err(String format, Object... arguments) {
        err(LogColor.RED, format, arguments);
    }

    /**
     * 打印异常日志
     * @param color 日志颜色
     * @param message 日志内容
     */
    public static void err(LogColor color, String message) {
        err(color, message, null);
    }

    /**
     * 打印异常日志
     * @param color 日志颜色
     * @param format 日志内容格式
     * @param arguments 日志内容参数（最末位支持传入异常对象）
     */
    public static void err(LogColor color, String format, Object... arguments) {
        String message = LogUtils.replacePlaceholder(format, arguments);
        String colorMsg = LogUtils.comboMessage(LogLevel.ERROR, color, message);
        Throwable t = LogUtils.takeException(arguments);

        System.err.println(colorMsg);
        if (t != null) {
            t.printStackTrace(System.err);
        }
    }

}
