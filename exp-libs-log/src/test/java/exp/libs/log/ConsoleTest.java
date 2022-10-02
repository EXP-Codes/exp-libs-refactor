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
    void out() {
        Console.out("out 默认（青色）");
        Console.out(LogColor.BLUE, "out {} {}", "蓝色", "无异常");

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            Console.out(LogColor.WHITE, "out {} {}", "白色", "有异常", e);
        }
    }

    @Test
    void err() {
        Console.err("err 默认（红色）");
        Console.err(LogColor.RED, "err {} {}", "红色", "无异常");

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            Console.err(LogColor.MAGENTA, "err {} {}", "粉色", "有异常", e);
        }
    }
}