package exp.libs.utils.time;

import exp.libs.utils.concurrent.ThreadUtils;
import org.junit.jupiter.api.Test;

class QuickTimerTest {

    @Test
    void test() {
        QuickTimer qt = new QuickTimer();
        qt.start("检点1");
        ThreadUtils.tSleep(100);
        qt.stop();
        qt.start("检点2");
        ThreadUtils.tSleep(200);
        qt.stop();
        System.out.println("最后一个 CheckPoint 经过的 ms: " + qt.lastElapsedTime());

        qt.checkpoint("连续检查点 A");
        ThreadUtils.tSleep(200);
        qt.checkpoint("连续检查点 B");
        ThreadUtils.tSleep(300);
        qt.checkpoint();
        ThreadUtils.tSleep(400);
        qt.checkpoint("连续检查点 Z");
        ThreadUtils.tSleep(500);
        qt.stop();
        System.out.println("所有 CheckPoint 经过的 ms: " + qt.totalElapsedTime());

        System.out.println(qt.printAllCheckPoints());
    }

}