package exp.libs.net.mail;

import exp.libs.envm.Charset;
import exp.libs.envm.SMTP;
import exp.libs.utils.concurrent.ThreadUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    // FIXME mock
    @Test
    public void testSend() {
        Email mail = new Email(
                SMTP._126,
                "xxxxxxxx@126.com",
                "yyyyyyyy",
                "zzzzzzzz@qq.com",
                "desKey",
                Charset.UTF8
        );
        mail.send("无加密无抄送测试", "测试内容A");
        ThreadUtils.tSleep(2000);

        mail.send("加密无抄送测试", "测试内容B", true);
        ThreadUtils.tSleep(2000);

        mail.send("加密抄送测试", "测试内容C",
                new String[] {
                        "cccccccc@qq.com" ,
                        "ssssssss@qq.com"
                },
                true
        );
        ThreadUtils.tSleep(2000);

        mail.debug(true);
        mail.send("重置收件人测试", "测试内容D",
                new String[] { "dddddddd@qq.com" },
                new String[] { "uuuuuuuu@qq.com" },
                true
        );
    }

}