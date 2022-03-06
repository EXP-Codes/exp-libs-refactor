package exp.libs.socket.nio.server;

import exp.libs.socket.bean.SocketBean;

class NioSocketServerTest {

    public static void main(String[] args) {
        SocketBean sb = new SocketBean();
        sb.setIp("127.0.0.1");
        sb.setPort(9998);

        NioSocketServer server = new NioSocketServer(sb, new NioServerHandler());
        server._start();
    }

}