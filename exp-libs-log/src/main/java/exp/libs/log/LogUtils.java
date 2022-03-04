package exp.libs.log;

import exp.libs.utils.str.StrUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;

/**
 * <PRE>
 * 日志工具
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-08-18
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class LogUtils {

	// FIXME 彩色日志

	/** logback 默认配置文件路径 */
	private final static String LOGBACK_PATH = "./conf/logback.xml";

	/** log4j2 默认配置文件路径 */
	private final static String LOG4J2_PATH = "./conf/log4j2.xml";
	
	/** 私有化构造函数 */
	protected LogUtils() {}
	
	/**
	 * 加载 logback 日志配置文件
	 * (默认路径为 ./conf/logback.xml)
	 */
	public static void loadLogBackConfig() {
		loadLogBackConfig(LOGBACK_PATH);
	}

	/**
	 * 加载 logback 日志配置文件
	 * （若不加载，默认配置文件路径为 src/main/resources/logback.xml）
	 * @param logbackConfPath 日志配置文件路径
	 */
	public static void loadLogBackConfig(String logbackConfPath) {
		if(StrUtils.isEmpty(logbackConfPath)) {
			logbackConfPath = LOGBACK_PATH;
		}

		// 包名写到方法内部时，没有调用此方法都不会报错，确保可以按需引入
		try {
			ch.qos.logback.classic.LoggerContext loggerContext =
					(ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();
			ch.qos.logback.access.joran.JoranConfigurator joranConfigurator =
					new ch.qos.logback.access.joran.JoranConfigurator();
			joranConfigurator.setContext(loggerContext);
			loggerContext.reset();

			joranConfigurator.doConfigure(logbackConfPath);
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
