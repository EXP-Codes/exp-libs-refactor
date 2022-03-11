package exp.libs.sock.socket.io.server;


import exp.libs.sock.socket.io.common.IHandler;
import exp.libs.sock.socket.io.common.ISession;

/**
 * <pre>
 * 默认的Socket业务逻辑处理器(IO-阻塞模式)
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class _DefaultHandler implements IHandler {

	@Override
	public boolean _login(ISession session) {
		session.write("login success");
		return true;
	}
	
	@Override
	public void _handle(ISession session) {
		session.write("hello, client:".concat(session.ID()));
	}

	@Override
	public IHandler _clone() {
		return new _DefaultHandler();
	}

}
