package exp.libs.sock.socket.nio.common.handler;


import exp.libs.sock.socket.nio.common.interfaze.IHandler;

/**
 * <pre>
 * 业务处理抽象类
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
abstract class AbstractHandler implements IHandler {

	/**
	 * 客户业务处理接口
	 */
	protected IHandler handler;

	/**
	 * 构造函数
	 * @param handler 客户业务处理器
	 */
	public AbstractHandler(IHandler handler) {
		this.handler = handler;
	}

	/**
	 * 设置客户实现的业务处理器
	 * @param handler 业务处理器
	 */
	public void setHandler(IHandler handler) {
		this.handler = handler;
	}

}
