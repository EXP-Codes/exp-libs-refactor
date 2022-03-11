package exp.libs.portforward;

import exp.libs.sock.socket.io.client.SocketClient;
import exp.libs.sock.socket.io.common.IHandler;
import exp.libs.sock.socket.io.common.ISession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;

class _PFHandler implements IHandler {

	private Logger log = LoggerFactory.getLogger(_PFHandler.class);
	
	/** 端口转发代理服务配置 */
	private PFConfig config;
	
	private String ip;
	
	private int port;
	
	protected _PFHandler(PFConfig config) {
		this.config = config;
		this.ip = config.getRemoteIP();
		this.port = config.getRemotePort();
	}
	
	@Override
	public void _handle(ISession localClient) {
		int overtime = config.getOvertime();
		SocketClient virtualClient = new SocketClient(ip, port, overtime);
		if(!virtualClient.conn()) {
			localClient.close();
			log.warn("会话 [{}] 连接到真实服务端口 [{}:{}] 失败", 
					localClient.ID(), ip, port);
			return;
		}
		
		// 转发本地真实客户端的IO流到虚拟客户端
		Socket localSocket = localClient.getSocket();
		Socket virtualSocket = virtualClient.getSocket();
		new _TranslateData(localClient.ID(), _TranslateData.TYPE_REQUEST,
				overtime, localSocket, virtualSocket).start();	// 请求转发
		new _TranslateData(localClient.ID(), _TranslateData.TYPE_RESPONE,
				overtime, virtualSocket, localSocket).start();	// 响应转发
	}

	@Override
	public IHandler _clone() {
		return new _PFHandler(config);
	}

	@Deprecated
	@Override
	public boolean _login(ISession session) {
		return true;
	}

}
