package exp.libs.sock.socket.nio.client;

import exp.libs.sock.socket.bean.SocketBean;
import exp.libs.sock.socket.nio.common.cache.NioConfig;
import exp.libs.sock.socket.nio.common.filter.ThreadPoolFilter;
import exp.libs.sock.socket.nio.common.filterchain.impl.FilterChain;
import exp.libs.sock.socket.nio.common.interfaze.IHandler;

/**
 * <pre>
 * NIOSocket客户端配置类。
 * Socket公共配置继承自SocketBean类。
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class NioClientConfig extends NioConfig {

	protected NioClientConfig(SocketBean socketBean, IHandler handler) {
		super(socketBean, handler);
	}
	
	/**
	 * 客户端默认移除线程池过滤器
	 */
	@Override
	protected void initFilterChain() {
		delFilter(ThreadPoolFilter.class.getSimpleName());
	}
	
	/**
	 * 获取过滤链
	 * @return
	 */
	protected FilterChain getFilterChain() {
		return filterChain;
	}

}
