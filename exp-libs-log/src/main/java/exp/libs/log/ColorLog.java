package exp.libs.log;

import exp.libs.envm.LogColor;
import exp.libs.envm.LogLevel;
import exp.libs.utils.str.StrUtils;
import org.slf4j.Logger;

/**
 * <PRE>
 * 颜色日志
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">www.exp-blog.com</a>
 * @version   2022-10-02
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class ColorLog {

    private ColorLog() {}

    /**
     * DEBUG 级别日志
     * @param logger 日志器
     * @param format 日志内容格式
     * @param arguments 日志内容参数
     */
    public static void debug(Logger logger, String format, Object... arguments) {
        log(logger, LogLevel.DEBUG, LogColor.GREY, format, arguments);
    }

    /**
     * INFO 级别日志
     * @param logger 日志器
     * @param format 日志内容格式
     * @param arguments 日志内容参数
     */
    public static void info(Logger logger, String format, Object... arguments) {
        log(logger, LogLevel.INFO, LogColor.CYAN, format, arguments);
    }

    /**
     * WARN 级别日志
     * @param logger 日志器
     * @param format 日志内容格式
     * @param arguments 日志内容参数
     */
    public static void warn(Logger logger, String format, Object... arguments) {
        log(logger, LogLevel.WARN, LogColor.YELLOW, format, arguments);
    }

    /**
     * ERROR 级别日志
     * @param logger 日志器
     * @param format 日志内容格式
     * @param arguments 日志内容参数
     */
    public static void error(Logger logger, String format, Object... arguments) {
        log(logger, LogLevel.ERROR, LogColor.RED, format, arguments);
    }

    /**
     * 通用颜色日志器
     * @param logger 日志器
     * @param level 日志等级
     * @param color 日志颜色
     * @param format 日志内容格式
     * @param arguments 日志内容参数
     */
    public static void log(Logger logger, LogLevel level, LogColor color, String format, Object... arguments) {
        format = (format == null ? "" : format);
        if (logger == null) {
            String message = comboMessage(null, color, format, arguments);
            Console.log(message, color);

        } else {
            level = (level == null ? LogLevel.DEFAULT : level);
            if (level == LogLevel.DEBUG) {
                color = (color == null ? LogColor.GREY : color);
                String message = comboMessage(null, color, format, null);
                logger.debug(message, arguments);

            } else if (level == LogLevel.WARN) {
                color = (color == null ? LogColor.YELLOW : color);
                String message = comboMessage(null, color, format, null);
                logger.warn(message, arguments);

            } else if (level == LogLevel.ERROR) {
                color = (color == null ? LogColor.RED : color);
                String message = comboMessage(null, color, format, null);
                logger.error(message, arguments);

            } else {
                color = (color == null ? LogColor.CYAN : color);
                String message = comboMessage(null, color, format, null);
                logger.info(message, arguments);
            }
        }
    }

    private static String comboMessage(LogLevel level, LogColor color, String format, Object... arguments) {
        String message = format;
        if (arguments != null) {
            StringBuffer sb = new StringBuffer();

            // 拼接日志参数
            String[] parts = format.split("\\{\\}");
            int i = 0;
            for (String part : parts) {
                sb.append(part);
                try {
                    sb.append(arguments[i++]);
                } catch (Exception e) {
                    sb.append("{}");
                }
            }

            // 拼接异常信息
            try {
                Object o = arguments[arguments.length - 1];
                if (o instanceof Throwable) {
                    Throwable t = (Throwable) o;
                    sb.append(": ");
                    sb.append(t.getMessage());
                }
            } catch (Exception e) {}

            message = sb.toString();
        }
        return StrUtils.concat(
                color.PREFIX(),
                (level == null ? "" : StrUtils.concat("[", level.DESC(), "] ")),
                message,
                color.SUFFIX()
        );
    }

}
