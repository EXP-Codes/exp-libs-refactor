package exp.libs.log;

import ch.qos.logback.core.util.StatusPrinter;
import exp.libs.utils.str.StrUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;

/**
 * <PRE>
 * 日志工具
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">www.exp-blog.com</a>
 * @version   2017-08-18
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class LogUtils {

	/** logback 默认配置文件路径 */
	public final static String LOGBACK_PATH = "./conf/logback.xml";

	/** log4j2 默认配置文件路径 */
	public final static String LOG4J2_PATH = "./conf/log4j2.xml";
	
	/** 私有化构造函数 */
	protected LogUtils() {}
	
	/**
	 * 加载 logback 日志配置文件
	 * (默认路径为 ./conf/logback.xml)
	 */
	public static void loadLogBackConfig() {
		loadLogBackConfig(LOGBACK_PATH, false);
	}

	/**
	 * 加载 logback 日志配置文件
	 * @param logbackConfPath 日志配置文件路径
	 */
	public static void loadLogBackConfig(String logbackConfPath) {
		loadLogBackConfig(LOGBACK_PATH, false);
	}

	/**
	 * <pre>
	 * 加载 logback 日志配置文件
	 * （若不调用此方法，默认配置文件路径为 jar 内的 src/main/resources/logback.xml）
	 * ------------------------------------
	 * 此方法在效果上等同于：
	 * static {
	 *     System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, ${CustomLogbackPath}");
	 * }
	 * 但是静态块有个问题，就是无法传参，所以还是此方法更好
	 * </pre>
	 * @param logbackConfPath 日志配置文件路径
	 * @param printLoadInfo 是否打印加载 logback 配置时的异常信息（用于调试）
	 */
	public static void loadLogBackConfig(String logbackConfPath, boolean printLoadInfo) {
		if(StrUtils.isEmpty(logbackConfPath)) {
			logbackConfPath = LOGBACK_PATH;
		}

		// 包名写到方法内部时，没有调用此方法都不会报错，确保可以按需引入
		try {
			File file = new File(logbackConfPath);
			ch.qos.logback.classic.LoggerContext loggerContext =
					(ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();
			ch.qos.logback.classic.joran.JoranConfigurator joranConfigurator =
					new ch.qos.logback.classic.joran.JoranConfigurator();
			joranConfigurator.setContext(loggerContext);
			loggerContext.reset();
			joranConfigurator.doConfigure(file);

			// 打印 Logback 初始化时的异常信息
			if (printLoadInfo) {
				StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Fail to load logBack configure file: " + logbackConfPath);
		}
	}

	/**
	 * 加载 log4j2 日志配置文件
	 * (默认路径为 ./conf/log4j2.xml)
	 */
	public static void loadLog4J2Config() {
		loadLog4J2Config(LOG4J2_PATH);
	}

	/**
	 * 加载 log4j2 日志配置文件
	 * （若不加载，默认配置文件路径为 src/main/resources/log4j2.xml）
	 * @param log4J2ConfPath 日志配置文件路径
	 */
	public static void loadLog4J2Config(String log4J2ConfPath) {
		if(StrUtils.isEmpty(log4J2ConfPath)) {
			log4J2ConfPath = LOGBACK_PATH;
		}

		// 包名写到方法内部时，没有调用此方法都不会报错，确保可以按需引入
		try {
			File log4j2File = new File(log4J2ConfPath);
			if (log4j2File.exists()) {
				org.apache.logging.log4j.core.config.ConfigurationSource configurationSource =
						new org.apache.logging.log4j.core.config.ConfigurationSource(
								new FileInputStream(log4j2File), log4j2File
						);
				org.apache.logging.log4j.core.config.Configurator.initialize(null, configurationSource);
			} else {
				System.err.println("Fail to load log4J2 configure file (Not Exist): " + log4J2ConfPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Fail to load log4J2 configure file: " + log4J2ConfPath);
		}
	}

}
