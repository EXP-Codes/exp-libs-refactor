package exp.libs.mq.jms.sup;

/**
 * <pre>
 * 消息消费者回调抽象类
 * </pre>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public abstract class AbstractConsumerCallBack {

	/**
	 * 消息消费者自动重连异常
	 * 
	 * @param e
	 *            异常
	 */
	public void onReConnectionException(Throwable e) {

	}

	/**
	 *  MQ 自动重连工具ConsumerHelper提供的异常回调
	 */
}
