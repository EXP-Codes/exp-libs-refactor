package exp.libs.net.http;

import exp.libs.encode.Base64Utils;
import exp.libs.envm.Charset;
import exp.libs.utils.file.FileUtils;
import exp.libs.utils.str.CharsetUtils;
import exp.libs.utils.str.StrUtils;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.net.*;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <PRE>
 * HTTP工具
 * </PRE>
 * 
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class HttpUtils {

	/** 日志器 */
	protected final static Logger log = LoggerFactory.getLogger(HttpURLUtils.class);
	
	/** 默认编码 */
	public final static String DEFAULT_CHARSET = Charset.UTF8;
	
	/** 连接超时, 默认1分钟 */
	public final static int CONN_TIMEOUT = 60000;

	/** 响应/读取超时 , 默认1分钟 */
	public final static int CALL_TIMEOUT = 60000;
	
	/** URL协议类型:HTTPS */
	private final static String HTTPS = "https";
	
	/** SSL实例名称 */
	private final static String TLS = "tls";
	
	/** GET请求方法名 */
	public final static String METHOD_GET = "GET";
	
	/** POST请求方法名 */
	public final static String METHOD_POST = "POST";
	
	/** 默认本地IP  */
	private final static String LOCAL_IP = "127.0.0.1";
	
	/** 页面使用BASE64存储的图像信息正则 */
	private final static String RGX_BASE64_IMG = "data:image/([^;]+);base64,(.*)";
	
	/** 私有化构造函数 */
	protected HttpUtils() {}
	
	/**
	 * 测试URL是否有效
	 * @param url url路径
	 * @return true:有效; false:无效
	 */
	public static boolean testValid(final String url) {
		boolean isValid = false;
		try {
			HttpURLConnection conn = 
					(HttpURLConnection) new URL(url).openConnection();
			isValid = isResponseOK(conn);
		} catch (Exception e) {
			log.error("测试URL失败", e);
		}
		return isValid;
	}
	
	/**
	 * 判断HTTP请求是否响应成功
	 * @param conn HTTP连接
	 * @return true:返回200状态码; false:返回非200状态码
	 */
	public static boolean isResponseOK(HttpURLConnection conn) {
		boolean isOk = false;
		try {
			isOk = (conn.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			log.error("提取HTTP状态码失败", e);
		}
		return isOk;
	}
	
	/**
	 * 判断HTTP响应状态码是否为成功
	 * @param httpStatus 响应状态码
	 * @return true:返回200状态码; false:返回非200状态码
	 */
	public static boolean isResponseOK(int httpStatus) {
		return (httpStatus == HttpStatus.SC_OK);
	}
	
	/**
	 * 构造HTTP/HTTPS连接(支持TLSv1.2)
	 * @param url 目标地址
	 * @param method 请求方法：GET/POST
	 * @return HTTP连接(失败返回null)
	 */
	public static HttpURLConnection createHttpConn(String url, String method) {
		return createHttpConn(url, method, null, CONN_TIMEOUT, CALL_TIMEOUT);
	}
	
	/**
	 * 构造HTTP/HTTPS连接(支持TLSv1.2)
	 * @param url 目标地址
	 * @param method 请求方法：GET/POST
	 * @param header 请求头参数
	 * @return HTTP连接(失败返回null)
	 */
	public static HttpURLConnection createHttpConn(String url, 
			String method, Map<String, String> header) {
		return createHttpConn(url, method, header, 
				CONN_TIMEOUT, CALL_TIMEOUT);
	}
	
	/**
	 * 构造HTTP/HTTPS连接(支持TLSv1.2)
	 * @param url 目标地址
	 * @param method 请求方法：GET/POST
	 * @param header 请求头参数
	 * @param connTimeout 连接超时(ms)
	 * @param readTimeout 读取超时(ms)
	 * @return HTTP连接(失败返回null)
	 */
	public static HttpURLConnection createHttpConn(String url, String method, 
			Map<String, String> header, int connTimeout, int readTimeout) {
		HttpURLConnection conn = null;
		try {
			conn = _createHttpConn(url, method, header, connTimeout, readTimeout);
			
		} catch(Exception e) {
			log.error("创建HTTP连接失败", e);
		}
		return conn;
	}
	
	/**
	 * 构造HTTP/HTTPS连接(支持TLSv1.2)
	 * @param url 目标地址
	 * @param method 请求方法：GET/POST
	 * @param header 请求头参数
	 * @param connTimeout 连接超时(ms)
	 * @param readTimeout 读取超时(ms)
	 * @return HTTP连接(失败返回null)
	 * @throws Exception
	 */
	private static HttpURLConnection _createHttpConn(String url, String method, 
			Map<String, String> header, int connTimeout, int readTimeout) throws Exception {
		HttpURLConnection conn = null;
		if(StrUtils.isEmpty(url)) {
			return conn;
		}
		URL URL = new URL(url);
		
		// HTTPS连接(若依然报错 protocol_version， 则调用此方法的程序需切换到JDK1.8以上, JDK1.8默认使用TLSv1.2)
		if(HTTPS.equals(URL.getProtocol())) {
			conn = (HttpsURLConnection) URL.openConnection();

		// HTTP连接
		} else {
			conn = (HttpURLConnection) URL.openConnection();
		}

		// 设置固有请求参数
		conn.setRequestMethod(method);
		conn.setConnectTimeout(connTimeout);
		conn.setReadTimeout(readTimeout);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		// 设置自定义请求头参数
		if(header != null) {
			Iterator<String> keyIts = header.keySet().iterator();
			while(keyIts.hasNext()) {
				String key = keyIts.next();
				String val = header.get(key);
				if(StrUtils.isNotEmpty(key, val)) {
					conn.setRequestProperty(key, val);
				}
			}
		}
		return conn;
	}
	
	/**
	 * 关闭HTTP/HTTPS连接
	 * @param conn HTTP/HTTPS连接
	 */
	public static void close(HttpURLConnection conn) {
		if(conn != null) {
			conn.disconnect();
		}
	}
	
	/**
	 * 创建HttpClient会话(不支持TLSv1.2)
	 * @return HTTP会话
	 */
	public static HttpClient createHttpClient() {
		return createHttpClient(CONN_TIMEOUT, CALL_TIMEOUT);
	}

	/**
	 * 创建HttpClient会话(不支持TLSv1.2)
	 * @param connTimeout 连接超时时间(ms)
	 * @param callTimeout 请求超时时间(ms)
	 * @return HTTP会话
	 */
	public static HttpClient createHttpClient(int connTimeout, int callTimeout) {
		HttpConnectionManagerParams managerParams = new HttpConnectionManagerParams();
		managerParams.setConnectionTimeout(connTimeout);
		managerParams.setSoTimeout(callTimeout);
		
		HttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
		httpConnectionManager.setParams(managerParams);

		HttpClient httpClient = new HttpClient(new HttpClientParams());
		httpClient.setHttpConnectionManager(httpConnectionManager);
		return httpClient;
	}
	
	/**
	 * 关闭HttpClient会话
	 * @param httpClient HTTP会话
	 */
	public static void close(HttpClient httpClient) {
		if(httpClient != null) {
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
	}
	
	/**
	 * 对URL进行编码
	 * @param url url路径
	 * @return 编码后URL
	 */
	public static String encodeURL(final String url) {
		return encodeURL(url, DEFAULT_CHARSET);
	}
	
	/**
	 * 对URL进行编码
	 * @param url url路径
	 * @param charset 编码字符集
	 * @return 编码后URL
	 */
	public static String encodeURL(final String url, final String charset) {
		String encodeURL = "";
		try {
			encodeURL = URLEncoder.encode(url, charset);
			
		} catch (Exception e) {
			log.error("对URL以 [{}] 编码失败: {}", charset, url, e);
		}
		return encodeURL;
	}

	/**
	 * 对URL进行解码
	 * @param url url路径
	 * @return 解码后URL
	 */
	public static String decodeURL(final String url) {
		return decodeURL(url, DEFAULT_CHARSET);
	}
	
	/**
	 * 对URL进行解码
	 * @param url url路径
	 * @param charset 编码字符集
	 * @return 解码后URL
	 */
	public static String decodeURL(final String url, final String charset) {
		String decodeURL = "";
		try {
			decodeURL = URLDecoder.decode(url, charset);
			
		} catch (Exception e) {
			log.error("对URL以 [{}] 解码失败: {}", charset, url, e);
		}
		return decodeURL;
	}
	
	/**
	 * 把请求参数转换成URL的KV串形式并进行编码
	 * @param request 请求参数集
	 * @return ?&key1=val1&key2=val2&key3=val3
	 */
	public static String encodeRequests(Map<String, String> request) {
		return encodeRequests(request, DEFAULT_CHARSET);
	}
	
	/**
	 * 把请求参数转换成URL的KV串形式并进行编码
	 * @param request 请求参数集
	 * @param charset 参数字符编码
	 * @return ?key1=val1&key2=val2&key3=val3
	 */
	public static String encodeRequests(
			Map<String, String> request, final String charset) {
		if(request == null || request.isEmpty() || 
				CharsetUtils.isInvalid(charset)) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder("?");
		Iterator<String> keyIts = request.keySet().iterator();
		while(keyIts.hasNext()) {
			String key = keyIts.next();
			String val = request.get(key);
			try {
				val = URLEncoder.encode(val, charset);
			} catch (Exception e) {
				val = "";
			}
			
			// 注意：
			//   第一个参数开头的&，对于POST请求而言是必须的
			//   但对于GET请求则是可有可无的（但存在某些网页会强制要求不能存在）
			if(StrUtils.isNotEmpty(key, val)) {
				sb.append("&").append(key).append("=").append(val);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 拼接GET请求的URL和参数(对于第一个参数开头的&, 强制去除)
	 * @param url GET请求URL
	 * @param requestKVs GET请求参数表 (需通过{@link #encodeRequests}方法转码)
	 * @return GET请求URL
	 */
	protected static String concatGET(String url, String requestKVs) {
		url = StrUtils.isEmpty(url) ? "" : url;
		String _GETURL = url.concat(requestKVs);
		return _GETURL.replace(url.concat("?&"), url.concat("?"));	// 去掉第一个参数的&
	}
	
	/** 获取本地IP  */
	public static String getLocalIP() {
		String localIP = LOCAL_IP;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			localIP = addr.getHostAddress().toString();
			
		} catch (Exception e) {}
		return localIP;
	}
	
	/**
	 * 保存Base64编码的图片数据到本地
	 * @param dataUrl 图片数据编码地址，格式形如   data:image/png;base64,base64编码的图片数据
	 * @param saveDir 希望保存的图片目录
	 * @param imgName 希望保存的图片名称（不含后缀，后缀通过编码自动解析）
	 * @return 图片保存路径（若保存失败则返回空字符串）
	 */
	public static String convertBase64Img(String dataUrl, 
			String saveDir, String imgName) {
		String savePath = "";
		Pattern ptn = Pattern.compile(RGX_BASE64_IMG);  
        Matcher mth = ptn.matcher(dataUrl);      
        if(mth.find()) {
        	String ext = mth.group(1);	// 图片后缀
        	String base64Data = mth.group(2);	// 图片数据
            savePath = StrUtils.concat(saveDir, "/", imgName, ".", ext);
            
            try {
            	byte[] data = Base64Utils.decode(base64Data);
                FileUtils.writeByteArrayToFile(new File(savePath), data, false);
                
            } catch (Exception e) {  
                log.error("转换Base64编码图片数据到本地文件失败: [{}]", savePath, e);
            }
        }
        return savePath;  
    }
	
}
