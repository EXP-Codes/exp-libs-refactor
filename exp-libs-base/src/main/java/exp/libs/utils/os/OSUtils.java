package exp.libs.utils.os;

import exp.libs.utils.other.PathUtils;
import exp.libs.utils.str.StrUtils;
import exp.libs.utils.file.FileUtils;
import exp.libs.utils.file.JarUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * <PRE>
 * OS工具类
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public final class OSUtils {

	/** 日志器 */
	private final static Logger log = LoggerFactory.getLogger(JarUtils.class);

	/** 用于判断操作平台类型的系统属性 */
	protected final static String OS_NAME = 
			System.getProperty("os.name").toLowerCase(); 
	
	/** 用于判断操作系统位宽的系统属性 */
	protected final static String OS_ARCH = 
			System.getProperty("os.arch").toLowerCase();

	/** 操作系统字符集编码 */
	protected final static String OS_ENCODING = 
			System.getProperty("sun.jnu.encoding").toUpperCase();
	
	/**
	 * 程序入口命令.
	 *  用于判断程序运行环境：
	 *  1.通过tomcat运行的J2EE项目为固定值 org.apache.catalina.startup.Bootstrap start
	 *  2.通过main运行的J2SE项目为main入口类的类名
	 */
	private final static String SJC = System.getProperty("sun.java.command");
	protected final static String RUN_EVN = (SJC == null ? "" : SJC);
	private final static boolean RUN_BY_TOMCAT = 
			RUN_EVN.startsWith("org.apache.catalina.startup.Bootstrap");
	
	/** 私有化构造函数 */
	protected OSUtils() {}
	
	/**
	 * 判断当前操作系统是否为 windows
	 * @return true:windows; false:其他
	 */
	public static boolean isWin() {
		boolean isWin = true;
		if(OS_NAME.contains("win")) {
			isWin = true;

		} else {
			isWin = false;
		}
		return isWin;
	}

	/**
	 * 判断当前操作系统是否为 mac
	 * @return true:mac; false:其他
	 */
	public static boolean isMac() {
		boolean isMac = true;
		if(OS_NAME.contains("mac")) {
			isMac = true;

		} else {
			isMac = false;
		}
		return isMac;
	}

	/**
	 * 判断当前操作系统是否为 unix
	 * @return true:unix; false:其他
	 */
	public static boolean isUnix() {
		return !isWin(); // mac 也是 unix
	}
	
	/**
	 * <PRE>
	 * 判断当前操作系统位宽是否为64位.
	 * （主要针对win, linux由于兼容32和64, 只能用64位）.
	 * 
	 * os 32位： x86
	 * os 64位：amd64
	 * linux 32位: i386
	 * linux 64位：amd64
	 * <PRE>
	 * @return true:64; false:32
	 */
	public static boolean isX64() {
		return OS_ARCH.contains("64");
	}
	
	/**
	 * <PRE>
	 * 判断当前操作系统位宽是否为32位.
	 * <PRE>
	 * @return true:64; false:32
	 */
	public static boolean isX32() {
		return !isX64();
	}
	
	/**
	 * 获取操作系统字符集编码
	 * @return 操作系统字符集编码
	 */
	public static String getSysEncoding() {
		return OS_ENCODING;
	}
	
	/**
	 * 检查当前程序是否通过tomcat启动
	 * @return true:通过tomcat启动; false:通过main启动
	 */
	public static boolean isRunByTomcat() {
		return RUN_BY_TOMCAT;
	}

	/**
	 * <PRE>
	 * 把 dos 内容转换为符合 unix 标准内容。
	 * 	(实则上不是 dos 也能转换为 unix)
	 * </PRE>
	 *
	 * @param dos dos内容
	 * @return 符合unix标准内容
	 */
	public static String dos2unix(String dos) {
		String unix = "";
		if(dos != null) {
			unix = dos.replace("\r", "").
					replace('\\', '/');
		}
		return unix;
	}

	/**
	 * <PRE>
	 * unix 内容转换为符合 dos 标准内容。
	 * 	(实则上不是 unix 也能转换为 dos)
	 * </PRE>
	 *
	 * @param unix unix内容
	 * @return 符合dos标准内容
	 */
	public static String unix2dos(String unix) {
		String dos = "";
		if(unix != null) {
			dos = unix.replace("\r", "").
					replace("\n", "\r\n").
					replace('/', '\\');
		}
		return dos;
	}

	/**
	 * 复制文本到剪切板
	 * @param txt 文本内容
	 */
	public static void copyToClipboard(final String txt) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(new StringSelection(txt), null);
	}
	
	/**
	 * 从剪切板获得文字
	 * @return 文本内容
	 */
	public static String pasteFromClipboard() {
		String txt = "";
		Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable tf = sysClip.getContents(null);
		if (tf != null) {
			if (tf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				try {
					txt = (String) tf.getTransferData(DataFlavor.stringFlavor);
				} catch (Exception e) {}
			}
		}
		return txt;
	}

	/**
	 * 获取当前系统可用的字体列表
	 * @return 可用字体列表
	 */
	public static String[] getSysFonts() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		return env.getAvailableFontFamilyNames();
	}
	
	/**
	 * <PRE>
	 * 获取进程启动锁(文件锁定方式).
	 * --------------------------------------------------
	 *   当要求程序只能在操作系统中运行一个进程时, 可使用此方法获取启动锁.
	 *   当获取启动锁失败时, 配合System.exit终止程序即可.
	 * --------------------------------------------------
	 * 原理：
	 *   程序每次运行时, 均在系统临时目录创建固有名称的临时文件, 该临时文件在程序终止时自动删除.
	 *   由于文件不能被重复创建, 这样就确保了在系统中只能存在一个进程.
	 *   
	 * 缺陷:
	 *   若使用非正常方式结束进程(如: kill -9), 会导致程序之后无法启动.
	 * </PRE>
	 * @param processName 进程名（任意即可，但不能为空）
	 * @return true:获取启动锁成功(程序只运行了一次); false:获取启动锁失败(程序被第运行了2次以上)
	 */
	public static boolean getStartlock(String processName) {
		boolean isOk = false;
		if(StrUtils.isNotTrimEmpty(processName)) {
			String tmpPath = PathUtils.combine(
					PathUtils.getSysTmpDir(), "LOCK_".concat(processName));
			if(!FileUtils.exists(tmpPath)) {
				File tmpFile = FileUtils.createFile(tmpPath);
				isOk = (tmpFile != null);
				tmpFile.deleteOnExit(); // 程序终止时删除该临时文件
			}
		}
		return isOk;
	}
	
	/**
	 * <PRE>
	 * 获取进程启动锁(端口锁定方式).
	 * --------------------------------------------------
	 *   当要求程序只能在操作系统中运行一个进程时, 可使用此方法获取启动锁.
	 *   当获取启动锁失败时, 配合System.exit终止程序即可.
	 * --------------------------------------------------
	 * 原理：
	 *   程序每次运行时, 会占用一个空闲端口, 该端口在程序终止时自动删除.
	 *   由于端口不能被重复占用, 这样就确保了在系统中只能存在一个进程.
	 * </PRE>
	 * 
	 * @param port 空闲端口
	 * @return true:获取启动锁成功(程序只运行了一次); false:获取启动锁失败(程序被第运行了2次以上)
	 */
	public static boolean getStartlock(int port) {
		boolean isOk = false;
		if(port > 0) {
			try {
				InetSocketAddress socket = new InetSocketAddress("0.0.0.0", port);
				ServerSocket socketServer = new ServerSocket();
				socketServer.bind(socket);

			} catch (Exception e) {
				log.error("绑定端口 [{}] 失败：端口已被占用.", port);
			}
		}
		return isOk;
	}
	
}
