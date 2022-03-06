package exp.libs.socket.nio.common.filter;

import exp.libs.socket.nio.common.filterchain.INextFilter;
import exp.libs.socket.nio.common.filterchain.impl.BaseFilter;
import exp.libs.socket.nio.common.interfaze.ISession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 日志打印过滤器（TODO:未完成）
 * 
 * 可用于打印消息在各个触发事件点的日志状态
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class LogFilter extends BaseFilter {

	/**
	 * 日志器
	 */
	private final static Logger log = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void onSessionCreated(INextFilter nextFilter, ISession session)
			throws Exception {
				
		/**
		 * 打印会话创建日志
		 */
		log.info("Log onSessionCreated");
		
		nextFilter.onSessionCreated(session);
	}

	@Override
	public void onMessageReceived(INextFilter nextFilter, ISession session,
			Object msg) throws Exception {

		/**
		 * 打印消息接收日志
		 */
		log.info("Log onMessageReceived");
		
		nextFilter.onMessageReceived(session, msg);
	}

	@Override
	public void onMessageSent(INextFilter preFilter, ISession session, Object msg)
			throws Exception {

		/**
		 * 打印消息发送日志
		 */
		log.info("Log onMessageSent");
		
		preFilter.onMessageSent(session, msg);
	}

	@Override
	public void onExceptionCaught(INextFilter nextFilter, ISession session, 
			Throwable exception) {

		/**
		 * 打印异常日志
		 */
		log.info("Log onExceptionCaught");
		
		nextFilter.onExceptionCaught(session, exception);
	}

	@Override
	public void clean() {
		/**
		 * 打印资源清理日志
		 */
		log.info("Log clean");
	}

}
