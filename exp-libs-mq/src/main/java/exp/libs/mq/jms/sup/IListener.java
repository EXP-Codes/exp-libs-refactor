package exp.libs.mq.jms.sup;

import javax.jms.MessageListener;

/**
 * 监听接口<br>
 * 使用场景：获取关注的消息内容时使用<br>
 * 步骤: 监听消息时,需要实现该类,并将实现类制定为监听类。<br>
 * 例：consumer.setMessageListener(new Listener());<br>
 * 
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public interface  IListener extends MessageListener{
	//public void onMessage(Message message);
	
	/**
	 * 或许仅仅是为了使用I****来表示接口
	 */
}
