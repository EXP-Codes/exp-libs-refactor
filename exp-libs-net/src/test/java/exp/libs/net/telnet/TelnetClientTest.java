package exp.libs.net.telnet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class TelnetClientTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * 主方法是拿来做测试用的
     *
     * @param args null
     */
    public static void main(String[] args) {
        String command = "traceroute -w 0.1 -n -q 1  www.baidu.com";
//		command = "ll";
//		command = "ping -c 4 www.baidu.com";
        TelnetClient telnet = null;
        try {
            telnet = new TelnetClient(TelnetClient.PROTOCOL_VT220);

            /* 登录超时 */
            telnet.setConnectTimeOut(3000);

            /* ping 和traceroute 等命令，要注意返回超时设置 */
            telnet.setSoTimeOut(15 * 1000);

            if (telnet.connect("127.0.0.1", 23, "username", "password")) {
                System.out.println("连接成功");

                // col -b 去掉控制符
                String str = telnet.sendCommand(command);

                System.out.println("开始~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                System.out.println(str);

                System.out.println("结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                System.out.println("连接错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            telnet.disConnect();
        }
        System.out.println("程序结束");
    }
}