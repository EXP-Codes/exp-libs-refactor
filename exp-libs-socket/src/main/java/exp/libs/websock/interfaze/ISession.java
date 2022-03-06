package exp.libs.websock.interfaze;


import exp.libs.websock.bean.Frame;

/**
 * <pre>
 * WebSocket客户端会话接口
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public interface ISession {

	/**
	 * 设置本地连接保活超时（0不生效，默认60，即60秒后自动断开）
	 * @param keepTimeout 保活超时时间, 单位:秒
	 */
	public void setKeepTimeout(int keepTimeout);
	
	/**
	 * 检查WebSocket连接是否连接中
	 * @return true:连接存活; fase:连接已断开
	 */
	public boolean isConnecting();
	
	/**
	 * 向服务器发送数据帧
	 * @param frame 数据帧
	 */
	public void send(Frame frame);
	
}
