package exp.libs.socket.io.server;

import exp.libs.socket.bean.SocketBean;

class SocketServerTest {

    public static void main(String[] args) {
        SocketBean sb = new SocketBean();
        sb.setIp("127.0.0.1");
        sb.setPort(9998);

        SocketServer server = new SocketServer(sb, null);
        server._start();
    }

}