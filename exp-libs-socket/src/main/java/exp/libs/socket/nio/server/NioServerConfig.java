package exp.libs.socket.nio.server;

import exp.libs.socket.bean.SocketBean;
import exp.libs.socket.nio.common.cache.MsgQueue;
import exp.libs.socket.nio.common.cache.NioConfig;
import exp.libs.socket.nio.common.filter.ThreadPoolFilter;
import exp.libs.socket.nio.common.filterchain.impl.FilterChain;
import exp.libs.socket.nio.common.interfaze.IHandler;

/**
 * <pre>
 * NIOSocket服务器配置类。
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class NioServerConfig extends NioConfig {

	protected NioServerConfig(SocketBean socketBean, IHandler handler) {
		super(socketBean, handler);
	}
	
	/**
	 * 服务端默认添加线程池过滤器
	 */
	@Override
	protected void initFilterChain() {
		addFilter(ThreadPoolFilter.class.getSimpleName(),
				new ThreadPoolFilter(getMaxConnectionCount(), MsgQueue.MAX_MSG_LIMIT));
	}
	
	/**
	 * 获取过滤链
	 * @return
	 */
	protected FilterChain getFilterChain() {
		return filterChain;
	}

}
