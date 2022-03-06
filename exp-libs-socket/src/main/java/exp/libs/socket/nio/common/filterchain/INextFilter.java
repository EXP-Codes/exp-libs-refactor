package exp.libs.socket.nio.common.filterchain;


import exp.libs.socket.nio.common.interfaze.ISession;

/**
 * <pre>
 * 关系过滤器接口
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public interface INextFilter {

	/**
	 * 触发下一个业务过滤器的onSessionCreated事件
	 * @param session 会话
	 */
	public void onSessionCreated(ISession session);

	/**
	 * 触发下一个业务过滤器的onMessageReceived事件
	 * @param session 会话
	 * @param msg 接收消息
	 */
	public void onMessageReceived(ISession session, Object msg);

	/**
	 * 触发上一个业务过滤器的onMessageSent事件
	 * @param session 会话
	 * @param msg 发送消息
	 */
	public void onMessageSent(ISession session, Object msg);

	/**
	 * 触发下一个业务过滤器的onExceptionCaught事件
	 * @param session 会话
	 * @param exception 异常
	 */
	public void onExceptionCaught(ISession session, Throwable exception);

}
