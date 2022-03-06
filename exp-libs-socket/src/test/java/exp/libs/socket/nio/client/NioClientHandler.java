package exp.libs.socket.nio.client;

import exp.libs.socket.nio.common.interfaze.IHandler;
import exp.libs.socket.nio.common.interfaze.ISession;

public class NioClientHandler implements IHandler {

	@Override
	public void onSessionCreated(ISession session) throws Exception {
		// Undo
		System.out.println(111);
	}

	@Override
	public void onMessageReceived(ISession session, Object msg)
			throws Exception {
		System.out.println("C-GET:" + msg);
	}

	@Override
	public void onExceptionCaught(ISession session, Throwable exception) {
		exception.printStackTrace();
	}

}
