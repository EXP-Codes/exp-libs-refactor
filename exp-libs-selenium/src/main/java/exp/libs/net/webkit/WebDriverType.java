package exp.libs.net.webkit;

import exp.libs.utils.str.StrUtils;

/**
 * <PRE>
 * Web 驱动类型
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class WebDriverType {

	/** WEB 驱动包目录 */
	private final static String DRIVER_DIR = "./bin/driver/";
	
	/** HTML默认浏览器 */
	private final static String HtmlUnit = "HtmlUnit";
	public final static WebDriverType HTMLUTIL = new WebDriverType(HtmlUnit);
	

	/** Chrome 无头浏览器 */
	private final static String Chrome = "chromedriver.exe";
	public final static WebDriverType CHROME = new WebDriverType(Chrome);
	
	/** 驱动名 */
	private String driverName;
	
	/** 驱动路径 */
	private String driverPath;
	
	/**
	 * 构造函数
	 * @param driverName 驱动名
	 */
	private WebDriverType(String driverName) {
		this.driverName = driverName;
		this.driverPath = StrUtils.concat(DRIVER_DIR(), driverName);
	}
	
	/**
	 * 获取WEB驱动包目录 (可重载)
	 * @return WEB驱动包目录
	 */
	protected String DRIVER_DIR() {
		return DRIVER_DIR;
	}
	
	/**
	 * 获取驱动名
	 * @return 驱动名
	 */
	public String DRIVER_NAME() {
		return driverName;
	}
	
	/**
	 * 获取驱动路径
	 * @return 驱动路径
	 */
	public String DRIVER_PATH() {
		return driverPath;
	}
	
}
