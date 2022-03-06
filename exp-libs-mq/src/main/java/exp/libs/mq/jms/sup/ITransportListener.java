package exp.libs.mq.jms.sup;

import org.apache.activemq.transport.TransportListener;

/**
 * 实时监控连接的接口，对外提供4个调用接口<br/>
 * 
 * <pre>
 * public void onCommand(Object command)<br/>
 * public void onException(IOException error)<br/>
 * public void transportInterupted()<br/>
 * public void transportResumed()<br/>
 * </pre>
 * 
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public interface ITransportListener extends TransportListener {
	/**
	 * 或许仅仅是为了使用I****来表示接口，该接口由ActiveMq提供，能实现以上四类事件的监听。
	 */
}
