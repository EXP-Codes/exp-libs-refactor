package exp.libs.sock.socket.nio.common.filterchain.impl;


import exp.libs.sock.socket.nio.common.filterchain.INextFilter;
import exp.libs.sock.socket.nio.common.interfaze.IFilter;
import exp.libs.sock.socket.nio.common.interfaze.ISession;

/**
 * <pre>
 * 基本业务过滤器
 * 
 * 若只需要重写部分事件逻辑，建议继承此类。
 * 若需要重写全部事件逻辑，应该实现实现IFilter接口
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class BaseFilter implements IFilter {

	@Override
	public void onSessionCreated(INextFilter nextFilter, ISession session)
			throws Exception {

		nextFilter.onSessionCreated(session);
	}

	@Override
	public void onMessageReceived(INextFilter nextFilter, ISession session,
			Object msg) throws Exception {

		nextFilter.onMessageReceived(session, msg);
	}

	@Override
	public void onMessageSent(INextFilter preFilter, ISession session, Object msg)
			throws Exception {

		preFilter.onMessageSent(session, msg);
	}

	@Override
	public void onExceptionCaught(INextFilter nextFilter, ISession session, 
			Throwable exception) {

		nextFilter.onExceptionCaught(session, exception);
	}

	@Override
	public void clean() {
		//...
	}

}
