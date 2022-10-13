package exp.libs.utils.time;

import exp.libs.utils.concurrent.ThreadUtils;

class QuickTimerTest {

    public static void main(String[] args) {
        QuickTimer qt = new QuickTimer();
        qt.start("检点1");
        ThreadUtils.tSleep(100);
        qt.stop();
        System.out.println("last: " + qt.lastDiffMillis());
        qt.start("检点2");
        ThreadUtils.tSleep(200);
        qt.stop();
        qt.checkpoint();
        ThreadUtils.tSleep(200);
        qt.checkpoint();
        ThreadUtils.tSleep(300);
        qt.checkpoint();
        ThreadUtils.tSleep(400);
        qt.checkpoint();
        qt.stop();
        System.out.println("all: " + qt.allDiffMillis());
        System.out.println(qt.printHistoryCheckPoints());
    }

}