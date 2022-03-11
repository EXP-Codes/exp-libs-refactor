package exp.libs.sock.socket.nio.common.envm;

/**
 * <pre>
 * NioSocket 客户端和服务端内部默认的通信协议报文
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Protocol {

	/** 连接受限 */
	public final static String CONN_LIMIT = "Connected limited number";
	
	/** 未处理消息数受限 */
	public final static String MSG_LIMIT = "Undo Msg limited number";
	
	/** 周期心跳 */
	public final static String HEARTBEAT = "Regular Heartbeat";
	
}
