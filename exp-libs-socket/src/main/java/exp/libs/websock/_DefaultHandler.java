package exp.libs.websock;

import exp.libs.websock.interfaze.IHandler;
import exp.libs.websock.interfaze.ISession;
import org.java_websocket.handshake.ServerHandshake;

import java.nio.ByteBuffer;

/**
 * <pre>
 * 默认的WebSocket业务逻辑处理器
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class _DefaultHandler implements IHandler {

	@Override
	public void onOpen(ServerHandshake serverhandshake) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterConnect(ISession session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(ByteBuffer byteBuffer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClose(ISession session) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onClose(int code, String reason, boolean remote) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Exception e) {
		// TODO Auto-generated method stub
		
	}

}
