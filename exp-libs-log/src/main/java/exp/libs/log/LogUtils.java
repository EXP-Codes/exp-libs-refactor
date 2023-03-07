package exp.libs.log;

import exp.libs.envm.LogColor;
import exp.libs.envm.LogLevel;
import exp.libs.utils.str.StrUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;

/**
 * <PRE>
 * 日志工具
 * -----------------
 * 若不调用此类加载日志配置，默认读取的配置文件路径为 jar 内的 src/main/resources/logback.xml 或 log4j2.xml
 * -----------------
 * 若报错 SLF4J: Class path contains multiple SLF4J bindings. 是正常的
 * 因为 pom.xml 同时依赖了 logback 和 log4j2 两种依赖实现
 * 使用某一种时，先在 pom.xml 中 exclusions 另外一种即可
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
			File logbackFile = new File(logbackConfPath);
			if (logbackFile.exists()) {
				ch.qos.logback.classic.LoggerContext loggerContext =
						(ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();
				ch.qos.logback.classic.joran.JoranConfigurator joranConfigurator =
						new ch.qos.logback.classic.joran.JoranConfigurator();
				joranConfigurator.setContext(loggerContext);
				loggerContext.reset();
				joranConfigurator.doConfigure(logbackFile);

				// 打印 Logback 初始化时的异常信息
				if (printLoadInfo) {
					ch.qos.logback.core.util.StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
				}
			} else {
				Console.err("Fail to load logback configure file (Not Exist): {}", logbackConfPath);
			}
		} catch (Exception e) {
			Console.err("Fail to load logback configure file: {}", logbackConfPath, e);
		}
	}

	/**
	 * <pre>
	 * 加载 log4j2 日志配置文件
	 * (默认路径为 ./conf/log4j2.xml)
	 * ---------------
	 * log4j2 限制太多，不推荐使用。
	 * 在重新指定配置后，只能对其之后创建的日志对象生效，而且在单元测试中无法生效，原因暂时不明
	 * </pre>
	 */
/*
	@Deprecated
	public static void loadLog4JConfig() {
		loadLog4JConfig(LOG4J2_PATH);
	}
*/

	/**
	 * <pre>
	 * 加载 log4j2 日志配置文件
	 * ---------------
	 * log4j2 限制太多，而且近期一堆 CVE 漏洞，明显被针对了，不推荐使用。
	 * 在重新指定配置后，只能对其之后创建的日志对象生效，而且在单元测试中无法生效，原因暂时不明。
	 * </pre>
	 * @param log4JConfPath 日志配置文件路径
	 */
/*
	@Deprecated
	public static void loadLog4JConfig(String log4JConfPath) {
		if(StrUtils.isEmpty(log4JConfPath)) {
			log4JConfPath = LOG4J2_PATH;
		}

		// 包名写到方法内部时，没有调用此方法都不会报错，确保可以按需引入
		try {
			File log4jFile = new File(log4JConfPath);
			if (log4jFile.exists()) {
				org.apache.logging.log4j.core.config.ConfigurationSource source =
						new org.apache.logging.log4j.core.config.ConfigurationSource(
								new FileInputStream(log4jFile), log4jFile
						);
				org.apache.logging.log4j.core.config.Configurator.initialize(null, source);

			} else {
				Console.err("Fail to load log4J2 configure file (Not Exist): {}", log4JConfPath);
			}
		} catch (Exception e) {
			Console.err("Fail to load log4J2 configure file: {}", log4JConfPath, e);
		}
	}
*/

	/**
	 * 组装日志内容
	 * @param message 日志内容
	 * @param color 日志颜色
	 * @return 日志内容
	 */
	protected static String comboMessage(LogLevel level, LogColor color, String message) {
		level = (level == null ? LogLevel.DEFAULT : level);
		color = (color == null ? LogColor.DEFAULT : color);
		return StrUtils.concat(
				color.PREFIX(),
				" ",
				level.DESC(),
				message,
				" ",
				color.SUFFIX()
		);
	}

	/**
	 * 替换日志格式中的占位符
	 * @param format 日志内容格式（含占位符 {} ）
	 * @param arguments 日志内容参数
	 * @return 日志内容
	 */
	protected static String replacePlaceholder(String format, Object... arguments) {
		String message = format;
		if (arguments != null) {
			StringBuffer sb = new StringBuffer();
			String[] parts = format.split("\\{\\}");
			int i = 0;
			for (String part : parts) {
				sb.append(part);
				try {
					Object o = arguments[i++];
					sb.append(o == null ? "null" : o.toString());
				} catch (Exception e) {
					sb.append("{}");
				}
			}
			message = sb.toString();
		}
		return message;
	}

	/**
	 * 提取日志内容参数的最后一个异常对象
	 * @param arguments 日志内容参数
	 * @return 异常对象（若不存在返回 Null）
	 */
	protected static Throwable takeException(Object... arguments) {
		Throwable t = null;
		if (arguments != null && arguments.length > 0) {
			Object o = arguments[arguments.length - 1];
			if (o instanceof Throwable) {
				t = (Throwable) o;
			}
		}
		return t;
	}

}
