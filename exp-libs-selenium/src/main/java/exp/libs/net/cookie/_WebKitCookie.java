package exp.libs.net.cookie;

import org.openqa.selenium.Cookie;

import java.util.Date;

/**
 * <PRE>
 * 单个cookie属性集（兼容selenium）
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class _WebKitCookie extends _HttpCookie {

	/**
	 * 构造函数
	 */
	protected _WebKitCookie() {
		super();
	}
	
	/**
	 * 构造函数
	 * @param headerCookie HTTP响应头中的 Set-Cookie, 格式如：
	 * 	JSESSIONID=4F12EEF0E5CC6E8B239906B29919D40E; Domain=www.baidu.com; Path=/; Expires=Mon, 29-Jan-2018 09:08:16 GMT+08:00; Secure; HttpOnly; 
	 */
	protected _WebKitCookie(String headerCookie) {
		super(headerCookie);
	}
	
	/**
	 * 构造函数
	 * @param cookie selenium的cookie对象
	 */
	protected _WebKitCookie(Cookie cookie) {
		super();
		init(cookie);
	}
	
	private void init(Cookie cookie) {
		if(cookie == null) {
			return;
		}
		
		this.name = cookie.getName();
		this.value = cookie.getValue();
		this.domain = cookie.getDomain();
		this.path = cookie.getPath();
		this.expiry = (cookie.getExpiry() == null ? new Date() : cookie.getExpiry());
		this.isSecure = cookie.isSecure();
		this.isHttpOnly = cookie.isHttpOnly();
	}
	
	/**
	 * 生成selenium的cookie对象
	 * @return selenium的cookie对象
	 */
	protected Cookie toSeleniumCookie() {
		return new Cookie(name, value, domain, path, expiry, isSecure, isHttpOnly);
	}
	
}
