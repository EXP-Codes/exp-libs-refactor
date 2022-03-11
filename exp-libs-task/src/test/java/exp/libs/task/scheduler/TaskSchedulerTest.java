package exp.libs.task.scheduler;

import exp.libs.task.cron.Cron;

import java.util.HashMap;
import java.util.Map;

class TaskSchedulerTest {

    public static void main(String[] args) {
        DemoJob task = new DemoJob();

        Map<String, String> taskDatas = new HashMap<String, String>();
        taskDatas.put("EXP", "http://exp-blog.com");

        Cron cron = new Cron();
        cron.Second().withStep(5, 6);
        System.out.println(cron.toExpression());

        TaskScheduler ts = new TaskScheduler();
        ts.add("DEMO", task, taskDatas, cron);

        ts._start();
    }

}