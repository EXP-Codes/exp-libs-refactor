package exp.libs.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <PRE>
 * 日志工具测试
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">www.exp-blog.com</a>
 * @version   2022-10-02
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
class LogUtilsTest {

    private static Logger log = LoggerFactory.getLogger(LogUtilsTest.class);

    /** 此工程为子模块，logback 的工程的根目录是父工程的目录，故需在路径前添加 exp-libs-log */
    private final static String LOGBACK_PATH = "./exp-libs-log/conf/logback.xml";

    /** 此工程为子模块，log4j2 的工程的根目录是子模块的目录，故需路径前无需添加 exp-libs-log */
    private final static String LOG4J2_PATH = "./conf/log4j2.xml";


    @Test
    void loadLogBackConfig() {
        log.debug("[DEBUG] 尚未初始化 logback 日志");
        log.info("[INFO] 尚未初始化 logback 日志");
        log.warn("[WARN] 尚未初始化 logback 日志");
        log.error("[ERROR] 尚未初始化 logback 日志");

        LogUtils.loadLogBackConfig(LOGBACK_PATH);
        log.debug("[DEBUG] 已初始化 logback 日志");
        log.info("[INFO] 已初始化 logback 日志");
        log.warn("[WARN] 已初始化 logback 日志");
        log.error("[ERROR] 已初始化 logback 日志");
    }

    @Test
    void loadLog4J2Config() {
        log.debug("[DEBUG] 尚未初始化 log4j2 日志");
        log.info("[INFO] 尚未初始化 log4j2 日志");
        log.warn("[WARN] 尚未初始化 log4j2 日志");
        log.error("[ERROR] 尚未初始化 log4j2 日志");

        LogUtils.loadLog4JConfig(LOG4J2_PATH);
        log.debug("[DEBUG] 已初始化 log4j2 日志");
        log.info("[INFO] 已初始化 log4j2 日志");
        log.warn("[WARN] 已初始化 log4j2 日志");
        log.error("[ERROR] 已初始化 log4j2 日志");
    }
}