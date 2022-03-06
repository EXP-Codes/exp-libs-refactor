package exp.libs.encode;

import org.apache.commons.codec.binary.Base64;

/**
 * <PRE>
 * Base64 编解码工具
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Base64Utils {

	/** 私有化构造函数 */
	protected Base64Utils() {}
	
	/**
	 * Base64编码
	 * @param bytes 原始字节数据
	 * @return Base64编码字符串
	 */
	public static String encode(byte[] bytes) {
		String base64 = "";
		try {
			base64 = Base64.encodeBase64String(bytes).trim();
//			base64 = base64.replaceAll("[\r\n]", "");	// 可不去掉内部换行, 不影响
			
		} catch(Exception e) {}
		return base64;
	}
	
	/**
	 * Base64解码
	 * @param base64 Base64编码字符串
	 * @return 原始字节数据
	 */
	public static byte[] decode(String base64) {
		byte[] bytes = new byte[0];
		try {
			bytes = Base64.decodeBase64(base64);
			
		} catch(Exception e) {}
		return bytes;
	}
	
}
