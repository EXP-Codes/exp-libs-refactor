package exp.libs.sock.socket.io.server;

import exp.libs.sock.socket.bean.SocketBean;

class SocketServerTest {

    public static void main(String[] args) {
        SocketBean sb = new SocketBean();
        sb.setIp("127.0.0.1");
        sb.setPort(9998);

        SocketServer server = new SocketServer(sb, null);
        server._start();
    }

}