package exp.libs.socket.nio.client;

import exp.libs.socket.bean.SocketBean;
import exp.libs.utils.concurrent.ThreadUtils;

class NioSocketClientTest {

    public static void main(String[] args) {
        SocketBean sb = new SocketBean();
        sb.setIp("127.0.0.1");
        sb.setPort(9998);

        NioSocketClient client = new NioSocketClient(sb, new NioClientHandler());
        if(client.conn()) {
            client.write("hello server");
        }

        ThreadUtils.tSleep(5000);
        client.close();
    }

}