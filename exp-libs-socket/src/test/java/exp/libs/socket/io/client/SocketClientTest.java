package exp.libs.socket.io.client;

import exp.libs.socket.bean.SocketBean;

class SocketClientTest {

    public static void main(String[] args) {
        SocketBean sb = new SocketBean();
        sb.setIp("127.0.0.1");
        sb.setPort(9998);

        SocketClient client = new SocketClient(sb);
        client.conn();
        System.out.println(client.read());
        client.close();
    }

}