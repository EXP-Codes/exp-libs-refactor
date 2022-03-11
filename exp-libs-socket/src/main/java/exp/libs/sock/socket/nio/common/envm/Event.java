package exp.libs.sock.socket.nio.common.envm;

/**
 * <pre>
 * 枚举类：事件类型
 * 
 * 主要用于程序事件的类型定义，根据不同类型执行不同操作。
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public enum Event {

	/** 通用事件类型 */
	COMMON(0, "通用事件"),

	/** 会话事件类型 */
	SESSION(1, "会话事件"),

	/** 消息接收事件类型 */
	MESSAGE_REVC(2, "消息接收事件"),

	/** 消息发送事件类型 */
	MESSAGE_SEND(3, "消息发送事件"),

	/** 异常事件类型 */
	EXCEPTION(4, "异常事件"),

	/** 其他事件类型 */
	OTHER(99, "其他事件"),

	;

	/** 类型值 */
	public int id;

	/** 类型描述 */
	public String desc;

	/**
	 * 构造函数
	 * @param id 类型值
	 * @param desc 类型描述
	 */
	private Event(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
}
