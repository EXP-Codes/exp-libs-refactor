package exp.libs.log;

import exp.libs.envm.LogColor;
import org.junit.jupiter.api.Test;

/**
 * <PRE>
 * 控制台日志测试
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">www.exp-blog.com</a>
 * @version   2022-10-02
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
class ConsoleTest {

    @Test
    void log() {
        Console.log("默认（灰色）");
        Console.log("黑色", LogColor.BLACK);
        Console.log("红色", LogColor.RED);
        Console.log("绿色", LogColor.GREEN);
        Console.log("黄色", LogColor.YELLOW);
        Console.log("蓝色", LogColor.BLUE);
        Console.log("粉色", LogColor.MAGENTA);
        Console.log("青色", LogColor.CYAN);
        Console.log("白色", LogColor.WHITE);
    }

}