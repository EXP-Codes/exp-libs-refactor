package exp.libs.net.http;

/**
 * <PRE>
 * 封装了Apache-HttpClient.
 *  可以保持连接对象, 并介入获取连接过程中的请求/响应参数.
 * </PRE>
 * 
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class HttpClient extends _HttpClient {

	public HttpClient() {
		super();
	}
	
	public HttpClient(String charset, int connTimeout, int callTimeout) {
		super(charset, connTimeout, callTimeout);
	}

}
