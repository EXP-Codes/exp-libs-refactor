package exp.libs.log;

import exp.libs.envm.LogColor;
import exp.libs.envm.LogLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <PRE>
 * 颜色日志测试
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">www.exp-blog.com</a>
 * @version   2022-10-02
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
class ColorLogTest {

    private static Logger log = LoggerFactory.getLogger(ColorLogTest.class);

    @BeforeEach
    void setup() {
        LogUtils.loadLogBackConfig();
    }

    @Test
    void debug() {
        ColorLog.debug(log, "{} 日志", "DEBUG");
    }

    @Test
    void info() {
        ColorLog.info(log, "{} 日志", "INFO");
    }

    @Test
    void warn() {
        ColorLog.warn(log, "{} 日志", "WARN");
    }

    @Test
    void error() {
        ColorLog.error(log, "{} 日志（无异常）", "ERROR");
        try {
            int a = 1 / 0;
        } catch (Exception e)  {
            ColorLog.error(log, "{} 日志（有异常）", "ERROR", e);
        }
    }

    @Test
    void log() {
        ColorLog.log(log, LogLevel.DEBUG, LogColor.BLACK, "{} {} 日志", "DEBUG", "黑色");
        ColorLog.log(log, LogLevel.INFO, LogColor.RED, "{} {} 日志", "INFO", "红色");
        ColorLog.log(log, LogLevel.WARN, LogColor.BLUE, "{} {} 日志", "WARN", "蓝色");
        ColorLog.log(log, LogLevel.ERROR, LogColor.GREEN, "{} {} 日志（无异常）", "ERROR", "绿色");

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            ColorLog.log(log, LogLevel.ERROR, LogColor.MAGENTA, "{} {} 日志（有异常）", "ERROR", "粉色", e);
        }
    }
}